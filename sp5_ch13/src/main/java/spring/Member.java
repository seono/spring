package spring;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDate Birth;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password, String name, LocalDate Birth, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.Birth = Birth;
		this.registerDateTime = registerDateTime;
	}
	public LocalDate getBirth() {
		return Birth;
	}
	public void setBirth(LocalDate birth) {
		this.Birth = birth;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}
	
	public boolean matchPassword(String password) {
		return this.password.contentEquals(password);
	}
}
