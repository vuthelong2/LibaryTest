package com.demo.libarytest.User;

import com.demo.libarytest.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    ResponseEntity<ResponseObject> addNewUser(User user) {
        if (userRepository.findUserByName(user.getName()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("name exist", "not good", "")
            );
        } else if (userRepository.findUserByIdCard(user.getIdCard()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("idCard exist", "not good", "")
            );
        } else if (userRepository.findUserByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("email exist", "not good", "")
            );
        } else if (userRepository.findUserByCitizenIdentification(user.getCitizenIdentification()) != null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("citizen exist", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", userRepository.save(user))
        );
    }

    ResponseEntity<ResponseObject> getUserById(Long id) {
        if (userRepository.findUserById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", userRepository.findById(id))
        );
    }

    ResponseEntity<ResponseObject> deleteUser(Long id) {
        if (userRepository.findUserById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "delete success", "")
        );
    }

    ResponseEntity<ResponseObject> updateUser(Long id, User user) {
        if (userRepository.findUserById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        User updateUser = userRepository.findUserById(id);


            if (userRepository.findUserByName(user.getName()) != null && userRepository.findUserByName(user.getName()) != updateUser ) {


                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("name exist", "not good", "")
                );

            } else if (userRepository.findUserByEmail(user.getEmail()) != null && userRepository.findUserByEmail(user.getEmail()) != updateUser) {

                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("email exist", "not good", "")
                );

            } else if (userRepository.findUserByIdCard(user.getIdCard()) != null && userRepository.findUserByIdCard(user.getIdCard()) != updateUser) {

                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("idcard exist", "not good", "")
                );


        }
        updateUser.setIdCard(user.getIdCard());
        updateUser.setEmail(user.getEmail());
        updateUser.setName(user.getName());
        updateUser.setAddress(user.getAddress());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        updateUser.setCitizenIdentification(user.getCitizenIdentification());
        updateUser.setDateOfBirth(user.getDateOfBirth());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", userRepository.save(updateUser)));


    }

}
