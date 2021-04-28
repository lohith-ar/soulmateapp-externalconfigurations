package com.soulmate.soulmateapp.repository;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userrepo;

    @Test
    public void givenUserToSaveShouldReturnSavedUser(){
        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
        userrepo.save(user);
        SoulmateUser user1 = userrepo.findById(user.getId()).get();
        assertNotNull(user1);
        assertEquals(user.getName(), user1.getName());
    }

//    @Test
//    public void givenUsersTogetAllUsers(){
//        SoulmateUser user = new SoulmateUser(1,25,"name1","male");
//        userrepo.save(user);
//        List<SoulmateUser> ll = use
//
//        SoulmateUser user1 = userrepo.findById(user.getId()).get();
//        assertNotNull(user1);
//        assert
//    }




}