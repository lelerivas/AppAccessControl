package entity;

import java.util.Date;

public class User {
	private Integer cod;
	private String name;
	private String email;
	private Date birthday;
	private String password;
	private Adress adress;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer cod, String name, String email, Date birthday, String password) {
		super();
		this.cod = cod;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [cod=" + cod + ", name=" + name + ", email=" + email + ", birthday=" + birthday + ", password="
				+ password + "]";
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
}
