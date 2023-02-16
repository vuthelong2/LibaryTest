package com.demo.libarytest.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
 User findUserByName(String name);
User findUserByIdCard(String idCard);
 User findUserByCitizenIdentification(String citizen);
 User findUserByEmail(String email);

 User findUserById(Long id);
}
