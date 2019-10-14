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
public class DomParserDemo1 {

  public static void main(String[] args) throws JDOMException, IOException {

    File file = new File("/Users/rbhavsar/SmallProjects/src/main/java/JDOMParserXML_IMP/input1.txt");
    SAXBuilder saxBuilder = new SAXBuilder();
    Document document = saxBuilder.build(file);
    Element rootElement = document.getRootElement();
    List<Element> childrens = rootElement.getChildren();

    for(int i=0;i<childrens.size();i++){
      Element element = childrens.get(i);
      List<Element> carname = element.getChildren("carname");
      for(int j=0;j<carname.size();j++){
        Element element1 = carname.get(j);
        System.out.println(element1.getText());
      }

    }
  }
}
