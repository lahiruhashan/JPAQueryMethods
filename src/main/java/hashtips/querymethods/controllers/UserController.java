package hashtips.querymethods.controllers;

import hashtips.querymethods.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getUsers () {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/firstName")
    public ResponseEntity<?> findByFirstName () {
        return new ResponseEntity<>(userService.getUserByFirstName("John"), HttpStatus.OK);
    }

    @GetMapping("/firstNameAndLastName")
    public ResponseEntity<?> findByFirstNameAndLastName () {
        return new ResponseEntity<>(userService.getUserByFirstNameAndLastName("Brian", "Runner"), HttpStatus.OK);
    }

    @GetMapping("/firstNameOrLastName")
    public ResponseEntity<?> findByFirstNameOrLastName () {
        return new ResponseEntity<>(userService.getUserByFirstNameOrLastName("Brian", "Runner"), HttpStatus.OK);
    }

    @GetMapping("/dobBetween")
    public ResponseEntity<?> findByDobBetween () {
        return new ResponseEntity<>(userService
                .getUserByDobBetween(LocalDate.parse("1990-01-01"), LocalDate.parse("2020-12-12")), HttpStatus.OK);
    }

    @GetMapping("/ageLessThan")
    public ResponseEntity<?> findByAgeLessThan () {
        return new ResponseEntity<>(userService
                .getUserAgeLessThan(50), HttpStatus.OK);
    }

    @GetMapping("/dobAfter")
    public ResponseEntity<?> findByDobAfter () {
        return new ResponseEntity<>(userService
                .getUserDobAfter(LocalDate.parse("2000-01-01")), HttpStatus.OK);
    }

    @GetMapping("/age")
    public ResponseEntity<?> findByAge() {
        return new ResponseEntity<>(userService
                .getUserAgeNotNull(), HttpStatus.OK);
    }

    @GetMapping("/containing")
    public ResponseEntity<?> findByContaining() {
        return new ResponseEntity<>(userService
                .getUserContaining("pete"), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<?> findByAgeOrder() {
        return new ResponseEntity<>(userService
                .getUserAgeOrder(), HttpStatus.OK);
    }

    @GetMapping("/not")
    public ResponseEntity<?> findByFirstNameNot() {
        return new ResponseEntity<>(userService
                .getUserNot("Pete"), HttpStatus.OK);
    }

    @GetMapping("/in")
    public ResponseEntity<?> findByFirstNameIn() {
        return new ResponseEntity<>(userService
                .getUserIn(new ArrayList<>(Arrays.asList("Peter", "Pete", "John", "Thomas"))), HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<?> findByAcive() {
        return new ResponseEntity<>(userService
                .getUserActive(), HttpStatus.OK);
    }

    @GetMapping("/first")
    public ResponseEntity<?> findByFirst() {
        return new ResponseEntity<>(userService
                .getUserAgeFirst(), HttpStatus.OK);
    }

    @GetMapping("/first2")
    public ResponseEntity<?> findByFirst2() {
        return new ResponseEntity<>(userService
                .getUserAgeFirst2(), HttpStatus.OK);
    }

    @GetMapping("/zipCode")
    public ResponseEntity<?> findByZipCode() {
        return new ResponseEntity<>(userService
                .getUserZipCode(12345L), HttpStatus.OK);
    }

    @GetMapping("/exists")
    public ResponseEntity<?> exists() {
        return new ResponseEntity<>(userService
                .userExists(50), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count() {
        return new ResponseEntity<>(userService
                .count(30), HttpStatus.OK);
    }
}
