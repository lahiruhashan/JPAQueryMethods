package hashtips.querymethods.repos;

import hashtips.querymethods.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName); // get , query, read, stream
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    List<User> findByFirstNameOrLastName(String firstName, String lastName);
    List<User> findByDobBetween(LocalDate startDate, LocalDate endDate);
    List<User> findByAgeLessThan(int value);
    // findByAgeLessThanEqual
    // findByAgeGreaterThan
    // findByAgeGreaterThanEqual
    List<User> findByDobAfter(LocalDate date);
    // findByDobBefore
    List<User> findByAgeNotNull();
    // findByAgeNull
    // findByAgeIsNull
    // findByAgeIsNotNull
    List<User> findByFirstNameContaining(String value);
    // findByFirstNameStartingWith
    // findByFirstNameEndingWith
    List<User> findByOrderByAgeDesc();
    // findByOrderByAgeAsc
    List<User> findByFirstNameNot(String value);
    List<User> findByFirstNameIn(Collection<String> list);
    // findByFirstNameNotIn
    List<User> findByActiveTrue();
    // findByActiveFalse
    User findFirstByOrderByAgeDesc();
    List<User> findFirst2ByOrderByAgeDesc();
    //  findTopByOrderByAgeDesc
    // findTop10ByOrderByAgeAsc
    List<User> findByAddress_ZipCode(Long value);
    boolean existsByAgeGreaterThan(int value);
    int countAllByAgeGreaterThan(int value);
}
