package mappers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import ABD.abd.Friends;
import ABD.abd.User;

public class AmigosMapper extends AbstractMapper<Friends, String> {

	
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
	protected Friends buildObject(ResultSet rs) throws SQLException {
		return new Friends(rs.getString("Nick2"));
	}
	
	protected Friends buildObjectForFriend(ResultSet rs) throws SQLException {
		return new Friends(rs.getString("Nick1"));
	}

	
	@Override
	protected Friends buildObject(Object[] components) throws SQLException {
		
		return null;
	}

	@Override
	protected Object[] serializeObject(Friends object) {

		return new Object[] { object.getNick1() , object.getNick2()};
	}
	
	@Override
	protected Object[] serializeObjectKey(String object) {
		return new Object[] {  "Nick1", "Nick22" };
	}

	@Override
	protected Object decomposeObject(Friends Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyFromObject(Friends Object) {
		return Object.getNick1() + Object.getNick2();
	}
	private String getKeyFromObj(User Object, User Object2)
	{
		String aux= Object.getNick() + ", " + Object2.getNick();
		return aux;
	}
	

	

}
