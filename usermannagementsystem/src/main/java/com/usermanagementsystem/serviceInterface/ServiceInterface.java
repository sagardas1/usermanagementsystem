package com.usermanagementsystem.serviceInterface;

import java.util.List;

import com.usermanagementsystem.dto.ChangePassword;
import com.usermanagementsystem.dto.Login;
import com.usermanagementsystem.dto.RegistrationDto;

public interface ServiceInterface {

	void insert(RegistrationDto registrationDto);

	void login(Login login);

	void changePassword(ChangePassword changePassword);

	List<RegistrationDto> getListOfUser();

	RegistrationDto getUserDetail(String email);

	void editUser(String email,RegistrationDto registrationDto);

}
