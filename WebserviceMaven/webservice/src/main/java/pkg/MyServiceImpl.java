package pkg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "pkg.MyService")
@HandlerChain(file = "handlers.xml")
public class MyServiceImpl implements MyService {

    @Override
    public String sayHello(String name) {
        if (name == null || name.trim().length() <= 0)
            throw new IllegalArgumentException("name");

        System.out.println("Going to say Hellow to " + name);
        return "Hello " + name + "!";
    }

    @SuppressWarnings("deprecation")
    @Override
    public Person getPerson(long id) {
        Person person = new Person();
        person.setId(id);
        person.setName("Vinod Singh");
        person.setDateOfBirth(new Date(1978, 4, 9));

        System.out.println("Serving getPerson(" + id + "): " + person);

        return person;
    }

    @Override
    public String xmlData(String data) {
        System.out.println("Received XML data from client: " + data);
        return "<greeting>" + "Hello! " + data.substring(data.indexOf(">") + 1, data.lastIndexOf("<")) + "</greeting>";
    }

    @Override
    public String getPurchaseOrder() {
        StringBuilder data = new StringBuilder(2048);
        try {
            BufferedReader fReader = new BufferedReader(new InputStreamReader(MyServiceImpl.class
                    .getResourceAsStream("/PurchaseOrder.xml")));
            String line;
            do {
                line = fReader.readLine();
                if (line != null)
                    data.append(line).append("\n");
            } while (line != null);
        } catch (Exception e) {
            e.printStackTrace();
            data.append(e.getMessage());
        }
        return data.toString();
    }
}
