import rest.*;
import serveurNeo4j.Person.GetPerson;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(NearbyRest.class);
        h.add(AccountRest.class);
        h.add(ImagesRest.class);
        h.add(FriendsRest.class);
        h.add(HobbiesRest.class);
        h.add(QuestionsRest.class);
        h.add(SimilarityRest.class);
        return h;
    }
}
