package mappers;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.ImageIcon;

import ABD.abd.User;
import ABD.abd.Word;

public class WordMapper extends AbstractMapper<Word, String> {

	private static final String word_key_name = "Secuencia";
	private static final String[] word_column_names = new String[] {
			"Secuencia", "Descripcion", "Foto_palabra" };
	private static final String word_table_name = "palabra";

	public WordMapper(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getTableName() {

		return word_table_name;
	}

	@Override
	protected String[] getColumnNames() {

		return word_column_names;
	}

	@Override
	protected String getKeyColumnName() {

		return word_key_name;
	}

	@Override
	protected Word buildObject(ResultSet rs) throws SQLException {
		Blob foto = rs.getBlob("Foto_palabra");
		
		ImageIcon im = null;
		
		
		
		if(!rs.wasNull()) im = new ImageIcon(foto.getBytes(1, (int)foto.length()));
		
		return new Word(rs.getString("Secuencia"), rs.getString("Descripcion"),
				im);
	}

	@Override
	protected Word buildObject(Object[] components) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObject(Word object) {

		return new Object[] { object.getWord(), object.getDescription(),
				object.getPicture() };
	}

	@Override
	protected Object decomposeObject(Word Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] serializeObjectKey(String object) {
		return new Object[] { object };
	}

	@Override
	protected String getKeyFromObject(Word Object) {

		return Object.getWord();
	}

	@Override
	protected String getKeyColumnNameForFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Word buildObjectForFriend(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
