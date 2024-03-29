package mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import ABD.abd.Crossword;
import ABD.abd.User;

public class ActivosMapper extends AbstractMapper<Crossword, String> {

	private static final String activos_key_name = "Nick";
	private static final String[] activos_column_names = new String[] {
			"Titulo_Crucigrama", "Nick", "amigo", "solicitud" };
	private static final String activos_table_name = "activos";
	//triple key
	public ActivosMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
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
	protected Crossword buildObject(ResultSet rs) throws SQLException {

		return new Crossword(rs.getString("Titulo_Crucigrama"), rs.getString("Nick"), rs.getString("amigo"));
	}

	@Override
	protected Crossword buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Crossword object) {

		return new Object[] {  object.getTitle(), object.getUser(), object.getAmigo(),
				null  };
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		return new Object[] { object };
	}

	@Override
	protected Object decomposeObject(Crossword Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyFromObject(Crossword Object) {
		// TODO Auto-generated method stub
		return Object.getUser();
	}

	public Boolean findByUserAndCrossword(User user, Crossword crossword) {
		boolean ret = false;
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnNameUser = "Nick";
		String keyColumnNameCrossword = "Titulo_Crucigrama";
		Object object = null;

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnNameUser + " = ?" + " AND "
				+ keyColumnNameCrossword + " = ?";
		
		
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, user.getNick());
			pst.setString(2, crossword.getTitle());

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					object = buildObject(rs);
				}

			}
			if (object != null)
				ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}

		return ret;

	}

	@Override
	protected String getKeyColumnNameForFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Crossword buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
