package MongoDBProject;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.logging.Filter;


public class ConnectToMongoDB {

    public static void main(String[] args) {

        try {
            Mongo mongo = new Mongo("rbhavsar21", 27017);
            DB db = mongo.getDB("TestData");
            DBCollection collection = db.getCollection("mycol_V1");

            BasicDBObject document = new BasicDBObject();
            document.put("title", "mkyongDB");
            document.put("description", "hosting");

            collection.insert(document);

            printAllDocuments(collection);

           /* DBCursor cursorDoc = collection.find();
            while (cursorDoc.hasNext()) {
                System.out.println(cursorDoc.next());
            }*/

            removeAllDocuments(collection);



        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Print "+e.getMessage());
        }
    }


    public static void removeAllDocuments(DBCollection collection) {
        collection.remove(new BasicDBObject());
    }

    public static void printAllDocuments(DBCollection dbCollection)
    {
        DBCursor dbCursor = dbCollection.find();
        while(dbCursor.hasNext())
        {
            System.out.println("----"+dbCursor.next()+"------");
        }
    }
}
