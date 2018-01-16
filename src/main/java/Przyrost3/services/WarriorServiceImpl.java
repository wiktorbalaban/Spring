package Przyrost3.services;

import Przyrost3.entities.Technique;
import Przyrost3.entities.Warrior;
import Przyrost3.repositories.WarriorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WarriorServiceImpl implements WarriorService {

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
        return repository.checkIfExist(id) > 0;
    }

    public Iterable<Warrior> listAllPaging(Integer pageNr, Integer howManyOnPage) {
        return repository.findAll(new PageRequest(pageNr, howManyOnPage));
    }

    @Override
    public Iterable<Warrior> getByName(String name) {
        return repository.findByName("%" + name + "%");
    }

    @Override
    public Technique getTheMostKnown() {

        ArrayList<Warrior> wl = new ArrayList<>();//Warrior list
        for (Warrior w : repository.findAll()) {
            wl.add(w);
        }
        if (wl.isEmpty()) return null;
        ArrayList<Technique> tl = new ArrayList<>();//Techniques list
        ArrayList<Integer> tucl = new ArrayList<>();//Technique uses count list

        for (Warrior w : wl) {
            for (Technique t : w.getTechniques()) {
                int index = getTechniqueIndexInTechniqueList(t, tl, tucl);
                tucl.set(index, tucl.get(index) + 1);
            }
        }
        if (tucl.isEmpty()) return null;
        int index = getMaxValueIndex(tucl);
        return tl.get(index);
    }

    /***
     *
     * @param t Technique
     * @param tl Techniques list
     * @param tkcl Technique known count list
     * @return index of Technique in Technique list
     */
    private int getTechniqueIndexInTechniqueList(Technique t, ArrayList<Technique> tl, ArrayList<Integer> tkcl) {
        int result = -1;
        for (int i = 0; i < tl.size(); i++) {
            if (t.getId() == tl.get(i).getId()) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            tl.add(t);
            tkcl.add(0);
            result = tl.size() - 1;
        }
        return result;
    }

    /***
     *
     * @param list
     * @return -1 means every value <= 0
     */
    private int getMaxValueIndex(ArrayList<Integer> list) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
