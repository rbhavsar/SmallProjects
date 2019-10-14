package Util;

import java.util.Arrays;
import java.util.List;

/**
 * @author rbhavsar
 * Created on 10/8/19.
 */
public class ValidationUtils {

  public static void validate(List<Validator> validatorList) throws Exception {
    if (validatorList != null && validatorList.size() > 0) {
      for (Validator validator : validatorList) {
        String result = validator.validate();
        System.out.println("result: "+result);

      }
    }
  }

  public static void validate(Validator... validatorList) throws Exception {
    if (validatorList != null) {
      validate(Arrays.asList(validatorList));
    }
  }

}
