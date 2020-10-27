package serveurNeo4j.Question;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

public class QuestionsRequest {
	
	public static boolean CreateQuestions(String emailPerson, String question, String choice1, String choice2, String choice3, String answer, String hobby, Driver driver) {


		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("email",emailPerson);
                	params.put("question", question);
                	params.put("choice1", choice1);
                	params.put("choice2", choice2);
                	params.put("choice3", choice3);
                	params.put("answer", answer);
                	params.put("hobby", hobby);
                	
                    Result result = tx.run( "MATCH (a:Person {email : $email }), (h:Hobby {name: $hobby })" +
                    		" CREATE (q:Question {text : $question, choice1: $choice1, choice2: $choice2, choice3: $choice3, answer: $answer})" +
                    		" CREATE (a)-[rq:QUESTION]->(q)-[rh:HOBBY]->(h) RETURN a.name" ,
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


	public static boolean CreateQuestions(Question question, Driver driver) {

		String emailPerson = question.getPerson().getEmail();
		String text = question.getText();
		String choice1 = question.getChoice1();
		String choice2 = question.getChoice2();
		String choice3 = question.getChoice3();
		String answer = question.getAnswer();
		String hobby = question.getHobby().getName();

		try ( Session session = driver.session() )
		{
			String relation = session.writeTransaction( new TransactionWork<String>()
			{
				@Override
				public String execute( Transaction tx )
				{

					Map<String, Object> params = new HashMap<>();
					params.put("email",emailPerson);
					params.put("question", text);
					params.put("choice1", choice1);
					params.put("choice2", choice2);
					params.put("choice3", choice3);
					params.put("answer", answer);
					params.put("hobby", hobby);

					Result result = tx.run( "MATCH (a:Person {email : $email }), (h:Hobby {name: $hobby })" +
									" CREATE (q:Question {text : $question, choice1: $choice1, choice2: $choice2, choice3: $choice3, answer: $answer})" +
									" CREATE (a)-[rq:QUESTION]->(q)-[rh:HOBBY]->(h) RETURN a.name" ,
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


}
