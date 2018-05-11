package data_loader;

import engine.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class XMLReader {

    public XMLReader() throws JDOMException, IOException {
        this.read();
    }

    public void read() throws JDOMException, IOException {
        File dataFile = new File("data.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(dataFile);
        Element root = document.getRootElement();

        HashMap<String, Property> properties = new HashMap<>();
        List<Element> propertyElements = root.getChild("properties").getChildren();
        for (Element propertyElement : propertyElements) {
            Property property = new Property(propertyElement.getChild("name").getValue());
            List<Element> valueElements = propertyElement.getChild("values").getChildren("value");
            for (Element valueElement : valueElements) {
                new Value(property, valueElement.getValue());
            }
            properties.put(propertyElement.getAttributeValue("id"), property);
        }

        HashMap<String, Proposition> propositions = new HashMap<>();
        List<Element> propositionElements = root.getChild("propositions").getChildren("proposition");
        for (Element propositionElement : propositionElements) {
            Element factElement = propositionElement.getChild("fact");
            Property property = properties.get(factElement.getChild("property").getAttributeValue("ref"));
            int valueIndex = Integer.parseInt(factElement.getChild("value").getAttributeValue("ref"));
            Fact fact = new Fact(property, property.get(valueIndex));
            Proposition proposition = new Proposition(fact, propositionElement.getChild("state").getValue().equals("true"));
            propositions.put(propositionElement.getAttributeValue("id"), proposition);
        }

        Rules rules = new Rules();
        List<Element> ruleElements = root.getChild("rules").getChildren("rule");
        for (Element ruleElement : ruleElements) {
            Rule rule = new Rule();
            for (Element majorElement : ruleElement.getChild("majors").getChildren("major")) {
                rule.getMajors().add(propositions.get(majorElement.getAttributeValue("ref")));
            }
            for (Element conclusionElement : ruleElement.getChild("conclusions").getChildren("conclusion")) {
                rule.getConclusions().add(propositions.get(conclusionElement.getAttributeValue("ref")));
            }
            rules.add(rule);
        }
        System.out.println(rules);

    }

}
