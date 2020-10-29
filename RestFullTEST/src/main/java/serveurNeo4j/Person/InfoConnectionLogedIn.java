package serveurNeo4j.Person;

public class InfoConnectionLogedIn {

    private String name;
    private String firstname;
    private String email;
    private String uuid;
    private int age;

    public InfoConnectionLogedIn(String name, String firstname, String email, String uuid, int age) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.uuid = uuid;
        this.age = age;
    }

    public InfoConnectionLogedIn() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "InfoConnectionLogedIn{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", uuid='" + uuid + '\'' +
                ", age=" + age +
                '}';
    }
}
