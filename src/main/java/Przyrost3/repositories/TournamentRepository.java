package Przyrost3.repositories;

import Przyrost3.entities.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TournamentRepository extends CrudRepository<Tournament, Integer>,
        PagingAndSortingRepository<Tournament, Integer> {

}
