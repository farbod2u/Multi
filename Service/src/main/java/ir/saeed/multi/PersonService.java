package ir.saeed.multi;

import java.util.List;

public interface PersonService {
    Person get(Long id);
    List<Person> getAll();
    Person insert(Person entity);
    void update(Person entity);
    Person getByNationalCode(String code);
}
