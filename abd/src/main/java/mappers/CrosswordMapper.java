package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ABD.abd.Crossword;
import ABD.abd.User;

public class CrosswordMapper extends AbstractMapper<Crossword, String> {

	
	private static final String crossword_key_name =  "Titulo";
	private static final String[] crossword_column_names = new String[] { "Titulo", "Fecha" };
	private static final String crossword_table_name = "crucigrama";
	
	
	public CrosswordMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		
		return crossword_table_name;
	}

	@Override
	protected String[] getColumnNames() {
		
		return crossword_column_names;
	}

	@Override
	protected String getKeyColumnName() {
	
		return crossword_key_name;
	}

	@Override
	protected Crossword buildObject(ResultSet rs) throws SQLException {
		return new Crossword(rs.getString("Titulo"), rs.getDate("Fecha"));
	}

	@Override
	protected Crossword buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Crossword object) {
		
		return new Object[] {  object.getTitle(), object.getDate()};
	}

	@Override
	protected Object decomposeObject(Crossword Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		// TODO Auto-generated method stub
		return null;
	}

}
