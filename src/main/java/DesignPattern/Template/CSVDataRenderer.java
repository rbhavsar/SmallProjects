package DesignPattern.Template;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public final class CSVDataRenderer extends DataRenderer {
  @Override
  public String readData() {
    return "CSV Data";
  }

  @Override
  public String processData(String data) {
    return "Processed Data "+data;
  }
}
