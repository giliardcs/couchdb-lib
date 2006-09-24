/** 
 * CouchDB-lib is an open-source Java API for working with CouchDB.
 * Copyright (C) 2006  Egor Margineanu (egor.margineanu@gmail.com)

 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

package ro.egmar.couchdb;

import java.io.StringWriter;
import java.util.List;
import java.util.Locale;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import ro.egmar.couchdb.rest.RESTService;

/**
 *
 * @author egor
 */
public class Session {
    String hostname;
    String port;
    Boolean isSecure;
    
    public Session() {
    }
    
    /** Creates a new instance of Session */
    public Session (String hostname, String port, Boolean isSecure) {
        this.initSession (hostname, port, isSecure);
    }
    
    public void initSession(String hostname, String port, Boolean isSecure) {
        this.hostname = hostname;
        this.port = port;
        this.isSecure = isSecure;
    }
    
    /** Creates a new database */
    public void createDatabase(String name) {
        String url = "http://"+this.hostname+":"+this.port+"/"+name.toLowerCase(Locale.ENGLISH)+"/";
        RESTService.getInstance().putAction(url,"");
    }
    
    /** Returns list of databases name */
    public List<String> getAllDatabases() {
        String url = "http://"+this.hostname+":"+this.port+"/$all_dbs";
        Source result = RESTService.getInstance().getAction(url);
        
        return null;
    }
}
