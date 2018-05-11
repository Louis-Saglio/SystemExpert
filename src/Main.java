import data_loader.XMLReader;
import engine.Engine;
import org.jdom2.JDOMException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JDOMException, IOException {
        XMLReader xmlReader = new XMLReader("data.xml");
        Engine engine = new Engine();
        engine.setRules(xmlReader.getRules());
        engine.setTruth(xmlReader.getTruth());
        engine.setError(xmlReader.getError());
        engine.process();
    }
}
