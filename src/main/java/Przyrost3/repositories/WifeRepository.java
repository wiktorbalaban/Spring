package Przyrost3.repositories;

import Przyrost3.entities.Wife;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WifeRepository extends CrudRepository<Wife, Integer>,
        PagingAndSortingRepository<Wife, Integer> {

}
