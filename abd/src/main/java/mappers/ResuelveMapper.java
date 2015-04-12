package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import ABD.abd.Resuelve;
import ABD.abd.User;

public class ResuelveMapper extends AbstractMapper<Resuelve, String> {

	private static final String[] resuelve_key_name = new String[]{"Id_activo", "Respuesta"};
	private static final String[] resuelve_column_names = new String[] {
			"Id_activo","Palabra", "Fecha", "Hora", "Nick", "Respuesta" };
	private static final String resuelve_table_name = "resuelve";
	
	
	public ResuelveMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	protected String getTableName() {

		return resuelve_table_name;
	}

	@Override
	protected String[] getColumnNames() {

		return resuelve_column_names;
	}

	@Override
	protected String getKeyColumnName() {

		return resuelve_key_name[0];
	}
	@Override
	protected String getKeyColumnNameForFriend() {
		
		return resuelve_key_name[1];
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		Date hora = new Date();
		String hour = hourFormat.format(hora);
		System.out.println(date + " "+hour); //2013/10/15 16:16:39

		return new Object[] {  object.getNombreCrucigrama(),object.getPalabra(), fecha, hour, object.getUsuario(),
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
	protected Resuelve buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
