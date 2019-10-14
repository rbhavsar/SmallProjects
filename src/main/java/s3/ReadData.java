package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rbhavsar
 * Created on 3/9/19.
 */
public class ReadData {

  public static void main(String[] args) {



    String s1="s3://birst-content1/edition/pre.provision.json";
    String s2="s3://birst-content1/qac/infor.fsm-birst.fsmbirst.11.0.5.1.json";
    AmazonS3URI amazonS3URI = new AmazonS3URI(s1);
    String bucketName = amazonS3URI.getBucket();
    String key = amazonS3URI.getKey();
    try {
//    AmazonS3 s3Client =
//        AmazonS3ClientBuilder.standard()
//            .withRegion("us-east-1") // The first region to try your request against
//            .withForceGlobalBucketAccessEnabled(true) // If a bucket is in a different region, try again in the correct region
//            .build();
      AmazonS3 s3Client =
          AmazonS3ClientBuilder.standard().withRegion("us-east-1").withForceGlobalBucketAccessEnabled(true).build();
    S3Object object =s3Client.getObject(new GetObjectRequest(bucketName, key));
    S3ObjectInputStream objectContent = object.getObjectContent();

      String appDescriptorContent = getAppDescriptorContent(objectContent);
      System.out.println("appDescriptorContent: "+appDescriptorContent);
      ObjectMapper objectMapper = new ObjectMapper();
      Map<String, String> s3EditionBySkuMap = objectMapper.readValue(appDescriptorContent, new TypeReference<HashMap<String, String>>() {});
      Set<String> keySet = s3EditionBySkuMap.keySet();
      for (String k : keySet) {
        System.out.println(k+":"+s3EditionBySkuMap.get(k));
      }

      //Need to prase the SPOT request Object and create list of SKUs
      List<String> requestedSkus = new ArrayList<>();
      requestedSkus.add("BBI-S-DBCS-PLT");
      requestedSkus.add("BBI-S-EENT");
      requestedSkus.add("BBI-S-DBCS-ALT");
      requestedSkus.add("BBI-XXXX");

      System.out.println(findAccountEdition(requestedSkus,s3EditionBySkuMap));




    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Exception: "+e.getMessage());
    }
  }

  private static String findAccountEdition(List<String> requestedList, Map<String,String> map) {
    Set<String> editionSet = new HashSet<>();
    for (String sku : requestedList) {
      if(map.containsKey(sku)){
        editionSet.add(map.get(sku));
      }
    }
    HashMap<String,Integer> editionRank = new HashMap<>();
    editionRank.put("Trial",1);
    editionRank.put("CloudSuite",2);
    editionRank.put("Pro",2);
    editionRank.put("Pro Plus",4);
    editionRank.put("Enterprise",3);
    editionRank.put("Enterprise Plus",6);

    Integer actualEdition = 0;
    String expectedEdition = "NoEdition";
    for (String edition : editionSet) {
      if(actualEdition < editionRank.get(edition)) {
        actualEdition = editionRank.get(edition);
        expectedEdition = edition;
      }
    }

    return expectedEdition;

  }

  private static String getAppDescriptorContent(S3ObjectInputStream objectContent) throws IOException {
    //TODO Read line by line instead of char
    BufferedReader reader = new BufferedReader(new InputStreamReader(objectContent));
    int i=0;
    StringBuilder sb=new StringBuilder();
    while((i=reader.read())!=-1){
      sb.append((char)i);
    }
    return sb.toString();
  }

}
