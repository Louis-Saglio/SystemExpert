import data_loader.XMLReader;
import engine.Engine;
import engine.Proposition;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JDOMException, IOException {
        XMLReader xmlReader = new XMLReader("data.xml");
        Engine engine = new Engine();
        engine.setRules(xmlReader.getRules());
        engine.setTruth(xmlReader.getTruth());
        engine.setError(xmlReader.getError());

        while (engine.getFinals().size() == 0) {
            engine.process();
            Proposition toBeAsked = engine.choosePropositionToAsk();
            if (toBeAsked == null) {
                System.out.println("Toutes les règles ont été validées.");
                break;
            }
            System.out.println("Est-ce que " + toBeAsked.toString() + " ?  (y/n)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("y")) {
                engine.getTruth().add(toBeAsked);
            } else if (input.equals("n")) {
                engine.getError().add(toBeAsked);
            }
        }
    }
}
