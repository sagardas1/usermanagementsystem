package com.usermanagementsystem.serviceImpli;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagementsystem.dao.UserDao;
import com.usermanagementsystem.dto.ChangePassword;
import com.usermanagementsystem.dto.Login;
import com.usermanagementsystem.dto.RegistrationDto;
import com.usermanagementsystem.entity.RegistrationEntity;
import com.usermanagementsystem.exception.ExceptionForAtleastOneAlphabateOneNumberOneSpecialCharacter;
import com.usermanagementsystem.exception.PasswordMinimumlengthShouldbeeightdigit;
import com.usermanagementsystem.exception.PasswordandConfirmPasswordDidintMatch;
import com.usermanagementsystem.exception.UserAlreadyPresentException;
import com.usermanagementsystem.exception.UserDoesnotExist;
import com.usermanagementsystem.exception.WrongPassword;
import com.usermanagementsystem.serviceInterface.ServiceInterface;

@Service
public class ServiceImpli implements ServiceInterface {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void insert(RegistrationDto registrationDto) {
		List<RegistrationEntity> entityFromDb = userDao.getUser(registrationDto.getEmail());
		if (entityFromDb.size() > 0) {
			throw new UserAlreadyPresentException("userA", 78, false);

		}
		if (registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
			if (registrationDto.getPassword().length() >= 8) {
				if (isAllPresent(registrationDto.getPassword())) {

					RegistrationEntity entity = modelMapper.map(registrationDto, RegistrationEntity.class);
					userDao.save(entity);

				} else {
					throw new ExceptionForAtleastOneAlphabateOneNumberOneSpecialCharacter(
							"Exception For Atleast One Alphabate One Number One Special Character", 78, false);
				}

			} else {
				throw new PasswordMinimumlengthShouldbeeightdigit("Password Minimum length Should be eight digit", 78,
						false);
			}

		} else {

			throw new PasswordandConfirmPasswordDidintMatch("Password and Confirm Password Didint Match", 78, false);
		}

	}

	private static boolean isAllPresent(String str) {

		String regex = "^(?=.*[a-z])(?=." + "*[A-Z])(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?]).+$";

		Pattern p = Pattern.compile(regex);

		if (str == null) {
			System.out.println("No");
			return false;
		}

		Matcher m = p.matcher(str);

		if (m.matches())
			return true;
		else
			return false;
	}

	@Override
	public void login(Login login) {
		List<RegistrationEntity> entity = userDao.getUser(login.getEmail());
		if (entity.size() > 0) {
			if (!login.getPassword().equals(entity.get(0).getPassword())) {
				throw new WrongPassword("Wrong Password", 78, false);
			}

		} else {
			throw new UserDoesnotExist("User Does not Exist", 78, false);
		}

	}

	@Override
	public void changePassword(ChangePassword changePassword) {
		List<RegistrationEntity> entity = userDao.getUser(changePassword.getEmail());
		if (entity.size() > 0) {

			if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
				if (changePassword.getNewPassword().length() >= 8) {
					if (isAllPresent(changePassword.getNewPassword())) {

						userDao.updateUser(changePassword.getEmail(), changePassword.getNewPassword());

					} else {
						throw new ExceptionForAtleastOneAlphabateOneNumberOneSpecialCharacter(
								"Exception For Atleast One Alphabate One Number One Special Character", 78, false);
					}

				} else {
					throw new PasswordMinimumlengthShouldbeeightdigit("Password Minimum length Should be eight digit",
							78, false);
				}

			} else {

				throw new PasswordandConfirmPasswordDidintMatch("Password and Confirm Password Didint Match", 78,
						false);
			}

		} else {
			throw new UserDoesnotExist("User Does not Exist", 78, false);
		}

	}

	@Override
	public List<RegistrationDto> getListOfUser() {

		List<RegistrationEntity> list = userDao.getAllUser();
		List<RegistrationDto> newList = new ArrayList<>();

		if (list.size() > 0) {

			for (RegistrationEntity l : list) {

				RegistrationDto dto = modelMapper.map(l, RegistrationDto.class);

				newList.add(dto);

			}
		}

		return newList;
	}

	@Override
	public RegistrationDto getUserDetail(String email) {
		List<RegistrationEntity> entityFromDb = userDao.getUser(email);
		RegistrationDto dto = null;
		if (entityFromDb.size() > 0) {
			dto = modelMapper.map(entityFromDb.get(0), RegistrationDto.class);

		} else {
			throw new UserDoesnotExist("User Does not Exist", 78, false);
		}
		return dto;
	}

	@Override
	public void editUser(String email, RegistrationDto registrationDto) {
		List<RegistrationEntity> entity = userDao.getUser(registrationDto.getEmail());
		if (entity.size() > 0) {
			RegistrationEntity entity2 = entity.get(0);

			if (!registrationDto.getDateOfBirth().isEmpty()) {
				entity2.setDateOfBirth(registrationDto.getDateOfBirth());
			}
			if (!registrationDto.getFirstName().isEmpty()) {
				entity2.setFirstName(registrationDto.getFirstName());

			}
			if (!registrationDto.getLastName().isEmpty()) {
				entity2.setLastName(registrationDto.getLastName());
			}
			if (!registrationDto.getUserName().isEmpty()) {
				entity2.setUserName(registrationDto.getUserName());
			}
			
			userDao.updaterecord(entity2.getDateOfBirth(),entity2.getFirstName(),entity2.getLastName(),entity2.getUserName(),entity2.getEmail());

		} else {
			throw new UserDoesnotExist("User Does not Exist", 78, false);
		}

	}
}
