package data_loader;

import engine.*;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class XMLReader {
    
    private Rules rules;
    private HashSet<Proposition> truth, error;
    private Element root;
    private HashMap<String, Property> properties;
    private HashMap<String, Proposition> propositions;

    public XMLReader(String file) throws JDOMException, IOException {
        this.root = new SAXBuilder().build(new File(file)).getRootElement();
    }

    private HashMap<String, Property> getProperties() {
        if (this.properties == null) {
            this.properties = new HashMap<>();
            List<Element> propertyElements = this.root.getChild("properties").getChildren();
            for (Element propertyElement : propertyElements) {
                Property property = new Property(propertyElement.getChild("name").getValue());
                List<Element> valueElements = propertyElement.getChild("values").getChildren("value");
                for (Element valueElement : valueElements) {
                    new Value(property, valueElement.getValue());
                }
                this.properties.put(propertyElement.getAttributeValue("id"), property);
            }
        }
        return this.properties;
    }

    private HashMap<String, Proposition> getPropositions() {
        if (this.propositions == null) {
            this.propositions = new HashMap<>();
            List<Element> propositionElements = this.root.getChild("propositions").getChildren("proposition");
            for (Element propositionElement : propositionElements) {
                Element factElement = propositionElement.getChild("fact");
                Property property = this.getProperties().get(factElement.getChild("property").getAttributeValue("ref"));
                int valueIndex = Integer.parseInt(factElement.getChild("value").getAttributeValue("ref"));
                Fact fact = new Fact(property, property.get(valueIndex));
                Proposition proposition = new Proposition(
                        fact,
                        propositionElement.getChild("state").getValue().equals("true"),
                        propositionElement.getChild("final").getValue().equals("true")
                );
                this.propositions.put(propositionElement.getAttributeValue("id"), proposition);
            }
        }
        return this.propositions;
    }

    public Rules getRules() {

        if (this.rules == null) {
            this.rules = new Rules();
            List<Element> ruleElements = this.root.getChild("rules").getChildren("rule");
            for (Element ruleElement : ruleElements) {
                Rule rule = new Rule();
                for (Element majorElement : ruleElement.getChild("majors").getChildren("major")) {
                    rule.getMajors().add(this.getPropositions().get(majorElement.getAttributeValue("ref")));
                }
                for (Element conclusionElement : ruleElement.getChild("conclusions").getChildren("conclusion")) {
                    rule.getConclusions().add(this.getPropositions().get(conclusionElement.getAttributeValue("ref")));
                }
                this.rules.add(rule);
            }
        }
        return this.rules;
    }

    public HashSet<Proposition> getTruth() {
        if (this.truth == null) {
            this.truth = new HashSet<>();
            List<Element> truthElements = this.root.getChild("truth").getChildren("proposition");
            for (Element truthElement : truthElements) {
                this.truth.add(this.getPropositions().get(truthElement.getAttributeValue("ref")));
            }
        }
        return this.truth;
    }

    public HashSet<Proposition> getError() {
        if (this.error == null) {
            this.error = new HashSet<>();
            List<Element> errorElements = this.root.getChild("error").getChildren("proposition");
            for (Element errorElement : errorElements) {
                this.error.add(this.getPropositions().get(errorElement.getAttributeValue("ref")));
            }
        }
        return this.error;
    }
}
