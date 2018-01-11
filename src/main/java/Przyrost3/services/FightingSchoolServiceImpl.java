package Przyrost3.services;

import Przyrost3.entities.FightingSchool;
import Przyrost3.repositories.FightingSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FightingSchoolServiceImpl implements FightingSchoolService {

    @Autowired
    private FightingSchoolRepository fightingSchoolRepository;

    @Override
    public Iterable<FightingSchool> listAllFightingSchools() {
        return fightingSchoolRepository.findAll();
    }

}
