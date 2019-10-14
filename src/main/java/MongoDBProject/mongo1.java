package MongoDBProject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class mongo1 {

    public static void main(String[] args) {
        MongoDatabase database = connectDB();
        MongoCollection<Document> connections = database.getCollection("Connections");
        List<BaseObjectFilter> filters = new ArrayList<>();
        BaseObjectFilter inFilter = null;


        List<String> connectionIds = new ArrayList<String>();
        connectionIds.add("a433ab2d-5270-4c6d-ba87-0c78b4b39b91");
        inFilter = new BaseObjectFilter("guid", connectionIds, BaseObjectFilter.OperandType.IN);
       // combinedFilters = new BaseObjectFilter(null, filters, BaseObjectFilter.OperandType.AND);

        /*BaseObjectFilter filter = null;
        String spaceId = "95737731-ca0d-4c16-a558-9c5feb87a3d7";
        filter = new BaseObjectFilter("SpacePath", spaceId, BaseObjectFilter.OperandType.EQUALS);
        String accountId = "2338A146-AB4F-43E7-B014-04C8A37B011C";
        filter = new BaseObjectFilter("accountId", accountId, BaseObjectFilter.OperandType.EQUALS);
        BaseObjectFilter orFilters = null;
        if (!filters.isEmpty()) {
            orFilters = new BaseObjectFilter(null, filter, BaseObjectFilter.OperandType.OR);
        }*/

        BaseObjectFilter orFilters = null;

       List<BaseObjectFilter> orFilter = new ArrayList<>();
        orFilter.add(new BaseObjectFilter("SpacePath", "95737731-ca0d-4c16-a558-9c5feb87a3d7", BaseObjectFilter.OperandType.EQUALS));
        orFilter.add(new BaseObjectFilter("accountId", "2338A146-AB4F-43E7-B014-04C8A37B011C", BaseObjectFilter.OperandType.EQUALS));

        orFilters = new BaseObjectFilter(null, orFilter, BaseObjectFilter.OperandType.OR);

        BaseObjectFilterList filterWithName = new BaseObjectFilterList(BaseObjectFilterList.LogicalOperator.AND,
                new BaseObjectFilter[] {
                        inFilter,
                        orFilters});


        //method
        BasicDBObject query = new BasicDBObject();
        /*if (combinedFilters != null)
        {inFilters
            //query.putAll((BSONObject) orFilters.getFilter());
            query.putAll((BSONObject) combinedFilters.getFilter());
        }*/

        BasicDBObject logicalOperation = new BasicDBObject();
        BasicDBList list = new BasicDBList();
        for(BaseObjectFilter filter : filterWithName.filters)
        {
            list.add(new BasicDBObject(filter.getFilter()));
        }
        logicalOperation.append(filterWithName.getLogicalOperator(),list);
        query.putAll(logicalOperation.toMap());

/*        BasicDBList wrapList = new BasicDBList();
        wrapList.add(logicalOperation);
        query.putAll(wrapList);*/
        //query.put("$and",logicalOperation);
        System.out.println("logicalOperation : "+logicalOperation);
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
