package Przyrost3.services;

import Przyrost3.entities.FightingSchool;
import Przyrost3.repositories.FightingSchoolRepository;

public interface FightingSchoolService {

    Iterable<FightingSchool> listAllFightingSchools();

}
