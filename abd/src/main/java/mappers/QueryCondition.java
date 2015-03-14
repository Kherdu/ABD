package mappers;

public class QueryCondition {
	
	private String columnName;
	private QueryOperator operator;
	private Object value;
	
	public QueryCondition(String columnName, QueryOperator operator, Object value) {
		this.columnName = columnName;
		this.operator = operator;
		this.value = value;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public QueryOperator getOperator() {
		return operator;
	}

	public void setOperator(QueryOperator operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
}
