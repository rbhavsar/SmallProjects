package JDOMParserXML_IMP;

/*
Import XML-related packages.
Create a SAXBuilder
Create a Document from a file or stream
Extract the root element
Examine attributes
Examine sub-elements
 */

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * @author rbhavsar
 * Created on 11/17/18.
 */
public class DomParserDemo2 {

  public static void main(String[] args) throws JDOMException, IOException {
    File file = new File("/Users/rbhavsar/SmallProjects/src/main/java/JDOMParserXML_IMP/input2.txt");
    SAXBuilder saxBuilder = new SAXBuilder();
    Document document = saxBuilder.build(file);
    Element rootElement = document.getRootElement();
    List<Element> childrens =  rootElement.getChildren();

    for(int i=0;i<childrens.size();i++){
      Element element = childrens.get(i);
      List<Element> children = element.getChildren();
      for(int j=0;j<children.size();j++){
        Element element1 = children.get(j);
        System.out.println(element1.getText());
      }
    }


  }

}
