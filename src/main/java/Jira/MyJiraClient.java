package Jira;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.atlassian.httpclient.api.Response;
import com.atlassian.jira.rest.client.api.AuthenticationHandler;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.Comment;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
import com.atlassian.jira.rest.client.internal.async.AsynchronousHttpClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.DisposableHttpClient;

/**
 * @author rbhavsar
 * Created on 8/18/18.
 */
public class MyJiraClient {

  private String username;
  private String password;
  private String jiraUrl;
  private JiraRestClient restClient;

  private MyJiraClient(String username, String password, String jiraUrl) {
    this.username = username;
    this.password = password;
    this.jiraUrl = jiraUrl;
    this.restClient = getJiraRestClient();
  }

  public static void main(String[] args) {

    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    System.out.println("Current relative path is: " + s);

    File file = new File(".");
    file.getParentFile();

    MyJiraClient myJiraClient = new MyJiraClient("rbhavsar", "birst123", "https://mybirst.atlassian.net"); //("cmatala", "CaseyBug3", "https://jira.daxko.com");
    try {
      validateAndGetUsername(myJiraClient.jiraUrl,myJiraClient.username,myJiraClient.password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Issue issue = myJiraClient.getIssue("DPT-1818");
    System.out.println(issue.getDescription());
    List<Comment> comments = myJiraClient.getAllComments("DPT-1818");
    comments.forEach(c -> System.out.println(c.getBody()));
    myJiraClient.getProjects();

    myJiraClient.deleteIssue("DPT-1818", true);

    //System.out.println(issue);
  }

  private JiraRestClient getJiraRestClient() {
    return new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(getJiraUri(), this.username, this.password);
  }

  private Issue getIssue(String issueKey) {
    return restClient.getIssueClient().getIssue(issueKey).claim();

  }

  private void getProjects(){
    Iterator<BasicProject> iterator = restClient.getProjectClient().getAllProjects().claim().iterator();
    while(iterator.hasNext()){
      System.out.println("key: "+iterator.next().getKey()+"name: "+iterator.next().getName());
    }

  }

  private List<Comment> getAllComments(String issueKey) {
    return StreamSupport.stream(getIssue(issueKey).getComments().spliterator(), false)
        .collect(Collectors.toList());
  }

  private void deleteIssue(String issueKey, boolean deleteSubtasks) {
    restClient.getIssueClient().deleteIssue(issueKey, deleteSubtasks).claim();
  }

  private URI getJiraUri() {
    return URI.create(this.jiraUrl);
  }


  public static String validateAndGetUsername(String baseURL,String username, String password) throws JSONException, URISyntaxException{
    String updatedUsername = username;

    AuthenticationHandler authenticationHandler = new BasicHttpAuthenticationHandler(username, password);
    DisposableHttpClient httpClient =  new AsynchronousHttpClientFactory().createClient(new URI(baseURL), authenticationHandler);
    String resource = baseURL + "/rest/api/2/user/search?username=" + username;
    Response response=null;
    try {
      response = httpClient.newRequest(resource).get().claim();
    }catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

    if(response.getStatusCode() == 200) {
      String body = response.getEntity();
      JSONArray users = new JSONArray(body);

      if(users != null && users.getJSONObject(0) != null && users.getJSONObject(0).getString("name") != null) {
        updatedUsername = users.getJSONObject(0).getString("name");
      }
    } else {
      System.out.println("Please provide valid credentials");
    }
    return updatedUsername;
  }
}
