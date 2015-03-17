package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ABD.abd.Crossword;
import ABD.abd.Word;

public abstract class ContieneMapper extends AbstractMapper<Word, String> {

	
	/**
	 * 
	 * CAMBIAR KEY_NAME A ARRAY
	 * */
	
	private static final String contains_key_name =  "Secuencia";
	private static final String[] contains_column_names = new String[] { "Secuencia", "Desripcion", "Foto" };
	private static final String contains_table_name = "palabra";
	
	public ContieneMapper(DataSource ds) {
		super(ds);
		
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return contains_table_name;
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return contains_column_names;
	}

	@Override
	protected String getKeyColumnName() {
		// TODO Auto-generated method stub
		return contains_key_name;
	}

	@Override
	protected Word buildObject(ResultSet rs) throws SQLException {
		return new Word(rs.getString("Id_palabra"), rs.getInt("PosicionX"),rs.getInt("PosicionY"),rs.getString("Orientacion"));
	}

	@Override
	protected Word buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Word object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object decomposeObject(Word Object) {
		// TODO Auto-generated method stub
		return null;
	}

}
