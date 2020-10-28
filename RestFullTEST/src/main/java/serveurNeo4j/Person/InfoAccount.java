package serveurNeo4j.Person;

public class InfoAccount {
    private String mail;
    private String password;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InfoAccount(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public InfoAccount() {
    }

    @Override
    public String toString() {
        return "InfoAccount{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
