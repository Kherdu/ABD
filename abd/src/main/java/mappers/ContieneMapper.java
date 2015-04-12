package mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import ABD.abd.Crossword;
import ABD.abd.Friends;
import ABD.abd.Word;

public class ContieneMapper extends AbstractMapper<Word, String> {


	private static final String[] contains_key_name = new String[] {"Titulo_crucigrama", "Id_palabra"};
	private static final String[] contains_column_names = new String[] {
			"Titulo_crucigrama","Id_palabra", "Puntuacion","Orientacion","PosicionX","PosicionY" };
	private static final String contains_table_name = "contiene";

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

	protected String getKeyColumnName() {
		return contains_key_name[0];
	}
	
	protected String getKeyColumnNameForFriend() {
		return contains_key_name[1];
	}
	@Override
	protected Word buildObject(ResultSet rs) throws SQLException {
		return new Word(rs.getString("Id_palabra"), rs.getInt("PosicionX"),
				rs.getInt("PosicionY"), rs.getString("Orientacion"), rs.getInt("Puntuacion"));
	}

	protected Word buildObjectForFriend(ResultSet rs) throws SQLException {
		//return new Friends(rs.getString("Nick1"));
		return null;
	}
	
	@Override
	protected Word buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Word object) {
		return new Object[] { null,  object.getWord(), object.getPuntuacion(), object.getOrientation(), object.getX(), object.getY()};
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

	@Override
	protected String getKeyFromObject(Word Object) {
		// TODO Auto-generated method stub
		return null;
	}


	public Word findByIdAuxiliar(String id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnNameForFriend();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " = ?";
		
		
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return buildObject(rs);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	protected ArrayList<Word> findWordsFromCrossword(String id){
		
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

		ArrayList<Word> result = new ArrayList<Word>();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " LIKE ?";
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, "%" + id + "%");

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					result.add((Word) buildObject(rs));
				}
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
	

