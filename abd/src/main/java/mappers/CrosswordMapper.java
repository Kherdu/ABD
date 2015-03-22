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

public class CrosswordMapper<K> extends AbstractMapper<Crossword, String> {

	private static final String crossword_key_name = "Titulo";
	private static final String[] crossword_column_names = new String[] {
			"Titulo", "Fecha" };
	private static final String crossword_table_name = "crucigrama";

	public CrosswordMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {

		return crossword_table_name;
	}

	@Override
	protected String[] getColumnNames() {

		return crossword_column_names;
	}

	@Override
	protected String getKeyColumnName() {

		return crossword_key_name;
	}

	@Override
	protected Crossword buildObject(ResultSet rs) throws SQLException {
		return new Crossword(rs.getString("Titulo"), rs.getDate("Fecha"));
	}

	@Override
	protected Crossword buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Crossword object) {

		return new Object[] { object.getTitle(), object.getDate() };
	}

	@Override
	protected Object decomposeObject(Crossword Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Crossword> findAll() {
		ArrayList<Crossword> ret = new ArrayList<Crossword>();
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

		String sql = "SELECT " + "*" + " FROM " + tableName;
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					ret.add(buildObject(rs));
				}
				return ret;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public <T> ArrayList<T> findCrosswordsByTitle(K id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

		ArrayList<T> result = new ArrayList<T>();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " LIKE ?";
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, "%" + id + "%");

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					result.add((T) buildObject(rs));
				}
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected String getKeyFromObject(Crossword Object) {
		// TODO Auto-generated method stub
		return null;
	}

}
