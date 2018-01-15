package Przyrost3.services;

import Przyrost3.entities.Warrior;

public interface WarriorService {

    Iterable<Warrior> listAll();

    Warrior getById(Integer id);

    Iterable<Warrior> getByName(String name);

    Warrior save(Warrior arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Warrior> listAllPaging(Integer pageNr, Integer howManyOnPage);

}
