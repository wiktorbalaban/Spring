package Przyrost3.services;

import Przyrost3.entities.Technique;
import Przyrost3.repositories.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TechniqueServiceImpl implements TechniqueService {

    @Autowired
    private TechniqueRepository repository;

    @Override
    public Iterable<Technique> listAll() {
        return repository.findAll();
    }

    @Override
    public Technique getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Technique save(Technique obj) {
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

    public Iterable<Technique> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Technique> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public Technique getBest() {
        double max = 0;
        int maxId = 0;
        Iterable<Technique> list = repository.findAll();
        for(Technique obj : list) {
            int power = obj.getPercentagetopower();
            if (power > max) {
                max = power;
                maxId = obj.getId();
            }
        }
        return repository.findOne(maxId);
    }

}
