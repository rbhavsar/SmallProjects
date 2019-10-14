package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

/**
 * @author rbhavsar
 * Created on 3/9/19.
 */
public class ReadData_AccessKey {
  public static void main(String[] args) {
        String s1="s3://birst-content/integ02/infor.fsm-birst.fsmbirst.11.0.5.1.json";
        String s2="s3://birst-content1/qac/infor.fsm-birst.fsmbirst.11.0.5.1.json";
        AmazonS3URI amazonS3URI = new AmazonS3URI(s1);
        String bucketName = amazonS3URI.getBucket();
        String key = amazonS3URI.getKey();
        try {
          AWSCredentials credentials = new BasicAWSCredentials("AKIAIBKXFXBQ77GILMIQ", "TQX5/1oAvuMFqw36GGRrfhIuNeM56gvIaRt0N5h4");
          AmazonS3 s3client = new AmazonS3Client(credentials);
          S3Object object = s3client.getObject(new GetObjectRequest(bucketName, key));
          S3ObjectInputStream objectContent = object.getObjectContent();
          String appDescriptorContent = getAppDescriptorContent(objectContent);
          System.out.println("appDescriptorContent: "+appDescriptorContent);
        }catch (Exception e){
          e.printStackTrace();
          System.out.println("Exception: "+e.getMessage());
        }
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
