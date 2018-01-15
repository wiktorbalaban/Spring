package Przyrost3.services;

import Przyrost3.entities.Warrior;
import Przyrost3.repositories.WarriorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WarriorServiceImpl implements WarriorService{

    @Autowired
    private WarriorRepository repository;

    @Override
    public Iterable<Warrior> listAll() {
        return repository.findAll();
    }

    @Override
    public Warrior getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Warrior save(Warrior obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (repository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    public Iterable<Warrior> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Warrior> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

}
