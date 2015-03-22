package mappers;

public enum QueryOperator {

	EQ("="), LE("<="), LT("<"), GE(">="), GT(">"), NEQ("!="), LIKE("LIKE"), ORDER(
			"ORDER BY");

	String simbolo;

	QueryOperator(String s) {
		simbolo = s;

	}

	public String getOperator() {

		return simbolo;
	}

}
