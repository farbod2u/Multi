package ir.saeed.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServideImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Person get(Long id) {
        Optional<Person> entity = repository.findById(id);
        if (entity.isPresent())
            return entity.get();
        else
            throw new MyNotFoundException("Person with id = " + id.toString() + " not found.");
    }

    @Override
    public List<Person> getAll() {
        List<Person> ret = repository.findAll();

        if (ret != null && !ret.isEmpty())
            return ret;
        else
            throw new MyNotFoundException("Personals not found.");
    }

    @Override
    public Person insert(Person entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void update(Person entity) {
        Person origEntity = this.get(entity.getId());

        if (entity.getFirstName() != null)
            origEntity.setFirstName(entity.getFirstName());
        if (entity.getLastName() != null)
            origEntity.setLastName(entity.getLastName());
    }


}
