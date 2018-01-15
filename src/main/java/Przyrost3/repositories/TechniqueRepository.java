package Przyrost3.repositories;

import Przyrost3.entities.Technique;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TechniqueRepository extends CrudRepository<Technique, Integer>,
        PagingAndSortingRepository<Technique, Integer> {

    Technique findById(int id);

    @Query("select a from Technique a where a.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select a from Technique a where a.name like ?1")
    Iterable<Technique> findByName(String name);

}
