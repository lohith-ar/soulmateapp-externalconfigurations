package com.soulmate.soulmateapp.service;

import com.soulmate.soulmateapp.domain.SoulmateUser;

import java.util.List;

public interface UserService {

    public SoulmateUser saveUser(SoulmateUser user);
    public List<SoulmateUser> getAllUsers();
    public SoulmateUser updateUseronID(Integer id, SoulmateUser user);
    public void deleteUseronID(int id);
    public List<SoulmateUser> getAllUsersbyGender(String gender);
    public List<SoulmateUser> getAllUsersbyAge(int age);
    public List<SoulmateUser> getAllUsersbyName(String name);





}
