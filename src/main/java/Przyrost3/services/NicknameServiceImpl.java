package Przyrost3.services;

import Przyrost3.entities.Nickname;
import Przyrost3.repositories.NicknameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NicknameServiceImpl implements NicknameService{

    @Autowired
    private NicknameRepository repository;

    @Override
    public Iterable<Nickname> listAll() {
        return repository.findAll();
    }

    @Override
    public Nickname getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Nickname save(Nickname obj) {
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

    public Iterable<Nickname> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Nickname> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public Nickname getTheLongest(){
        double max = 0;
        int maxId = 0;
        Iterable<Nickname> list = repository.findAll();
        for(Nickname obj : list) {
            int nameLength = obj.getName().length();
            if (nameLength > max) {
                max = nameLength;
                maxId = obj.getId();
            }
        }
        return repository.findOne(maxId);
    }

}
