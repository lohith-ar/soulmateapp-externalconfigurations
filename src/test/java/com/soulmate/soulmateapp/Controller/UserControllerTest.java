package com.soulmate.soulmateapp.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import com.soulmate.soulmateapp.service.UserService;
import com.soulmate.soulmateapp.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private UserService userserv;

    private SoulmateUser smUser;
    private List<SoulmateUser> userList;

    @InjectMocks
    private UserController userCont;

    @BeforeEach
    public void beforeEach(){
        smUser = new SoulmateUser(1,25,"name1","male");
        mvc = MockMvcBuilders.standaloneSetup(userCont).build();
    }

    @Test
    public void givenUsertoSaveThenReturnSavedUser() throws Exception {
        when(userserv.saveUser(any())).thenReturn(smUser);
        mvc.perform(post("/api/v1/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(smUser)))
                .andExpect(status().isCreated());
        verify(userserv,times(1)).saveUser(any());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}