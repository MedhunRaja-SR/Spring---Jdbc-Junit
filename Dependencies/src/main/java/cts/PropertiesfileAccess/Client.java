package cts.PropertiesfileAccess;

public class Client {
	
	private String url;
	private String name;
	private String password;
	
	public Client(String url, String name, String password) {
		super();
		this.url = url;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [url=" + url + ", name=" + name + ", password=" + password + "]";
	}
	
}
