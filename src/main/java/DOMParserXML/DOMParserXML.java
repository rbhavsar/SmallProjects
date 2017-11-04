package DOMParserXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParserXML {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("/Users/rbhavsar/StudentData/AI/src/main/java/DOMParserXML/Employee.xml");
        //Getting root element from Document obj
        Element element = document.getDocumentElement();
        System.out.println(element.getNodeName());
        //Get Child Elements
        NodeList childNodes = element.getChildNodes();
        for(int i=0;i<childNodes.getLength();i++)
        {
            //get Child node object from node list
            Node node = childNodes.item(i);
            if(node.getNodeType() == node.ELEMENT_NODE) {
                System.out.println(node.getNodeName() + "---->" + node.getTextContent());
            }

        }



    }
}
