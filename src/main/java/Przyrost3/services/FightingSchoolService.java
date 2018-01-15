package Przyrost3.services;

import Przyrost3.entities.FightingSchool;
import Przyrost3.repositories.FightingSchoolRepository;


public interface FightingSchoolService {

    Iterable<FightingSchool> listAll();

    FightingSchool getById(Integer id);

    Iterable<FightingSchool> getByName(String name);

    FightingSchool save(FightingSchool arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<FightingSchool> listAllPaging(Integer pageNr, Integer howManyOnPage);

    FightingSchool getBest();

}
