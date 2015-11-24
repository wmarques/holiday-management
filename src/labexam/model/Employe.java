package labexam.model;

public class Employe {
	
	private int login;
	private String password;
	
	public Employe(int login, String password) {
		this.login = login;
		this.password = password;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
