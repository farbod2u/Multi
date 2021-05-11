package ir.saeed.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("{id}")
    public Person get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return service.getAll();
    }

    @GetMapping("/nat/{code}")
    public Person getByNationalCode(@PathVariable String code) {
        return service.getByNationalCode(code);
    }

    @PostMapping
    public Person insert(@RequestBody Person entity) {
        return service.insert(entity);
    }

    @PutMapping
    public void update(@RequestBody Person entity) {
        service.update(entity);
    }


}
