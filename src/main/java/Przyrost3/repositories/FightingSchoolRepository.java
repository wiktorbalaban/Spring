package Przyrost3.repositories;

import Przyrost3.entities.FightingSchool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FightingSchoolRepository extends CrudRepository<FightingSchool, Integer>,
        PagingAndSortingRepository<FightingSchool, Integer> {

    FightingSchool findById(int id);

    @Query("select a from FightingSchool a where a.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select a from FightingSchool a where a.name like ?1")
    Iterable<FightingSchool> findByName(String name);

}
