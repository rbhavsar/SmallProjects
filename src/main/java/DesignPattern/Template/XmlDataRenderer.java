package DesignPattern.Template;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public final class XmlDataRenderer extends DataRenderer {

  @Override
  public String readData() {

    return "XML Data";
  }

  @Override
  public String processData(String data) {
    return "Processed "+data;
  }
}
