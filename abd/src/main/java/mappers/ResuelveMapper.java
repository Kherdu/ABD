package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import ABD.abd.Resuelve;
import ABD.abd.User;

public class ResuelveMapper extends AbstractMapper<Resuelve, String> {

	private static final String activos_key_name = "Respuesta";
	private static final String[] activos_column_names = new String[] {
			"Palabra", "Fecha", "Hora", "Nick", "Respuesta" };
	private static final String activos_table_name = "resuelve";
	
	
	public ResuelveMapper(DataSource ds) {
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
	protected Resuelve buildObject(ResultSet rs) throws SQLException {
		return new Resuelve(rs.getString("Respuesta"), rs.getString("Palabra"));
	}

	@Override
	protected Resuelve buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Resuelve object) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		Date hora = new Date();
		String hour = dateFormat.format(date);
		System.out.println(); //2013/10/15 16:16:39

		return new Object[] {  object.getPalabra(), fecha, hour, object.getUsuario(),
				object.getResponde()  };
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		// TODO Auto-generated method stub
		return new Object[] { object };
	}

	@Override
	protected Object decomposeObject(Resuelve Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyFromObject(Resuelve Object) {
		return Object.getResponde();
	}

	@Override
	protected String getKeyColumnNameForFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Resuelve buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
