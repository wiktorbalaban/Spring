package Przyrost3.services;

import Przyrost3.entities.Arena;

public interface ArenaService {

    Iterable<Arena> listAll();

    Arena getById(Integer id);

    Iterable<Arena> getByName(String name);

    Arena save(Arena arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Arena> listAllPaging(Integer pageNr, Integer howManyOnPage);

    long howMany();

}
