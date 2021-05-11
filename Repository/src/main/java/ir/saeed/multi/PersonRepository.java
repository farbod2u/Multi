package ir.saeed.multi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("from Person where Nationalcode = ?1")
    Optional<Person> findByNationalCode(String code);
}
