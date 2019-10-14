package MongoDBProject;

public class BaseObjectFilterList {

    public static enum  LogicalOperator  {
        AND, OR
    };

    public LogicalOperator logicalOperator;

    private static final String AND_OPERATOR = "$and";
    private static final String OR_OPERATOR = "$or";

    public BaseObjectFilter[] filters;

    public BaseObjectFilterList(LogicalOperator logicalOperator, BaseObjectFilter[] filters) {
        this.logicalOperator = logicalOperator;
        this.filters = filters;
    }

    public BaseObjectFilterList(LogicalOperator logicalOperator, BaseObjectFilter filter) {
        this(logicalOperator, new BaseObjectFilter[] {filter});
    }

    public String getLogicalOperator()
    {
        if(logicalOperator == LogicalOperator.OR)
            return OR_OPERATOR;
        else
            return AND_OPERATOR;
    }

    public static String getLogicalOperator(LogicalOperator operator)
    {
        if(operator == LogicalOperator.OR)
            return OR_OPERATOR;
        else if(operator == LogicalOperator.AND)
            return AND_OPERATOR;
        else
            return null;
    }
}
