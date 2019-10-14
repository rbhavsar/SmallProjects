package MongoDBProject;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class mongo {

    public static void main(String[] args) {
        MongoDatabase database = connectDB();
        MongoCollection<Document> connections = database.getCollection("Connections");
        List<BaseObjectFilter> filters = new ArrayList<>();
        BaseObjectFilter combinedFilters = null;
        List<String> connectionIds = new ArrayList<String>();
        connectionIds.add("698a8c68-2613-4cb7-acf5-9d80855672d8");
        filters.add(new BaseObjectFilter("guid", connectionIds, BaseObjectFilter.OperandType.IN));
        List<String> spaceIds = new ArrayList<String>();
        spaceIds.add("95737731-ca0d-4c16-a558-9c5feb87a3d7");
        filters.add(new BaseObjectFilter("SpacePath", spaceIds, BaseObjectFilter.OperandType.IN));

        if (!filters.isEmpty()) {
            combinedFilters = new BaseObjectFilter(null, filters, BaseObjectFilter.OperandType.AND);
        }


        //method
        BasicDBObject query = new BasicDBObject();
        if (combinedFilters != null)
        {
            query.putAll((BSONObject) combinedFilters.getFilter());
        }
        System.out.println("query : "+query);
    }

    private static MongoDatabase connectDB(){
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "10.211.55.3" , 27017 );
        // Accessing the database
        MongoDatabase database = mongo.getDatabase("ConnectorDB");
        return database;
    }
}
