package com.usermanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagementsystem.baseResponce.BaseResponce;
import com.usermanagementsystem.dto.ChangePassword;
import com.usermanagementsystem.dto.Login;
import com.usermanagementsystem.dto.RegistrationDto;
import com.usermanagementsystem.serviceInterface.ServiceInterface;

@RestController
public class UserController {

	@Autowired
	private ServiceInterface serviceInterface;

	@PostMapping("/create")
	public BaseResponce insert(@RequestBody RegistrationDto registrationDto) {
		serviceInterface.insert(registrationDto);
		return BaseResponce.setBaseResponce(null, "SuccessFull", 200, true);
	}

	@PostMapping("/login")
	public BaseResponce login(@RequestBody Login login) {
		serviceInterface.login(login);
		return BaseResponce.setBaseResponce(null, "Success", 200, true);

	}

	@PostMapping("/changePassword")
	public BaseResponce changePassWord(@RequestBody ChangePassword changePassword) {
		serviceInterface.changePassword(changePassword);
		return BaseResponce.setBaseResponce(null, "Password Changes Sucessfully", 200, true);

	}
	
	@PostMapping("/edituser/{email}")
	public BaseResponce editUser(@PathVariable String email,@RequestBody RegistrationDto registrationDto) {
		serviceInterface.editUser(email,registrationDto);
		return BaseResponce.setBaseResponce(null, "SuccessFull", 200, true);
	}

	@GetMapping("/getAllUser")
	public BaseResponce getAllUser() {
		return BaseResponce.setBaseResponce(serviceInterface.getListOfUser(), "success", 200, true);
	}

	
	@GetMapping("/getUserDetails/{email}")
	public BaseResponce getUserDetails(@PathVariable String email) {
		return BaseResponce.setBaseResponce(serviceInterface.getUserDetail(email), "Updated successfully.", 200, true);
	}

}
