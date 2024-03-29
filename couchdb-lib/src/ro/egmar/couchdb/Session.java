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
import javax.xml.transform.dom.DOMResult;
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
    
    /** 
     * Creates a new database with the given name 
     *
     * @param name must contain lowercase characters (a-z), digits (0-9), or any of these characters `_$()+-/` and must end with a slash.  
     */
    public void createDatabase(String name) {
        String url = "http://"+this.hostname+":"+this.port+"/"+name.toLowerCase(Locale.ENGLISH)+"/";
        RESTService.getInstance().putAction(url,"");
    }
    
    /** 
     * Return a list with names of databases available 
     * on CouchDb server. Usually, used for in front ends.
     *
     * @return  List<String>    a list with names of available databases
     * @see                     List
     */
    public List<String> getAllDatabases() {
        String url = "http://"+this.hostname+":"+this.port+"/$all_dbs";
        Source result = RESTService.getInstance().getAction(url);
        
        DOMResult domResult = new DOMResult();
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.transform(result, domResult);
        
        return null;
    }
    
    /** 
     * Returns an Database object. Name argument must contain
     * lowercase characters (a-z), digits (0-9), or any of 
     * these characters `_$()+-/` and must end with a slash.
     *
     * @param   name    an database name
     * @return          the database with specified name
     * @see             ro.egmar.couchdb.Database
     */
    public Database getDatabaseByName(String name) {
        return null;
    }
}
