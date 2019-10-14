package AvoidNPE;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author rbhavsar
 * Created on 2/13/19.
 */

//https://javarevisited.blogspot.com/2013/05/ava-tips-and-best-practices-to-avoid-nullpointerexception-program-application.html

public class npe {

  public static void main(String[] args) {
    //Prefer valueOf() over toString() where both return same result
    BigDecimal bd = getPrice();
    System.out.println(String.valueOf(bd));
    //System.out.println(bd.toString());

    //Using null safe methods and libraries
    System.out.println(StringUtils.isEmpty(null));
    System.out.println(StringUtils.isBlank(null));
    System.out.println(StringUtils.isNumeric(null));
    System.out.println(StringUtils.isAllUpperCase(null));

    //Avoid returning null from method, instead return empty collection or empty array.
    System.out.println(getOrders(new Object()));
  }

  private static BigDecimal getPrice() {
    return null;
  }

  public static List getOrders(Object customer){
    List result = Collections.EMPTY_LIST;
    return result;
  }

}
