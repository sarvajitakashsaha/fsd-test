//package com.cts.newsReporter.controller;
//
//public class MockitoTest {
//
//}
package com.cts.newsReporter.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cts.newsReporter.bean.Language;
import com.cts.newsReporter.bean.Role;
import com.cts.newsReporter.bean.SignupStatus;
import com.cts.newsReporter.bean.User;
import com.cts.newsReporter.repository.ArticleRepository;
import com.cts.newsReporter.repository.LanguageRepository;
import com.cts.newsReporter.repository.RoleRepository;
import com.cts.newsReporter.repository.UserRepository;
import com.cts.newsReporter.service.UserService;




public class MockitoTest {
	
	@Mock
	private UserRepository userRepository;
	@Mock
	private RoleRepository roleRepository;
	@Mock
	private LanguageRepository languageRepository;
	@Mock
	private ArticleRepository articleRepository;
	
	@InjectMocks
	private UserService userservice;
	
	
	
    @Before
	    public void setUp() throws Exception {
	         MockitoAnnotations.initMocks(this);
	    }
    
    @Test
    public void testSaveUserDetails() {    
    	User nullUser = null;
        User user = new User();
        Role role = new Role();
        Language language = new Language();
        user.setEmail("saha.sarva");
        user.setPassword("123");
        user.setName("Sarvajit");
        user.setArticle(null);
        user.setStatus(false);
        role.setId(2);
        user.setRole(role);
        language.setId(1);
        user.setLanguage(language);
        Mockito.when(userRepository.fetchUserDetailsByEmail(user.getEmail()) ).thenReturn(nullUser);
        SignupStatus status=userservice.save(user);
        assertEquals(true, status.isSignupStatus() && !status.isEmailExist());
               
    }
    
    @Test
    public void testDuplicateUserEmail() {
        User user = new User();
        Role role = new Role();
        Language language = new Language();
        user.setEmail("saha");
        user.setPassword("123");
        user.setName("sarvajit");
        user.setArticle(null);
        user.setStatus(false);
        role.setId(2);
        user.setRole(role);
        language.setId(1);
        user.setLanguage(language);
        User existedUser = userRepository.fetchUserDetailsByEmail(user.getEmail());
        Mockito.when(userRepository.fetchUserDetailsByEmail(user.getEmail()) ).thenReturn(existedUser);
        SignupStatus status=userservice.save(user);
        assertEquals(false, !status.isSignupStatus() && status.isEmailExist());
               
               
    }
}
