package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ABD.abd.Crossword;

public class ActivosMapper extends AbstractMapper<Crossword, String> {

	public ActivosMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Crossword buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Crossword buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Crossword object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object decomposeObject(Crossword Object) {
		// TODO Auto-generated method stub
		return null;
	}

}
