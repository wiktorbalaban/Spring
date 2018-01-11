package Przyrost3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FightingSchoolRepository extends CrudRepository<FightingSchoolRepository, Integer>,
        PagingAndSortingRepository<FightingSchoolRepository, Integer> {
}
