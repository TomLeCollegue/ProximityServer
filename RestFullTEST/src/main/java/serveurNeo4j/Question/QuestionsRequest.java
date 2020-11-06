package serveurNeo4j.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
import serveurNeo4j.Hobby.Hobby;

import static org.neo4j.driver.Values.parameters;

public class QuestionsRequest {


	
	public static boolean CreateQuestions(String uuid, String question, String choice1, String choice2, String choice3, String answer, String hobby, String uuidQuestion, Driver driver) {


		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("uuid",uuid);
                	params.put("question", question);
                	params.put("choice1", choice1);
                	params.put("choice2", choice2);
                	params.put("choice3", choice3);
                	params.put("answer", answer);
                	params.put("hobby", hobby);
                	params.put("uuidQuestion", uuidQuestion);
                	
                    Result result = tx.run( "MATCH (a:Person {uuid : $uuid }), (h:Hobby {name: $hobby})" +
                    		" CREATE (q:Question {text : $question, choice1: $choice1, choice2: $choice2, choice3: $choice3, answer: $answer, uuid: $uuidQuestion, hobby: $hobby})" +
                    		" CREATE (a)-[rq:QUESTION]->(q)-[rh:HOBBY]->(h) " +
							" RETURN a.name ",
                            params);
                    return result.single().get( 0 ).asString();
                    
                }
            } );
            System.out.println( relation );
            return true;
        }
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public static ArrayList<Question> GetQuestionsByUuid (String uuid, Driver driver){

		Session session = driver.session();
		String cypherQuery  =   "match(p:Person {uuid : $uuid})-[qr:QUESTION]-(q:Question)-[hr:HOBBY]-(h:Hobby)" +
				"return q";
		ArrayList<Question> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("uuid", uuid));
		while (result.hasNext()) {
			Question question = new Question();
			Map<String,Object> map =  result.next().fields().get(0).value().asMap();

			question.setText(map.get("text").toString());
			question.setChoice1(map.get("choice1").toString());
			question.setChoice2(map.get("choice2").toString());
			question.setChoice3(map.get("choice3").toString());
			question.setAnswer(map.get("answer").toString());
			question.setUuid(uuid);
			question.setHobby(map.get("hobby").toString());
			question.setUuidQuestion(map.get("uuid").toString());



			list.add(question);
		}
		return list;
	}

	public static String ModifQuestion(Question question,  Driver driver) {

		try ( Session session = driver.session() )
		{
			String relation = session.writeTransaction( new TransactionWork<String>()
			{
				@Override
				public String execute( Transaction tx )
				{

					Map<String, Object> params = new HashMap<>();
					params.put("uuid", question.getUuidQuestion());
					params.put("question", question.getText());
					params.put("choice1", question.getChoice1());
					params.put("choice2", question.getChoice2());
					params.put("choice3", question.getChoice3());
					params.put("answer", question.getAnswer());

					Result result = tx.run( "MATCH (q:Question {uuid : $uuid}) " +
									"SET q.text = $question, q.choice1 = $choice1, q.choice2 = $choice2, q.choice3 = $choice3, q.answer = $answer " +
									"return q.text" ,
							params);
					return result.single().get( 0 ).asString();

				}
			} );
			System.out.println( relation );
			return relation;
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public static boolean AnswerRelation(String uuidPerson, String uuidQuestion, boolean answer, Driver driver) {


		try ( Session session = driver.session() )
		{
			String relation = session.writeTransaction( new TransactionWork<String>()
			{
				@Override
				public String execute( Transaction tx )
				{

					Map<String, Object> params = new HashMap<>();
					params.put("uuidPerson",uuidPerson);
					params.put("uuidQuestion", uuidQuestion);
					params.put("answer", answer);

					Result result = tx.run( "MATCH (p:Person {uuid : $uuidPerson }), (q:Question { uuid: $uuidQuestion })" +
									" CREATE (p)-[a:ANSWERED { response : $answer }]->(q) " +
									" RETURN p.name ", params);
					return result.single().get( 0 ).asString();

				}
			} );
			System.out.println( relation );
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
