package JDOMParserXML_IMP;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/*
Import XML-related packages.
Create a SAXBuilder
Create a Document from a file or stream
Extract the root element
Examine attributes
Examine sub-elements
 */

/**
 * @author rbhavsar
 * Created on 11/17/18.
 */
public class DomParserDemo {

  public static void main(String[] args) throws JDOMException, IOException {
    File inputFile = new File("/Users/rbhavsar/SmallProjects/src/main/java/JDOMParserXML_IMP/input.txt");
    SAXBuilder saxBuilder= new SAXBuilder(); // create sax builder
    Document document = saxBuilder.build(inputFile); // create document from file
    System.out.println(document.getRootElement().getName());// extract root element
    //Sub element

    Element rootElement = document.getRootElement(); //root - class
    List<Element> childrens = rootElement.getChildren();//children - 3 - Student


    for(int i=0;i<childrens.size();i++){
      Element element = childrens.get(i);
      System.out.println(element.getChild("firstname").getText());
      System.out.println(element.getChild("lastname").getText());
      System.out.println(element.getChild("nickname").getText());
      System.out.println(element.getChild("marks").getText());
    }


  }
}
