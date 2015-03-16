package mappers;


import java.lang.invoke.SerializedLambda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractMapper  <T, K>{
	
	
	protected DataSource ds;

	protected abstract String getTableName();

	protected abstract String[] getColumnNames();

	protected abstract String getKeyColumnName();

	protected abstract T buildObject(ResultSet rs) throws SQLException;
	
	protected abstract T buildObject(Object[] components) throws SQLException;
	
    protected abstract Object[] serializeObject(T object);
	
    protected abstract Object[] serializeObjectKey(K object);
	
	protected abstract Object decomposeObject(T Object);
	
	public AbstractMapper(DataSource ds) {
		this.ds = ds;
	}
	

    public QueryCondition[] getConditionsFromKey(K id){ 
        
        String[] keyColumnNames = getColumnNames(); 
        QueryCondition[] conditions = new QueryCondition[keyColumnNames.length]; 
        Object columnValues[] = serializeObjectKey(id); 
        for(int i = 0;i < conditions.length;i++){ 
            conditions[i] = new QueryCondition(keyColumnNames[i], QueryOperator.EQ, columnValues[i]); 
        } 
          
        return conditions; 
          
    } 
	
	
	public T findById(K id) {
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String keyColumnName = getKeyColumnName();
		
		String sql = "SELECT " + StringUtils.join(columnNames, ", ") + " FROM "
				+ tableName + " WHERE "+ keyColumnName + " = ?";
		try (Connection con = ds.getConnection();
			 PreparedStatement pst = con.prepareStatement(sql)) {
			
			pst.setObject(1, id);
			
			try(ResultSet rs = pst.executeQuery()) {
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
	
	public void insert (T object)
	{
		
		Connection con = null;
		Statement st = null;
		String tableName = getTableName();
		String[] columnNames = getColumnNames();
		Object[] objeto = serializeObject(object);
		String[] key = new String[columnNames.length];
		
		for(int i = 0; i < key.length; i++)
		{
			if(objeto[i] != null) key[i] = "' '";
			else key[i] = "'" + objeto[i] + "'";
		}
		
		
		try{ 
			con = this.ds.getConnection();
			
			st = con.createStatement();
			
			String sql = "INSERT INTO " + tableName + " " + StringUtils.join(columnNames, ", ") + " INTO " + StringUtils.join(key, ", ");
			
			st.executeUpdate(sql);
		
		}catch(SQLException e){ 
            e.printStackTrace(); 
              
        }finally{ 
            try{ 
                if(st != null) st.close(); 
                if(con != null) con.close(); 
            }catch(SQLException e){} 
              
        } 
	}
	
	public void delete(T object)
	{
		Connection con = null;  
		Statement st = null;
        String tableName = getTableName();
		String[] columnNames = getColumnNames();
		String[] key = new String[columnNames.length];
	
		
		QueryCondition[] conditions = new QueryCondition[getKeyColumnName().length()];
		String[] condString = new String[conditions.length];
		
		for (int i = 0; i < conditions.length; i++)
		{
			conditions[i] = new QueryCondition(getKeyColumnName(), QueryOperator.EQ, key);
		}
		for(int i = 0; i < condString.length; i++)
		{
			condString[i] = conditions[i].getColumnName() + " " + conditions[i].getOperator().getOperator() + 	" '"+ conditions[i].getValue()+"'"; 
		}
	
		try{ 
			con = this.ds.getConnection();
			
			st = con.createStatement();
			
			String sql = "DELETE FROM " + tableName + " WHERE " + StringUtils.join(condString, " AND ");
			
			//DELETE FROM -_______________ WHERE ______________
			
			st.executeUpdate(sql);
		
		}catch(SQLException e){ 
            e.printStackTrace(); 
              
        }finally{ 
            try{ 
                if(st != null) st.close(); 
                if(con != null) con.close(); 
            }catch(SQLException e){} 
              
        } 
       
	}
	
	public void update(T object)
	{
		
		Connection con = null;  
        PreparedStatement stm = null;
        String tableName = getTableName();
		String[] columnNames = getColumnNames();
		Object[] objeto = serializeObject(object);
		String[] key = new String[columnNames.length];
		
		
		//UPDATE _______ SET _______________ WHERE ______________________
	}
	
	

}