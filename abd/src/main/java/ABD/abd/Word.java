package ABD.abd;

import java.sql.Blob;

import es.ucm.abd.crossword.WordModel;

public class Word implements WordModel{
	
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
	//constructor without description
	public Word(String w,  int X, int Y, String ori)
	{
		this.word = w;
		this.description = null;
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
	
	public Word(String word)
	{
		this.word = word;
		this.coordX = -1;
		this.coordY = -1;
		this.orientation = null;
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
		return "Word [word=" + word + ", description=" + description
				+ ", coordX=" + coordX + ", coordY=" + coordY
				+ ", orientation=" + orientation + ", picture=" + picture + "]";
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

	public void setX(int coordX) {
		this.coordX = coordX;
	}

	@Override
	public int getX() {
		return coordX;
	}

	@Override
	public int getY() {
		return coordY;
	}

	@Override
	public boolean isHorizontal() {
		if (orientation.equalsIgnoreCase("h") ){
			return true;
		}
		else return false;
	}





	
	

}
