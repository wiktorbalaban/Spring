package Przyrost3.repositories;

import Przyrost3.entities.FightingSchool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FightingSchoolRepository extends CrudRepository<FightingSchool, Integer>,
        PagingAndSortingRepository<FightingSchool, Integer> {
}
