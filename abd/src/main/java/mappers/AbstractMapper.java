package mappers;

import java.lang.invoke.SerializedLambda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import ABD.abd.Crossword;
import ABD.abd.User;

public abstract class AbstractMapper<T, K> {

	protected DataSource ds;

	protected abstract String getTableName();

	protected abstract String[] getColumnNames();

	protected abstract String getKeyColumnName();

	protected abstract T buildObject(ResultSet rs) throws SQLException;
	
	protected abstract T buildObjectForFriend(ResultSet rs) throws SQLException;
	
	protected abstract T buildObject(Object[] components) throws SQLException;

	protected abstract Object[] serializeObject(T object);

	protected abstract Object[] serializeObjectKey(K object);

	protected abstract Object decomposeObject(T Object);

	protected abstract K getKeyFromObject(T Object);

	protected abstract String getKeyColumnNameForFriend();
	
	public AbstractMapper(DataSource ds) {
		this.ds = ds;
	}

	public QueryCondition[] getConditionsFromKey(K id) {

		String[] keyColumnNames = getColumnNames();
		QueryCondition[] conditions = new QueryCondition[keyColumnNames.length];
		Object columnValues[] = serializeObjectKey(id);
		for (int i = 0; i < conditions.length; i++) {
			conditions[i] = new QueryCondition(keyColumnNames[i],
					QueryOperator.EQ, columnValues[i]);
		}

		return conditions;

	}

	public QueryCondition[] getConditionsFromKey3(T id) {

		String[] keyColumnNames = getColumnNames();
		QueryCondition[] conditions = new QueryCondition[keyColumnNames.length];
		Object columnValues[] = serializeObject(id);
		for (int i = 0; i < conditions.length; i++) {
			conditions[i] = new QueryCondition(keyColumnNames[i],
					QueryOperator.EQ, columnValues[i]);
		}

		return conditions;

	}
	
	public QueryCondition[] getConditionsFromKey2(K id) {

		String keyColumnNames = getKeyColumnName();
		QueryCondition[] conditions = new QueryCondition[1];
		Object columnValues[] = serializeObjectKey(id);
		for (int i = 0; i < conditions.length; i++) {
			conditions[i] = new QueryCondition(keyColumnNames,
					QueryOperator.EQ, columnValues[i]);
		}

		return conditions;

	}
	//devuelve un unico objeto a partir de una id
	public T findById(K id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

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

	
	//encuentra todos los objetos a partir de una id
	public ArrayList<T> find(K id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

		ArrayList<T> result = new ArrayList<T>();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " = ?";
		System.out.println(sql);
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					result.add(buildObject(rs));
				}
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//realiza la misma funcion que find, pero para el 2º valor de clave, usado para friend
	public ArrayList<T> findForFriend(K id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnNameForFriend();

		ArrayList<T> result = new ArrayList<T>();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " = ?";
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					result.add(buildObjectForFriend(rs));
				}
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//encuentra todos los objetos a partir de una id, pero lo devuelve como tipo list
	public List<T> find2(K id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

		ArrayList<T> result = new ArrayList<T>();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " = ?";
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					result.add(buildObject(rs));
				}
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insert(T object) {

		Connection con = null;
		Statement st = null;
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		Object[] objeto = serializeObject(object);
		String[] key = new String[columnNames.length];

		for (int i = 0; i < key.length; i++) {
			if (objeto[i] == null)
				key[i] = "NULL";
			else
				key[i] = "'" + (String) objeto[i] + "'";

		}

		try {
			con = this.ds.getConnection();

			st = con.createStatement();

			String sql = "INSERT INTO " + tableName + " ("
					+ StringUtils.join(columnNames, ", ") + ") VALUES ("
					+ StringUtils.join(key, ", ") + ")";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}

		}
	}

	public void delete(T object) {
		 Connection con = null;  
	        PreparedStatement stm = null;

	        QueryCondition[] conditions = getConditionsFromKey3(object);   
	        
	        String[] conditionsStr = new String[conditions.length]; 
	          
	        for(int i = 0;i < conditionsStr.length;i++){ 
	            conditionsStr[i] = conditions[i].getColumnName() + " " + conditions[i].getOperator().getOperator() + 
	            		" '"+ conditions[i].getValue()+"'"; 
	        }                
	        
	        try { 
	        	con = this.ds.getConnection(); 
	            String sql = "DELETE FROM " + getTableName() + " WHERE " + StringUtils.join(conditionsStr, " AND ");
	            System.out.println(sql);
	            stm = con.prepareStatement(sql);
	            
	            stm.executeUpdate();
	            
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        } 

	}

	public void update(T object) {

		Connection con = null;
		Statement st = null;
		String tableName = getTableName();
		String[] columnNames = getColumnNames();

		String[] assignments = new String[columnNames.length];

		QueryCondition[] conditions = getConditionsFromKey2(getKeyFromObject(object));
		String[] condString = new String[conditions.length];

		Object[] objeto = serializeObject(object);
		String[] key = new String[columnNames.length];

		for (int i = 0; i < key.length; i++) {
			if (objeto[i] == null)
				key[i] = "NULL";
			else
				key[i] = "'" + (String) objeto[i] + "'";

		}

		for (int i = 0; i < condString.length; i++) {
			condString[i] = conditions[i].getColumnName() + " "
					+ conditions[i].getOperator().getOperator() + key[i];
		}
		for (int i = 0; i < assignments.length; i++) {
			assignments[i] = columnNames[i] + " = " + key[i];
		}

		try {
			con = this.ds.getConnection();

			st = con.createStatement();

			String sql = "UPDATE " + tableName + " SET "
					+ StringUtils.join(assignments, ", ") + " WHERE "
					+ StringUtils.join(condString, " AND ");
			System.out.println(sql);
			// UPDATE _______ SET _______________ WHERE ______________________

			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}

		}

	}

	public ArrayList<T> find(K id, boolean b) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();

		ArrayList<T> result = new ArrayList<T>();

		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE " + keyColumnName + " = ?";
		try (Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setObject(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					result.add(buildObject(rs));
				}
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
