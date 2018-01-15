package Przyrost3.repositories;

import Przyrost3.entities.Warrior;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WarriorRepository extends CrudRepository<Warrior, Integer>,
        PagingAndSortingRepository<Warrior, Integer> {

    Warrior findById(int id);

    @Query("select a from Warrior a where a.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select a from Warrior a where a.name like ?1")
    Iterable<Warrior> findByName(String name);

}
