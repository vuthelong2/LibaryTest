package com.demo.libarytest.Borrow;

import com.demo.libarytest.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {


    private final BorrowRepository borrowRepository;
    @Autowired
    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }
public List<Borrow> getAllBorrows(){
        return borrowRepository.findAll();
}
    ResponseEntity<ResponseObject> addNewBorrow(Borrow borrow) {
//        if (borrowRepository.findBookByName(book.getName()) != null) {
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("book exist", "not good", "")
//            );
//        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", borrowRepository.save(borrow))
        );
    }


    ResponseEntity<ResponseObject>  getBorrowById(Long id) {
        if (borrowRepository.getBorrowById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "good", borrowRepository.getBorrowById(id))
        );
    }
    ResponseEntity<ResponseObject> deleteBook(Long id) {
        if (borrowRepository.getBorrowById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("id not found", "not good", "")
            );
        }
        borrowRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "delete success", "")
        );
    }


}
