package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import com.soulmate.soulmateapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userrepo;

    @InjectMocks
    private UserServiceImpl userserv;

    @Test
    public void givenUsertoSaveThenReturnSavedUser(){
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");

        when(userrepo.save(any())).thenReturn(user);
        userrepo.save(user);
        verify(userrepo,times(1)).save(any());
    }



}