package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import ABD.abd.Crossword;
import ABD.abd.Peticiones;
import ABD.abd.User;

public class PeticionesMapper extends AbstractMapper<Peticiones, String> {

	private static final String activos_key_name = "amigo";
	private static final String[] activos_column_names = new String[] { "Id",
			"Titulo_Crucigrama", "Nick", "amigo", "solicitud" };
	private static final String activos_table_name = "activos";
	
	public PeticionesMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	protected String getTableName() {

		return activos_table_name;
	}

	@Override
	protected String[] getColumnNames() {

		return activos_column_names;
	}

	@Override
	protected String getKeyColumnName() {

		return activos_key_name;
	}
	@Override
	protected Peticiones buildObject(ResultSet rs) throws SQLException {
		return new Peticiones(rs.getString("Titulo_Crucigrama"), rs.getString("Nick"));
	}

	@Override
	protected Peticiones buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Peticiones buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Peticiones object) {
		return new Object[] { null, object.getCrucigrama(), object.getUsuario(), null,
				null, object.getAmigo() };
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object decomposeObject(Peticiones Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyFromObject(Peticiones Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyColumnNameForFriend() {
		// TODO Auto-generated method stub
		return null;
	}

}
