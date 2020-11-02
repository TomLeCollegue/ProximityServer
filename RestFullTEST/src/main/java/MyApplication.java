import rest.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( NearbyRest.class );
        h.add(AccountRest.class);
        h.add(ImagesRest.class);
        h.add(FriendsRest.class);
        h.add(HobbiesRest.class);
        return h;
    }
}
