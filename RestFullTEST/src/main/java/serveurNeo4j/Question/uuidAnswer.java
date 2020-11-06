package serveurNeo4j.Question;

public class uuidAnswer {
    private String uuid;
    private boolean bool;



    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public uuidAnswer(String uuid, boolean bool) {
        this.uuid = uuid;
        this.bool = bool;
    }

    public uuidAnswer() {
    }

    @Override
    public String toString() {
        return "uuidAnswer{" +
                "uuid='" + uuid + '\'' +
                ", bool=" + bool +
                '}';
    }
}
