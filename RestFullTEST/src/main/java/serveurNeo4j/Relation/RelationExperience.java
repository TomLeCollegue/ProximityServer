package serveurNeo4j.Relation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;
import serveurNeo4j.Hobby.Hobby;
import serveurNeo4j.Person.Person;

import static org.neo4j.driver.Values.parameters;

public class RelationExperience {

public static boolean CreateRelationShipExperience(String uuid, String hobby,  Driver driver) {
		
		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("uuid",uuid);
                	params.put("hobby",hobby);
                    Result result = tx.run( "MATCH (a:Person {uuid : $uuid}),(b:Hobby{name : $hobby})" +
									" WHERE NOT (a)-[:EXPERIENCE]->(b) " +
									" CREATE (a)-[r:EXPERIENCE {points : 0}]->(b) " +
									" RETURN b.name" ,
                            params);
                    return "done";

                    
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
	
	public static boolean AddExperience(String uuid, String hobby, int incr,  Driver driver) {
		
		try ( Session session = driver.session() )
	    {
	        String relation = session.writeTransaction( new TransactionWork<String>()
	        {
	            @Override
	            public String execute( Transaction tx )
	            {
	            	
	            	Map<String, Object> params = new HashMap<>();
	            	params.put("uuid",uuid);
	            	params.put("hobby",hobby);
	            	params.put("incr", incr);
	                Result result = tx.run( "MATCH (p:Person {uuid: $uuid})-[e:EXPERIENCE]-(h:Hobby {name : $hobby})" +
	                		"SET e.points = (e.points+ $incr) return h.name" ,
	                        params);
	                return "done";
	                
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


	public static ArrayList<Hobby> GetHobbyByUuid (String uuid, Driver driver){

		Session session = driver.session();
		String cypherQuery  =   "match(p:Person {uuid : $uuid})-[e:EXPERIENCE]-(h:Hobby)" +
				"return h.name as name,e.points as points";
		ArrayList<Hobby> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("uuid", uuid));
		while (result.hasNext()) {
			Hobby hobby = new Hobby();
			Map<String,Object> map = (result.next().asMap());
			hobby.setName(map.get("name").toString());
			hobby.setXp(Integer.valueOf(map.get("points").toString()));

			list.add(hobby);
		}
		System.out.println("returning friend of " + uuid + " " + list);
		return list;
	}

	public static ArrayList<Hobby> GetHobbyInCommun (String uuid, String email, Driver driver){

		Session session = driver.session();
		String cypherQuery  =   "match(p:Person {uuid : $uuid})-[e1:EXPERIENCE]-(h:Hobby)-[e2:EXPERIENCE]-(p2:Person {email : $email})" +
			"return h.name as name, e2.points as points Order by points DESC LIMIT 5";
		ArrayList<Hobby> list = new ArrayList<>();

		Map<String, Object> params = new HashMap<>();
		params.put("uuid",uuid);
		params.put("email",email);

		Result result = session.run(cypherQuery, params);
		while (result.hasNext()) {
			Hobby hobby = new Hobby();
			Map<String,Object> map = (result.next().asMap());
			hobby.setName(map.get("name").toString());
			hobby.setXp(Integer.valueOf(map.get("points").toString()));

			list.add(hobby);
		}
		System.out.println("returning friend of " + uuid + " " + list);
		return list;
	}


	public static ArrayList<Hobby> GetAllHobbies (Driver driver){

		Session session = driver.session();
		String cypherQuery  = "match(h:Hobby)" +
				"return h.name as name";
		ArrayList<Hobby> list = new ArrayList<>();
		Result result = session.run(cypherQuery);
		while (result.hasNext()) {
			Hobby hobby = new Hobby();
			Map<String,Object> map = (result.next().asMap());
			hobby.setName(map.get("name").toString());

			list.add(hobby);
		}
		return list;




	}


	public static String CreateRelationShipExperienceWhenAnswerQuestion(String uuidPerson, String uuidQuestion,  Driver driver) {

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
					Result result = tx.run( "MATCH (a:Person {uuid : $uuidPerson}),(q:Question { uuid: $uuidQuestion })-[:HOBBY]-(b:Hobby)" +
									" WHERE NOT (a)-[:EXPERIENCE]->(b) " +
									" CREATE (a)-[r:EXPERIENCE {points : 0}]->(b) " +
									" RETURN b.name" ,
							params);
					return "done";




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




}
