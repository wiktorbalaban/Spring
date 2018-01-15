package Przyrost3.services;

import Przyrost3.entities.Wife;

public interface WifeService {

    Iterable<Wife> listAll();

    Wife getById(Integer id);

    Iterable<Wife> getByName(String name);

    Wife save(Wife arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Wife> listAllPaging(Integer pageNr, Integer howManyOnPage);

    Wife getBest();

}
