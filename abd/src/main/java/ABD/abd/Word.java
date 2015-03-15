package ABD.abd;

import java.sql.Blob;

public class Word {
	
	private String word;
	private String description;
	private int coordX;
	private int coordY;
	private String orientation;
	private Blob picture;
	
	
	//Full constructor without picture
	public Word(String w, String desc, int X, int Y, String ori)
	{
		this.word = w;
		this.description = desc;
		this.coordX = X;
		this.coordY = Y;
		this.orientation = ori;
	}
	
	//Full constructor with picture
	public Word(String w, String desc, int X, int Y, String ori, Blob pict)
	{
		this.word = w;
		this.description = desc;
		this.coordX = X;
		this.coordY = Y;
		this.orientation = ori;
		this.picture = pict;
	}
	
	//Constructor with word and description
	public Word(String w, String desc)
	{
		this.word = w;
		this.description = desc;
	}
	
	
	//Word, description and picture
	public Word(String w, String desc, Blob pict)
	{
		this.word = w;
		this.description = desc;
		this.picture = pict;
	}
	
	
	//Empty constructor
	public Word()
	{
		this.word = null;
		this.coordX = -1;
		this.coordY = -1;
		this.orientation = null;
	}


	
	
	@Override
	public String toString() {
		return "Word [word=" + word + ", coordX=" + coordX + ", coordY="
				+ coordY + ", orientation=" + orientation + "]";
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getCoordX() {
		return coordX;
	}


	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}


	public int getCoordY() {
		return coordY;
	}


	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}


	public String getOrientation() {
		return orientation;
	}


	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}


	public Blob getPicture() {
		return picture;
	}


	public void setPicture(Blob picture) {
		this.picture = picture;
	}





	
	

}
