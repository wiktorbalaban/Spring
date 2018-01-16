package Przyrost3.services;

import Przyrost3.entities.Arena;
import Przyrost3.repositories.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArenasServiceImpl implements ArenaService {

    @Autowired
    private ArenaRepository repository;

    @Override
    public Iterable<Arena> listAll() {
        return repository.findAll();
    }

    @Override
    public Arena getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Arena save(Arena obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return repository.checkIfExist(id) > 0;
    }

    public Iterable<Arena> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Arena> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public long howMany() {
        return repository.count();
    }

}
