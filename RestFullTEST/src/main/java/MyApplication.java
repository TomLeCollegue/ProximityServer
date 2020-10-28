import serveurNeo4j.AccountRest;
import serveurNeo4j.accounts.Accounts;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( PersonRest.class );
        h.add(AccountRest.class);
        return h;
    }
}