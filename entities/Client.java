package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Client() {

	}

	public Client(String name, String email, Date date) {
		this.name = name;
		this.email = email;
		this.birthDate = date;
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

	public Date getDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + " (" + sdf.format(birthDate) + ") - " + email);
		return sb.toString();
	}
	

}
