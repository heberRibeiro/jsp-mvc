package customerregistration.model;

public class Customer {
	
	private String name;
	private String cpf;
	private String email;
	private String born;
	private String sexo;
	private String social;
	private String nickname;
	private String phone;
	
	public Customer() {
	
	}

	public Customer(String name, String cpf, String email, String born, String sexo, String social, String nickname,
			String phone) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.born = born;
		this.sexo = sexo;
		this.social = social;
		this.nickname = nickname;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = social;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
