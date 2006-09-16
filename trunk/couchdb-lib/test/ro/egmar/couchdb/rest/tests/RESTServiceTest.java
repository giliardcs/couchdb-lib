/*
 * RESTServiceTest.java
 * JUnit based test
 *
 * Created on September 16, 2006, 3:38 PM
 */

package ro.egmar.couchdb.rest.tests;

import junit.framework.*;
import java.io.StringReader;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

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
        System.out.println("getInstance");
        
        ro.egmar.couchdb.rest.RESTService result = ro.egmar.couchdb.rest.RESTService.getInstance();
    }

    /**
     * Test of getAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testGetAction () {
        System.out.println("getAction");
        
        String url = "http://localhost:8888/$all_dbs";
        
        Source result = ro.egmar.couchdb.rest.RESTService.getAction(url);

    }

    /**
     * Test of putAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    public void testPutAction () {
        System.out.println("putAction");
        
        String url = "http://localhost:8888/testdb4444/";
        String data = "";
        
        Source result = ro.egmar.couchdb.rest.RESTService.putAction(url, data);
    }

    /**
     * Test of postAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    /*public void testPostAction () {
        System.out.println("postAction");
        
        String url = "http://localhost:8888/";
        String data = "";
        
        Source result = ro.egmar.couchdb.rest.RESTService.postAction(url, data);
    }*/

    /**
     * Test of deleteAction method, of class ro.egmar.couchdb.rest.RESTService.
     */
    /*public void testDeleteAction () {
        System.out.println("deleteAction");
        
        String url = "http://localhost:8888/testdb/";
        
        Source result = ro.egmar.couchdb.rest.RESTService.deleteAction(url);
    }*/
    
}
