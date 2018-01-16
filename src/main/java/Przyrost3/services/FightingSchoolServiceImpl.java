package Przyrost3.services;

import Przyrost3.entities.FightingSchool;
import Przyrost3.repositories.FightingSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FightingSchoolServiceImpl implements FightingSchoolService {

    @Autowired
    private FightingSchoolRepository repository;

    @Override
    public Iterable<FightingSchool> listAll() {
        return repository.findAll();
    }

    @Override
    public FightingSchool getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public FightingSchool save(FightingSchool obj) {
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

    public Iterable<FightingSchool> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<FightingSchool> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public FightingSchool getBest() {
        double max = 0;
        int maxId = 0;
        Iterable<FightingSchool> list = repository.findAll();
        for (FightingSchool obj : list) {
            int power = obj.getPercentagetopower();
            if (power > max) {
                max = power;
                maxId = obj.getId();
            }
        }
        return repository.findOne(maxId);
    }

}
