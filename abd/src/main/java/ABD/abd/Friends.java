package ABD.abd;

public class Friends {
	
	
	private String nick1;
	private String nick2;
	public Friends()
	{
		this.nick1 = null;
		this.nick2 = null;
	}
	
	public Friends(String nick1)
	{
		this.nick1 = nick1;
		this.nick2 = null;
	}

	
	public Friends(String nick1, String nick2)
	{
		this.nick1 = nick1;
		this.nick2 = nick2;
	}

	public String getNick1() {
		return nick1;
	}

	public void setNick1(String nick1) {
		this.nick1 = nick1;
	}

	public String getNick2() {
		return nick2;
	}

	public void setNick2(String nick2) {
		this.nick2 = nick2;
	}
}
