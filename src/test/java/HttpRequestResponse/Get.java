package HttpRequestResponse;

import twitter4j.JSONException;
import twitter4j.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Ravi Bhavsar
 */
public class Get {

  public static void main(String[] args) throws IOException, JSONException {

    String url = "https://api.fixer.io/latest";
    URL obj = new URL(url);
    HttpURLConnection  con = (HttpURLConnection) obj.openConnection();
    //Optional , Default is Get
    con.setRequestMethod("GET");
    //Add Request Header
    con.setRequestProperty("User-Agent","Mozilla/5.0");
    int responseCode = con.getResponseCode();
    System.out.println("\nSending get request to URL :"+url);
    System.out.println("\nResponse code "+responseCode);

    BufferedReader in;
    in = new BufferedReader(new InputStreamReader(con.getInputStream()));

    String inputLine;
    StringBuffer response = new StringBuffer();
    while((inputLine = in.readLine())!=null)
    {
      response.append(inputLine);
    }

    in.close();

    System.out.println(response.toString());

    JSONObject jObj = new JSONObject(response.toString());
    System.out.println("base :"+jObj.getString("base"));

    System.out.println("rates :"+jObj.getJSONObject("rates").getString("AUD"));

  }

}
