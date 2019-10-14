package Util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.GsonBuilder;

/**
 * @author rbhavsar
 * Created on 8/8/18.
 */
public class readData {

  public static void main(String[] args) throws IOException {
    /*File file = new File("/Users/rbhavsar/SmallProjects/src/main/resources/mapSource.json");

    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    while ((st = br.readLine()) != null)
      sb.append(st);

    System.out.println(sb.toString());
   }*/
    /*List l = readFileInList("/Users/rbhavsar/SmallProjects/src/main/resources/mapSource.json");
    Iterator<String> itr = l.iterator();
    StringBuilder sb = new StringBuilder();

    while (itr.hasNext())
      sb.append(itr.next());

    System.out.println(sb.toString());*/

//    Set<String> ifsGroups = new HashSet<>();
//    ifsGroups.add("A");
//    ifsGroups.add("B");
//    Set<String> groupsExistInBirst = new HashSet<>();
//    groupsExistInBirst.add("A");
//    groupsExistInBirst.add("C");


    /*
    {"action":"GRANT_ACCOUNT_ADMIN_ACCESS",
 "userIds": [
    "4D43343D-284D-415E-8D1A-C31FBE60B0E5"
  ]
}
     */


//    removeGroupsFromSpace(ifsGroups,groupsExistInBirst);
//    addGroupsToSpace(ifsGroups,groupsExistInBirst);


    List<String> userIds = new ArrayList<>();
    userIds.add("4D43343D-284D-415E-8D1A-C31FBE60B0E5");
    userIds.add("5643343D-284D-415E-8D1A-C31FBE60B089");
    System.out.println(userIds);

    String actions = "Grant";

    UsersAction usersAction = new UsersAction();
    usersAction.setAction("Grant");
    usersAction.setUserIds(userIds);
    preparePayload(usersAction);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    String format = sdf.format(new Date(System.currentTimeMillis() + (24 *60 * 60 * 1000)));

    System.out.println("\"NONE\",\"DEFLATE\",\"GZIP\"");

    testBreak();

    Map<String, Set<String>> ifsSecurityRolesByAppLid = new HashMap<>();
    Set<String> set = new HashSet<>();
    set.add("value1");
    set.add("value2");
    ifsSecurityRolesByAppLid.put("lid1.infor.social.ade01",set);
    System.out.println(ifsSecurityRolesByAppLid);

    for (Map.Entry<String, Set<String>> entry : ifsSecurityRolesByAppLid.entrySet()) {
      if(entry.getKey().startsWith("lid1.infor.social")) {
        System.out.println("********");
      }
    }

  }

  private static void preparePayload(UsersAction usersAction) {
    String jsonString = new GsonBuilder().create().toJson(usersAction);

  }


  private static void addGroupsToSpace(Set<String> ifsGroups, Set<String> groupsExistInBirst) {
    Set<String> groupsToBeAdded = new HashSet<>();
    for (String ifsGroup : ifsGroups) {
      if(!groupsExistInBirst.contains(ifsGroup)){
        groupsToBeAdded.add(ifsGroup);
      }
    }
    for (String s : groupsToBeAdded) {
      System.out.println("Groups to be added "+s);
    }
  }

  private static void removeGroupsFromSpace(Set<String> ifsGroupsName, Set<String> groupsExistInBirst) {
    Set<String> groupsToBeRemoved = new HashSet<>();
    for (String group : groupsExistInBirst) {
      if(!ifsGroupsName.contains(group)){
        groupsToBeRemoved.add(group);
      }
    }

    for (String s : groupsToBeRemoved) {
      System.out.println("Groups to be Removed "+s);
    }

  }

  private static void testBreak() {

    int[] data = {10,20,30,40,50,60,71,80,90,91};
    for (int n : data) {
      if(n==10){
        System.out.println("got it");
        break;
      }
    }

  }


  private static List readFileInList(String fileName) {

    List<String> lines = Collections.emptyList();
    try
    {
      lines =
          Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }

    catch (IOException e)
    {

      // do something
      e.printStackTrace();
    }
    return lines;
  }
}


