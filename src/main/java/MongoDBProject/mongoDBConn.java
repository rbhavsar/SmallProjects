package MongoDBProject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class mongoDBConn {

    public static void main(String[] args) {
        MongoDatabase database = connectDB();
        MongoCollection<Document> connections = database.getCollection("Connections");
        //List<BaseObjectFilter> filters = new ArrayList<>();

        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        List<String> list = new ArrayList<String>();
        list.add("5d20b294-8bf5-4f0b-95b7-89dc75e730ec");
        andQuery.put("guid", new BasicDBObject("$in", list));
        obj.add(new BasicDBObject("SpacePath", "95737731-ca0d-4c16-a558-9c5feb87a3d7"));
        obj.add(new BasicDBObject("accountId", "2338A146-AB4F-43E7-B014-04C8A37B011C"));
        andQuery.put("$or", obj);






        System.out.println(andQuery.toString());
    }

    private static MongoDatabase connectDB(){
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "10.211.55.3" , 27017 );

        // Creating Credentials


        // Accessing the database
        MongoDatabase database = mongo.getDatabase("ConnectorDB");

        return database;
    }
}
