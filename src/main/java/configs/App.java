package configs;

import db.Connection;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class App extends Application {
    public App() {
        Connection.getInstance().getEntityManager();
    }
}
