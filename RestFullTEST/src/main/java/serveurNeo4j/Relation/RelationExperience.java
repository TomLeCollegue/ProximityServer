package serveurNeo4j.Relation;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

public class RelationExperience {

public static boolean CreateRelationShipExperience(String email, String hobby,  Driver driver) {
		
		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("email",email);
                	params.put("hobby",hobby);
                    Result result = tx.run( "MATCH (a:Person),(b:Hobby)" + 
                    		"WHERE a.email = $email AND b.name = $hobby " + 
                    		"CREATE (a)-[r:EXPERIENCE {points : 0}]->(b) RETURN b.name" ,
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
	
	public static boolean AddExperience(String email, String hobby, int incr,  Driver driver) {
		
		try ( Session session = driver.session() )
	    {
	        String relation = session.writeTransaction( new TransactionWork<String>()
	        {
	            @Override
	            public String execute( Transaction tx )
	            {
	            	
	            	Map<String, Object> params = new HashMap<>();
	            	params.put("email",email);
	            	params.put("hobby",hobby);
	            	params.put("incr", incr);
	                Result result = tx.run( "MATCH (p:Person {email: $email})-[e:EXPERIENCE]-(h:Hobby {name : $hobby})" +
	                		"SET e.points = (e.points+ $incr) return h.name" ,
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
