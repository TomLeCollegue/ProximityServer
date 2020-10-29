package serveurNeo4j;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

public class CreationNode {

	public static boolean CreatePerson(String name, String firstname, String email, int age, String uuid, Driver driver) {
			
			try ( Session session = driver.session() )
	        {
	            String person = session.writeTransaction( new TransactionWork<String>()
	            {
	                @Override
	                public String execute( Transaction tx )
	                {
	                	
	                	Map<String, Object> params = new HashMap<>();
	                	params.put("name", name);
	                	params.put("firstname", firstname);
	                	params.put("email", email);
	                	params.put("age", age );
	                	params.put("uuid", uuid);
	                	
	                    Result result = tx.run( "CREATE (p:Person {name : $name, firstname: $firstname, age: $age, email : $email, uuid : $uuid } )RETURN p.name",
	                            params);
	                    return result.single().get( 0 ).asString();
	                    
	                }
	            } );
	            System.out.println( person );
	            return true;
	        }
			catch (Exception e) {
				return false;
			}
		}

	public static boolean CreateHobby(String name, Driver driver) {
			
			try ( Session session = driver.session() )
	        {
	            String hobby = session.writeTransaction( new TransactionWork<String>()
	            {
	                @Override
	                public String execute( Transaction tx )
	                {
	                	
	                	Map<String, Object> params = new HashMap<>();
	                	params.put("name",name);
	                    Result result = tx.run( "CREATE (h:Hobby {name : $name})RETURN h.name",
	                            params);
	                    return result.single().get( 0 ).asString();
	                    
	                }
	            } );
	            System.out.println( hobby );
	            return true;
	        }
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	
}
