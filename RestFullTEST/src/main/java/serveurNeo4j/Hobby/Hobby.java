package serveurNeo4j.Hobby;

public class Hobby {


    private String name;
    private int xp;

    public Hobby(String name, int xp) {
        this.name = name;
        this.xp = xp;
    }

    public Hobby() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", xp=" + xp +
                '}';
    }
}
