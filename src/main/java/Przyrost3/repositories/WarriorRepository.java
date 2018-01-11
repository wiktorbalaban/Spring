package Przyrost3.repositories;

import Przyrost3.entities.Warrior;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WarriorRepository extends CrudRepository<Warrior, Integer>,
        PagingAndSortingRepository<Warrior, Integer> {

}
