package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class ResuelveMapper extends AbstractMapper<T, K> {

	public ResuelveMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getKeyColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected T buildObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected T buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(T object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(K object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object decomposeObject(T Object) {
		// TODO Auto-generated method stub
		return null;
	}

}
