package com.usermanagementsystem.dto;

public class ChangePassword {
	private String email;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
