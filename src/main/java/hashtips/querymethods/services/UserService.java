package hashtips.querymethods.services;

import hashtips.querymethods.domains.User;
import hashtips.querymethods.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Iterable<User> getAllUsers () {
        return repository.findAll();
    }

    public List<User> getUserByFirstName (String firstName) {
        return repository.findByFirstName(firstName);
    }

    public List<User> getUserByFirstNameAndLastName (String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<User> getUserByFirstNameOrLastName (String firstName, String lastName) {
        return repository.findByFirstNameOrLastName(firstName, lastName);
    }

    public List<User> getUserByDobBetween (LocalDate startDate, LocalDate endDate) {
        return repository.findByDobBetween(startDate, endDate);
    }

    public List<User> getUserAgeLessThan(int value) {
        return repository.findByAgeLessThan(value);
    }

    public List<User> getUserDobAfter(LocalDate date) {
        return repository.findByDobAfter(date);
    }

    public List<User> getUserAgeNotNull() {
        return repository.findByAgeNotNull();
    }

    public List<User> getUserContaining(String value) {
        return repository.findByFirstNameContaining(value);
    }

    public List<User> getUserAgeOrder() {
        return repository.findByOrderByAgeDesc();
    }

    public List<User> getUserNot(String value) {
        return repository.findByFirstNameNot(value);
    }

    public List<User> getUserIn(Collection<String> list) {
        return repository.findByFirstNameIn(list);
    }

    public List<User> getUserActive() {
        return repository.findByActiveTrue();
    }

    public User getUserAgeFirst() {
        return repository.findFirstByOrderByAgeDesc();
    }

    public List<User> getUserAgeFirst2() {
        return repository.findFirst2ByOrderByAgeDesc();
    }

    public List<User> getUserZipCode(Long value) {
        return repository.findByAddress_ZipCode(value);
    }

    public boolean userExists(int value) {
        return repository.existsByAgeGreaterThan(value);
    }

    public int count(int value) {
        return repository.countAllByAgeGreaterThan(value);
    }
}
