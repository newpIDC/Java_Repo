package client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceClient;

import wsclient.*;

/**
 * Servlet implementation class WsClient
 */
public class WsClient {

    public static void main(String[] args) {
        String name = "Vinod Singh";
        String id = "0031";
        try {
            // Get a handle to web service client interface
            WebServiceClient ann = MyServiceImplService.class.getAnnotation(WebServiceClient.class);
            MyServiceImplService service = new MyServiceImplService(new URL("http://localhost:8080/webservice/myService"),
                    new QName(ann.targetNamespace(), ann.name()));
            MyService myService = service.getMyServiceImplPort();

            // Invoke methods
            if (name != null) {
                String hello = myService.sayHello(name);
                System.out.println("nameResult" + hello);
            }

            if (id != null) {
                Person person = myService.getPerson(Long.parseLong(id));
                String idResult = "Person [id: " + person.getId() + ", name: " + person.getName() + ", Date of Birth: "
                        + person.getDateOfBirth() + "]";
                System.out.println("idResult " + idResult);
            }

            // now try to send XML String
            String xml = "<name>vinod</name>";
            String returnXml = myService.xmlData(xml);
            System.out.println(returnXml);

            // Now receive a big XML from service
            String po = myService.getPurchaseOrder();
            System.out.println("PURCHASE ORDER\n" + po);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
