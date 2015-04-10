package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ABD.abd.Crossword;
import ABD.abd.User;

public class PeticionesMapper extends AbstractMapper<User, Crossword> {

	public PeticionesMapper(DataSource ds) {
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
	protected User buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected User buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected User buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(User object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(Crossword object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object decomposeObject(User Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Crossword getKeyFromObject(User Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyColumnNameForFriend() {
		// TODO Auto-generated method stub
		return null;
	}

}
