/*
 * RESTService.java
 *
 * Created on September 16, 2006, 2:28 PM
 *
 */

package ro.egmar.couchdb.rest;

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
public class RESTService {
    private JAXBContext jc;
    private static final QName qname = new QName("","");
    
    private RESTService() {
    }
    
    private static class RESTServiceHolder {
        private static RESTService instance = new RESTService();
    }
    
    public static RESTService getInstance() {
        return RESTServiceHolder.instance;
    }
    
    /** Execute GET request */
    public static Source getAction(String url) {
        Service service = Service.create(qname);
	service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "GET");
        Source result = dispatcher.invoke(null);
        return result;
    }
    
    /** Execute PUT request */
    public static Source putAction(String url, String data) {
        Service service = Service.create(qname);
	service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "PUT");
        Source result;
        if (null == data || data.equalsIgnoreCase (""))
            result = dispatcher.invoke(new StreamSource(new StringReader("<node></node>")));
        else
            result = dispatcher.invoke(new StreamSource(new StringReader(data)));
        return result;
    }
    
    /** Execute POST request */
    public static Source postAction(String url, String data) {
        Service service = Service.create(qname);
        service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "POST");
        Source result = dispatcher.invoke(new StreamSource(new StringReader(data)));
        return result;
    }
    
    /** Execute DELETE request */
    public static Source deleteAction(String url) {
        Service service = Service.create(qname);
	service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "DELETE");
        Source result = dispatcher.invoke(null);
        return result;
    }
}
