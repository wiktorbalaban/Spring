package Przyrost3.repositories;

import Przyrost3.entities.Technique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TechniqueRepository extends CrudRepository<Technique, Integer>,
        PagingAndSortingRepository<Technique, Integer> {

}
