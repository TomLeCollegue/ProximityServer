package serveurNeo4j.Person;

import static org.neo4j.driver.Values.parameters;

import java.util.ArrayList;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.internal.value.IntegerValue;

public class GetPerson {
	public static ArrayList<Person> getPersonbyEmail(String email, Driver driver) {
		Session session = driver.session();
		String cypherQuery  = "match(p:Person {email : $email}) return p";
		ArrayList<Person> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("email", email));
		while (result.hasNext()) {
			Person person = new Person();
			Map<String,Object> map =  result.next().fields().get(0).value().asMap();
			//create Person
			person.setEmail(map.get("email").toString());
			person.setName(map.get("name").toString());
			person.setFirstname(map.get("firstname").toString());
			person.setAge(Integer.valueOf(map.get("age").toString()));
			list.add(person);

		}
		
		System.out.println(list.toString());
		return list;
	}
	
	public static ArrayList<Object> getPersonbyName(String name, Driver driver) {
		Session session = driver.session();
		String cypherQuery  = "match(p:Person {name : $name}) return p";
		ArrayList<Object> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("name", name));
		while (result.hasNext()) {
			Person person = new Person();
			Map<String,Object> map =  result.next().fields().get(0).value().asMap();
			//create Person
			person.setEmail(map.get("email").toString());
			person.setName(map.get("name").toString());
			person.setFirstname(map.get("firstname").toString());
			person.setAge(Integer.valueOf(map.get("age").toString()));
			list.add(person);
		}
		
		System.out.println(list);
		return list;
	}
	
	public static ArrayList<Object> getPersonbyFirstname(String firstname, Driver driver) {
		Session session = driver.session();
		String cypherQuery  = "match(p:Person {firstname : $firstname}) return p";
		ArrayList<Object> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("firstname", firstname));
		while (result.hasNext()) {
			Person person = new Person();
			Map<String,Object> map =  result.next().fields().get(0).value().asMap();
			//create Person
			person.setEmail(map.get("email").toString());
			person.setName(map.get("name").toString());
			person.setFirstname(map.get("firstname").toString());
			person.setAge(Integer.valueOf(map.get("age").toString()));
			list.add(person);
		}
		
		System.out.println(list);
		return list;
	}
	
	public static ArrayList<Object> getPersonbyAge(int age, Driver driver) {
		Session session = driver.session();
		String cypherQuery  = "match(p:Person {age : $age}) return p";
		ArrayList<Object> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("age", age));
		while (result.hasNext()) {
			Person person = new Person();
			Map<String,Object> map =  result.next().fields().get(0).value().asMap();
			//create Person
			person.setEmail(map.get("email").toString());
			person.setName(map.get("name").toString());
			person.setFirstname(map.get("firstname").toString());
			person.setAge(Integer.valueOf(map.get("age").toString()));
			list.add(person);
		}
		
		System.out.println(list);
		return list;
	}
	
	
	public static ArrayList<Object> getFriends(String email, Driver driver) {
		Session session = driver.session();
		String cypherQuery  = "match(p:Person {email : $email})-[:FRIENDS]-(p2:Person) return p2";
		ArrayList<Object> list = new ArrayList<>();
		Result result = session.run(cypherQuery, parameters("email", email));
		while (result.hasNext()) {
			Person person = new Person();
			Map<String,Object> map =  result.next().fields().get(0).value().asMap();
			//create Person
			person.setEmail(map.get("email").toString());
			person.setName(map.get("name").toString());
			person.setFirstname(map.get("firstname").toString());
			person.setAge(Integer.valueOf(map.get("age").toString()));
			list.add(person);
		}
		System.out.println("returning friend of " + email + " " + list);
		return list;
	}
	
	
	
	
	
	
	
}
