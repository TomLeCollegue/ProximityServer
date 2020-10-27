package serveurNeo4j;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import serveurNeo4j.accounts.Accounts;

public class serverMain {
	
	
	public static Driver driver;
	
	
	public static void main(String[] args) throws Exception {




		//Accounts.CreateUser("TTTomKubasik74200@gmail.com", "testpass");

		//connection to the neo4j database
		driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "1234"));


		
		//CreationNode.CreatePerson("Le deuxieme bouf", "LOLO", "nathankubasik@gmail.com", 23, driver);
		//RelationExperience.CreateRelationShipExperience("nathankubasik@gmail.com", "JAVA", driver);
		//RelationExperience.AddExperience("nathankubasik@gmail.com", "JAVA",20, driver);
		//creationNodes.CreateHobby("JAVA", driver);
		//GetPerson.getPersonbyEmail("nathankubasik@gmail.com", driver);
		//RelationFriends.CreateRelationShipFormerFriends("lebouf@gmail.com", "lebouf2@gmail.com", driver);
		//RelationFriends.CreateRelationShipFriends("lebouf@gmail.com", "lebouf2@gmail.com", driver);
		//RelationTOP4.RemoveRelationShipTOP4("nathankubasik@gmail.com", "JAVA", driver)
		//GetPerson.getFriends("lebouf@gmail.com", driver);

		//QuestionsRequest.CreateQuestions("lebouf@gmail.com","quel est le plus bouf des bouf ?", "sam", "lolo", "simon","talbouf", "JAVA", driver);
		////driver.close();

	}

}
