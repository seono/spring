package spring;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterRequest {

	@Email
	@NotBlank
	private String email;
	@Size(min=6)
	private String password;
	@NotEmpty
	private String confirmPassword;
	@NotEmpty
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private LocalDate Birth;
	
	public void setBirth(LocalDate birth) {
		Birth = birth;
	}
	public LocalDate getBirth() {
		return Birth;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
}
