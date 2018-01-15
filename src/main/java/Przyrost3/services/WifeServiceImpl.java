package Przyrost3.services;

import Przyrost3.entities.Wife;
import Przyrost3.repositories.WifeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WifeServiceImpl implements WifeService {

    @Autowired
    private WifeRepository repository;

    @Override
    public Iterable<Wife> listAll() {
        return repository.findAll();
    }

    @Override
    public Wife getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Wife save(Wife obj) {
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

    public Iterable<Wife> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Wife> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public Wife getBest() {
        double max = 0;
        int maxId = 0;
        Iterable<Wife> list = repository.findAll();
        for(Wife obj : list) {
            int power = obj.getPercentagetopower();
            if (power > max) {
                max = power;
                maxId = obj.getId();
            }
        }
        return repository.findOne(maxId);
    }

}
