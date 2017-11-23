package advance.iak.advance3.model;

public class User{

	private String login, url, name;
	private int id;

	public User() {}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", url='" + url + '\'' +
				", name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}