package com.demo.libarytest.ReturnCard;

import com.demo.libarytest.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReturnCardService{

    private final ReturnCardRepository returnCardRepository;

@Autowired
    public ReturnCardService(ReturnCardRepository returnCardRepository) {
        this.returnCardRepository = returnCardRepository;
    }
    public List<ReturnCard> getAllReturn(){
        return returnCardRepository.findAll();
    }
    ResponseEntity<ResponseObject> addNewReturn(ReturnCard returnCard) {
//        if (borrowRepository.findBookByName(book.getName()) != null) {
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("book exist", "not good", "")
//            );
//        }
        Date needReturnDate =  returnCardRepository.getDate(returnCard.getBorrow().getId());
        System.out.println(needReturnDate);
        if((needReturnDate.getTime() - returnCard.getReturnDate().getTime()) / (24 * 3600 * 1000) >0){
            returnCard.setMoney((double) ((needReturnDate.getTime() - returnCard.getReturnDate().getTime()) / (24 * 3600 * 1000) * 5000));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", returnCardRepository.save(returnCard))
        );
    }


    ResponseEntity<ResponseObject>  getReturnById(Long id) {
        if (returnCardRepository.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", returnCardRepository.findById(id))
        );
    }
    ResponseEntity<ResponseObject> deleteReturn(Long id) {
        if (returnCardRepository.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        returnCardRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "delete success", "")
        );
    }



}
