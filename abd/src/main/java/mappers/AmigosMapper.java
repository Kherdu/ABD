package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ABD.abd.User;

public class AmigosMapper extends AbstractMapper<User, String> {

	
	private static final String[] user_key_name = new String[] { "Nick1", "Nick2"};
	private static final String[] user_column_names = new String[] { "Nick1", "Nick2"};
	private static final String user_table_name = "amigo";

	
	public AmigosMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		return user_table_name;
	}

	@Override
	protected String[] getColumnNames() {
		return user_column_names;
	}

	@Override
	protected String getKeyColumnName() {
		return user_key_name[0];
	}
	
	protected String getKeyColumnNameForFriend() {
		return user_key_name[1];
	}
	
	
	@Override
	protected User buildObject(ResultSet rs) throws SQLException {
		return new User(rs.getString("Nick2"));
	}
	
	protected User buildObjectForFriend(ResultSet rs) throws SQLException {
		return new User(rs.getString("Nick1"));
	}

	
	@Override
	protected User buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(User object) {

		return new Object[] { object.getNick() };
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		return new Object[] { object };
	}

	@Override
	protected Object decomposeObject(User Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyFromObject(User Object) {
		return Object.getNick();
	}

}
