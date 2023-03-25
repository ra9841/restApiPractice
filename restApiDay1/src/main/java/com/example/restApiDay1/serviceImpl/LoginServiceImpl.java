package com.example.restApiDay1.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.entity.LoginEntity;
import com.example.restApiDay1.repository.LoginRepository;
import com.example.restApiDay1.response.ClientResposeDto;
import com.example.restApiDay1.service.LoginService;
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	//to check user exist or not
	//it is created because it helps to decrease biolerplate code.we can use it again and again
	public boolean checkUserExst(String username) {
		//Optional<LoginEntity>checkuser=loginRepository.findByUsername(username);
		//loginRepository.existsByUsername(username);
		if(loginRepository.existsByUsername(username)) {
			return true;
		}
		return false;
	}

	@Override
	public String userLoginRegister(LoginDto loginDto) {
		LoginEntity loginEntity= new LoginEntity();//blank
		BeanUtils.copyProperties(loginDto, loginEntity);
		boolean userExistOrNot=checkUserExst(loginEntity.getUsername());//calling metod 
		if(userExistOrNot) {
			return "already exist";	
		}else {	
			loginEntity.setRoll("user");//giving role to the record
			loginRepository.save(loginEntity);
			return "usersave";
	}
	}
	


	@Override
	public String deleteById(LoginDto loginDto) {
		LoginEntity loginEntity= new LoginEntity();//blank
		BeanUtils.copyProperties(loginDto, loginEntity);
		boolean userExistOrNot=checkUserExst(loginEntity.getUsername());
		if(userExistOrNot) {
			loginRepository.deleteByUsername(loginEntity.getUsername());
			return "delete Successfully";
		}else {
			return "delete failed user not exist";
		}
		
	}



	@Override
	public String fingByUsername(int id,String username) {
		Optional<LoginEntity>optional=loginRepository.findById(id);
		if(optional.get().getUsername()==username) {
			return "duplicate value";
		}
		LoginEntity loginEntity=optional.get();
		loginEntity.setUsername(username);
		LoginDto loginDto=new LoginDto();
		BeanUtils.copyProperties(loginEntity, loginDto);
		loginRepository.save(loginEntity);
		return "saved";
	}

	@Override
	public List<LoginDto> getAllRecord() {
		List<LoginEntity>loginEntity=loginRepository.findAll();
		List<LoginDto>loginDtoList=new ArrayList <>();//blank list
		
		for(LoginEntity gettingrecord:loginEntity) {
			LoginDto allUserInfo=new LoginDto();//blank
			BeanUtils.copyProperties(gettingrecord, allUserInfo);//copying
			loginDtoList.add(allUserInfo);
		}
		return loginDtoList;
	}

	@Override
	public List<ClientResposeDto> getAllRecordByUserRoll(String roll) {
		List<LoginEntity>loginEntity=loginRepository.findByRoll(roll);
		List<ClientResposeDto>loginDtoList=new ArrayList <>();//blank list
		
		for(LoginEntity gettingrecord:loginEntity) {
			ClientResposeDto allUserInfo=new ClientResposeDto();//blank
			BeanUtils.copyProperties(gettingrecord, allUserInfo);//copying
			loginDtoList.add(allUserInfo);
		}
		return loginDtoList;
	}




	

}
