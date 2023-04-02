package com.example.restApiDay1.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.entity.LoginEntity;
import com.example.restApiDay1.repository.LoginRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness=Strictness.LENIENT)
class LoginServiceImplTest {
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	LoginRepository loginRepository;
	
	private LoginDto loginDto;
	private LoginEntity loginEntity;
	
	@BeforeEach
	void init() {
		loginDto=new LoginDto();
		//loginDto.setUsername("rabin");
		//loginDto.setPassword("1234");
		
		loginEntity=new LoginEntity();
		loginEntity.setId(2);
		loginEntity.setUsername("sabin");
		loginEntity.setPassword("1234");
		loginEntity.setRoll("clients");
	}

	@Test
	void testuserLoginRegister() {
		//arrange
		LoginDto loginDto=new LoginDto();
		loginDto.setUsername("rabin");
		loginDto.setPassword("1234");
		when(loginServiceImpl.checkUserExst(any())).thenReturn(false);
		when(loginRepository.save(any(LoginEntity.class))).thenReturn(loginEntity);
		
		//act
		String msg=loginServiceImpl.userLoginRegister(loginDto);
		
		//assert
		assertEquals("usersave",msg);
	}

}
