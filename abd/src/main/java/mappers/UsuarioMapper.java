package mappers;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.ImageIcon;

import ABD.abd.User;

public class UsuarioMapper extends AbstractMapper<User, String> {

	private static final String user_key_name = "Usuario";
	private static final String[] user_column_names = new String[] { "Usuario",
			"Contraseña", "FechaNacimiento", "Foto" };
	private static final String user_table_name = "usuario";

	public UsuarioMapper(DataSource ds) {
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

		return user_key_name;
	}

	@Override
	protected User buildObject(ResultSet rs) throws SQLException {
		Blob foto = rs.getBlob("Foto");
	
		ImageIcon im = null;
		
		if(!rs.wasNull()) im = new ImageIcon(foto.getBytes(1, (int)foto.length()));
		
		return new User(rs.getString("Usuario"), rs.getString("Contraseña"),
				rs.getDate("FechaNacimiento"), im);
	}

	@Override
	protected User buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	protected Object[] serializeObject(User object) {

		return new Object[] { object.getNick(), object.getPass(),
				object.getBirthDate(), object.getAvatar() };
	}

	@Override
	protected Object decomposeObject(User Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(String object) {

		return new Object[] { object };
	}

	@Override
	protected String getKeyFromObject(User Object) {
		return Object.getNick();
	}

	@Override
	protected String getKeyColumnNameForFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected User buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
