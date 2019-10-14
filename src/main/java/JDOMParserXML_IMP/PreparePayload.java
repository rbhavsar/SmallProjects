package JDOMParserXML_IMP;


/*
<?xml version = "1.0" encoding = "UTF-8"?>
<cars>
   <supercars company = "Ferrari">
      <carname type = "formula one">Ferrari 101</carname>
      <carname type = "sports">Ferrari 202</carname>
   </supercars>
</cars>
 */

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author rbhavsar
 * Created on 11/17/18.
 */
public class PreparePayload {

  public static void main(String[] args) throws IOException {
    //root element
    Element carsElement = new Element("cars");
    Document doc = new Document(carsElement);

    //supercars element
    Element supercarElement = new Element("supercars");

    //supercars element
    Element carElement1 = new Element("carname");
    carElement1.setText("Ferrari 101");

    Element carElement2 = new Element("carname");
    carElement2.setText("Ferrari 202");

    supercarElement.addContent(carElement1);
    supercarElement.addContent(carElement2);

    doc.getRootElement().addContent(supercarElement);

    XMLOutputter xmlOutput = new XMLOutputter();

    // display ml
    xmlOutput.setFormat(Format.getPrettyFormat());
    xmlOutput.output(doc, System.out);
  }

}
