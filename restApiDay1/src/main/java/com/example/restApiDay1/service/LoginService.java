package com.example.restApiDay1.service;

import java.util.List;

import javax.validation.Valid;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.response.ClientResposeDto;



public interface LoginService {

	String userLoginRegister(LoginDto loginDto);

	String deleteById(LoginDto loginDto);

	String fingByUsername(int id,String Username);

	List<LoginDto> getAllRecord();

	List<ClientResposeDto> getAllRecordByUserRoll(String roll);

	
	
	


	

	

}
