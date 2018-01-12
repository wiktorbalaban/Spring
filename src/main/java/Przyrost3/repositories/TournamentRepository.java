package Przyrost3.repositories;

import Przyrost3.entities.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Integer>,
        PagingAndSortingRepository<Tournament, Integer> {

    Tournament findById(int id);

    @Query("select a from Tournament a where a.id = ?1")
    Integer checkIfExist(Integer id);

}
