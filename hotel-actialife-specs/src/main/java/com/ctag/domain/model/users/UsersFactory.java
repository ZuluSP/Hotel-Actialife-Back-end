package com.ctag.domain.model.users;


import org.seedstack.business.domain.Factory;

public interface UsersFactory extends Factory<User> {


 User createUser(
     
     String name,
     String surname,
     String email,
     String phone,
     String address,
     String password,
     Integer idRole);
}