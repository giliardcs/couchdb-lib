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
import javax.xml.ws.http.HTTPException;
import ro.egmar.couchdb.common.ErrorCode;

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
    public static Object putAction(String url, String data) {
        Service service = Service.create(qname);
	service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname, Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "PUT");
        Source result = null;
        try {
            if (null == data || data.equalsIgnoreCase (""))
                result = dispatcher.invoke(new StreamSource(new StringReader("<node></node>")));
            else
                result = dispatcher.invoke(new StreamSource(new StringReader(data)));
        } catch (HTTPException e) {
            switch(e.getStatusCode ()) {
                case 409: 
                    return ErrorCode.DB_ALREADY_EXISTS;
                case 404:
                    return ErrorCode.DB_NOT_FOUND;
                default:
                    break;
            }
        }
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
