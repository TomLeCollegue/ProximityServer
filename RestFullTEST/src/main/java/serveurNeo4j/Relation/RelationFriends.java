package serveurNeo4j.Relation;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;


public class RelationFriends {

	public static boolean CreateRelationShipFriends(String email1, String email2,  Driver driver) {
		
		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("email1",email1);
                	params.put("email2",email2);
                	params.put("date", java.time.LocalDate.now());
                    Result result = tx.run( "MATCH (a:Person),(b:Person)" + 
                    		"WHERE a.email = $email1 AND b.email = $email2 " + 
                    		"CREATE (a)-[r:FRIENDS {date : $date}]->(b) RETURN b.name" ,
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
	
	public static boolean RemoveRelationShipFriends(String email1, String email2,  Driver driver) {
			
		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("email1",email1);
                	params.put("email2",email2);
                    Result result = tx.run( "MATCH (a:Person)-[r:FRIENDS]-(b:Person)" + 
                    		"WHERE a.email = $email1 AND b.email = $email2 " + 
                    		"DELETE r RETURN b.name" ,
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
	
public static boolean CreateRelationShipFormerFriends(String email1, String email2,  Driver driver) {
		
		try ( Session session = driver.session() )
        {
            String relation = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                	
                	Map<String, Object> params = new HashMap<>();
                	params.put("email1",email1);
                	params.put("email2",email2);
                    Result result = tx.run( "MATCH (a:Person),(b:Person)" + 
                    		"WHERE a.email = $email1 AND b.email = $email2 " + 
                    		"CREATE (a)-[r:FORMER_FRIENDS]-(b) RETURN b.name" ,
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
