package Przyrost3.services;

import Przyrost3.entities.Technique;

public interface TechniqueService {

    Iterable<Technique> listAll();

    Technique getById(Integer id);

    Iterable<Technique> getByName(String name);

    Technique save(Technique arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Technique> listAllPaging(Integer pageNr, Integer howManyOnPage);

}
