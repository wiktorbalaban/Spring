package Przyrost3.repositories;

import Przyrost3.entities.Wife;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WifeRepository extends CrudRepository<Wife, Integer>,
        PagingAndSortingRepository<Wife, Integer> {

    Wife findById(int id);

    @Query("select a from Wife a where a.id = ?1")
    Integer checkIfExist(Integer id);

}
