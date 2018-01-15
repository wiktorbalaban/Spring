package Przyrost3.services;

import Przyrost3.entities.Nickname;

public interface NicknameService {

    Iterable<Nickname> listAll();

    Nickname getById(Integer id);

    Iterable<Nickname> getByName(String name);

    Nickname save(Nickname arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Nickname> listAllPaging(Integer pageNr, Integer howManyOnPage);

    Nickname getTheLongest();

}
