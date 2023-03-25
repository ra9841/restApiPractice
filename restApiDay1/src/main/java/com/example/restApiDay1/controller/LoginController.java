package com.example.restApiDay1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.service.LoginService;
import com.example.restApiDay1.service.UserInfoService;

@RestController
@RequestMapping("/v")
public class LoginController {
	@Autowired
	LoginService loginservice;
	
	@Autowired
	UserInfoService userInfoService;
	
	
	@PostMapping("/register")
	public String userRegister( @RequestBody @Valid LoginDto loginDto) {
		String message=loginservice.userLoginRegister(loginDto);
		return message;	
	}
	
	@PostMapping("/registerInfo")
	public String userRegisterInfo( @RequestBody  UerInfoDto userInfoDto) {
		String message=userInfoService.userLoginRegisterInfo(userInfoDto);
		return message;	
	}


}
