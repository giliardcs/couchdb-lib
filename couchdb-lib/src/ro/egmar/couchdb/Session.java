/*
 * Session.java
 *
 * Created on September 16, 2006, 1:43 PM
 *
 */

package ro.egmar.couchdb;

import java.util.List;

/**
 *
 * @author egor
 */
public class Session {
    String hostname;
    String port;
    Boolean isSecure;
    
    /** Creates a new instance of Session */
    public Session (String hostname, String port, Boolean isSecure) {
        this.hostname = hostname;
        this.port = port;
        this.isSecure = isSecure;
    }
    
    /** Creates a new database */
    public void createDatabase(String name) {
        
    }
    
    /** Returns list of databases name */
    public List<String> getAllDatabases() {
        return null;
    }
}
