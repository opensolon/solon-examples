
package demo3081.client;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


@WebServiceClient(name = "WsInterface", targetNamespace = "http://impl.xcc.com/", wsdlLocation = "http://localhost:8888/service-ws/demo?wsdl")
public class WsInterfaceImplService extends Service {

    private final static URL WSINTERFACEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSINTERFACEIMPLSERVICE_EXCEPTION;
    private final static QName WSINTERFACEIMPLSERVICE_QNAME = new QName("http://impl.xcc.com/", "WsInterface");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/service-ws/demo?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSINTERFACEIMPLSERVICE_WSDL_LOCATION = url;
        WSINTERFACEIMPLSERVICE_EXCEPTION = e;
    }

    public WsInterfaceImplService() {
        super(__getWsdlLocation(), WSINTERFACEIMPLSERVICE_QNAME);
    }

    public WsInterfaceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSINTERFACEIMPLSERVICE_QNAME, features);
    }

    public WsInterfaceImplService(URL wsdlLocation) {
        super(wsdlLocation, WSINTERFACEIMPLSERVICE_QNAME);
    }

    public WsInterfaceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSINTERFACEIMPLSERVICE_QNAME, features);
    }

    public WsInterfaceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsInterfaceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "WsInterfacePort")
    public WsInterface getWsInterfacePort() {
        return super.getPort(new QName("http://impl.xcc.com/", "WsInterfacePort"), WsInterface.class);
    }

    @WebEndpoint(name = "WsInterfacePort")
    public WsInterface getWsInterfacePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.xcc.com/", "WsInterfacePort"), WsInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSINTERFACEIMPLSERVICE_EXCEPTION != null) {
            throw WSINTERFACEIMPLSERVICE_EXCEPTION;
        }
        return WSINTERFACEIMPLSERVICE_WSDL_LOCATION;
    }
}
