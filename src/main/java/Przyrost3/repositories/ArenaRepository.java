package Przyrost3.repositories;

import Przyrost3.entities.Arena;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArenaRepository extends CrudRepository<Arena, Integer>, PagingAndSortingRepository<Arena, Integer> {

    Arena findById(int id);

    @Query("select a from Arena a where a.id = ?1")
    Integer checkIfExist(Integer id);

    @Query("select a from Arena a where a.name like ?1")
    Iterable<Arena> findArenasByName(String name);


}
