package MongoDBProject;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class mongo2 {

    public static void main(String[] args) {
        MongoDatabase database = connectDB();
        MongoCollection<Document> connections = database.getCollection("Connections");
        List<BaseObjectFilter> filters = new ArrayList<>();
        BaseObjectFilter combinedFilters = null;

        BaseObjectFilter finalFilters = null;
        List<String> connectionIds = new ArrayList<String>();
        connectionIds.add("a433ab2d-5270-4c6d-ba87-0c78b4b39b91");
        String spaceId = "95737731-ca0d-4c16-a558-9c5feb87a3d7";
        String accountId = "2338A146-AB4F-43E7-B014-04C8A37B011C";


        //combinedFilters = new BaseObjectFilter(null, filter, BaseObjectFilter.OperandType.OR);

        /*String spaceId = "95737731-ca0d-4c16-a558-9c5feb87a3d7";
        filters.add(new BaseObjectFilter("SpacePath", spaceId, BaseObjectFilter.OperandType.EQUALS));
        List<String> accountIds = new ArrayList<String>();
        accountIds.add("2338A146-AB4F-43E7-B014-04C8A37B011C");
        filters.add(new BaseObjectFilter("accountId", accountIds, BaseObjectFilter.OperandType.IN));

        if (!filters.isEmpty()) {
            combinedFilters = new BaseObjectFilter(null, filters, BaseObjectFilter.OperandType.OR);
        }*/


        //method
        BasicDBObject query = new BasicDBObject();
        query.put("guid", new BasicDBObject("$in", connectionIds));
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("SpacePath", "95737731-ca0d-4c16-a558-9c5feb87a3d7"));
        obj.add(new BasicDBObject("accountId", "2338A146-AB4F-43E7-B014-04C8A37B011C"));
        query.put("$or", obj);

       /* if (combinedFilters != null)
        {
            query.putAll((BSONObject) combinedFilters.getFilter());
        }*/
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
