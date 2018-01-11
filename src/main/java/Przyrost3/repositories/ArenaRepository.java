package Przyrost3.repositories;

import Przyrost3.entities.Arena;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArenaRepository extends CrudRepository<Arena, Integer>, PagingAndSortingRepository<Arena, Integer> {

}
