package MongoDBProject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import java.util.Collection;
import java.util.List;

public class BaseObjectFilter {

    public static enum OperandType {
        EQUALS, NOT_EQUALS, AND, IN, MOD, ELEM_MATCH,OR
    }

    private static final String NOT_EQUALS_OPERATOR = "$ne";
    public static final String AND_OPERATOR = "$and";
    public static final String IN_OPERATOR = "$in";
    public static final String MOD_OPERATOR = "$mod";
    public static final String ELEM_MATCH_OPERATOR = "$elemMatch";
    public static final String OR_OPERATOR = "$or";


    public String columnName;
    public Object value;
    public OperandType operand;

    public BaseObjectFilter(String columnName, Object value, OperandType operand)
    {
        this.columnName = columnName;
        this.value = value;
        this.operand = operand;
    }

    public BasicDBObject getFilter()
    {
        switch(operand)
        {
            case EQUALS:
                return new BasicDBObject(columnName,value);
            case NOT_EQUALS:
                return new BasicDBObject(columnName, new BasicDBObject(NOT_EQUALS_OPERATOR, value));
            case AND:
                BasicDBList andExpressions = new BasicDBList();
                for (BaseObjectFilter baseObjectFilter : (Collection<BaseObjectFilter>) value) {
                    andExpressions.add(baseObjectFilter.getFilter());
                }
                return new BasicDBObject(AND_OPERATOR, andExpressions);
            case OR:
                List<BaseObjectFilter> orFilters = (List<BaseObjectFilter>) value;
                BasicDBList orExpressions = new BasicDBList();
                for (BaseObjectFilter orFilter : orFilters) {
                    orExpressions.add(orFilter.getFilter());
                }
                return new BasicDBObject(OR_OPERATOR, orExpressions);
            case IN:
                return new BasicDBObject(columnName, new BasicDBObject(IN_OPERATOR, value));
            case MOD:
                return new BasicDBObject(columnName, new BasicDBObject(MOD_OPERATOR, value));
            case ELEM_MATCH:
                return new BasicDBObject(columnName, new BasicDBObject(ELEM_MATCH_OPERATOR, ((BaseObjectFilter) value).getFilter()));
            default:
                return null;
        }
    }

}