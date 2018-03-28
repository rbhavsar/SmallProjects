package HttpRequestResponse;

import twitter4j.JSONException;
import twitter4j.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ravi Bhavsar
 */
public class Post {

  public static void main(String[] args) throws IOException, JSONException {

    URL url = new URL("http://httpbin.org/post");
    Map<String,Object> params = new LinkedHashMap<String,Object>();
    params.put("name","Ravi Bhavsar");
    params.put("email","rbhavsar@birst.com");
    params.put("CODE",111);
    params.put("message","Hello post test sucess");

    StringBuffer postData = new StringBuffer();
    for(Map.Entry<String,Object> param:params.entrySet())
    {
      if(postData.length() !=0) postData.append('&');
      postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
      postData.append("=");
      postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
    }

    byte[] postDataBytes = postData.toString().getBytes("UTF-8");

    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
    conn.setRequestProperty("Content-Length",String.valueOf(postDataBytes.length));
    conn.setDoOutput(true);
    conn.getOutputStream().write(postDataBytes);

    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

    StringBuilder sb = new StringBuilder();
    for(int c;(c = in.read()) >=0 ;)
    sb.append((char)c);
    String response = sb.toString();

    JSONObject jObj = new JSONObject(response.toString());
    System.out.println("Object :"+jObj);

    System.out.println("Origin :"+jObj.getString("origin"));
  }

}
