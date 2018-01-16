package Przyrost3.services;

import Przyrost3.entities.Tournament;
import Przyrost3.entities.Warrior;
import Przyrost3.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository repository;

    @Override
    public Iterable<Tournament> listAll() {
        return repository.findAll();
    }

    @Override
    public Tournament getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Tournament save(Tournament obj) {
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

    public Iterable<Tournament> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Tournament> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public Warrior getWinner(Integer id) {
        Warrior result = null;
        int max = 0;
        int index = 0;
        Tournament t = repository.findOne(id);
        if (t.getParticipants().size() > 0) {
            for (int i = 0; i < t.getParticipants().size(); i++) {
                int power = t.getParticipants().get(i).getFullPower();
                if (power > max) {
                    max = power;
                    index = i;
                }
            }
            result = t.getParticipants().get(index);
        }
        return result;
    }

}
