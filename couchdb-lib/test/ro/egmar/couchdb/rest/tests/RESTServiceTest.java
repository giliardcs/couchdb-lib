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

package ro.egmar.couchdb.rest.tests;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import junit.framework.*;
import java.io.StringReader;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import org.w3c.dom.Document;

/**
 *
 * @author egor
 */
public class RESTServiceTest extends TestCase {
    
    public RESTServiceTest (String testName) {
        super (testName);
    }
    
    protected void setUp () throws Exception {
    }
    
    protected void tearDown () throws Exception {
    }
    
    /**
     * Test of getInstance method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testGetInstance () {
        System.out.println ("getInstance");
        
        ro.egmar.couchdb.rest.RESTService result = ro.egmar.couchdb.rest.RESTService.getInstance ();
    }
    
    /**
     * Test of getAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testGetAction () {
        System.out.println ("getAction");
        
        String url = "http://localhost:8888/testdb444/$all_docs";
        
        Source result = ro.egmar.couchdb.rest.RESTService.getAction (url);
    }
    
    /**
     * Test of putAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testPutAction () {
        System.out.println ("putAction");
        
        String url = "http://localhost:8888/testdb4444/";
        String data = "";
        
        Source result = (Source)ro.egmar.couchdb.rest.RESTService.putAction (url, data);
    }
    
    /**
     * Test of postAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testPostAction () {
        System.out.println ("postAction");
        
        String url = "http://localhost:8888/testdb444/";
        String data = "<?xml version=\"1.0\" ?>" +
                "<doc>" +
                "<field id=\"Subject\">" +
                "<text>I like Plankton</text>" +
                "</field>"+
                "</doc>";
        
        Source result = ro.egmar.couchdb.rest.RESTService.postAction (url, data);
    }
    
    /**
     * Test of deleteAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testDeleteAction () {
        System.out.println ("deleteAction");
        
        String url = "http://localhost:8888/testdb444/D294F7E407020151EBE88F5230EC749B";
        
        Source result = ro.egmar.couchdb.rest.RESTService.deleteAction (url);
    }
    
}
