package Przyrost3.repositories;

import Przyrost3.entities.Nickname;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NicknameRepository extends CrudRepository<Nickname, Integer>,
        PagingAndSortingRepository<Nickname, Integer> {

    Nickname findById(int id);

    @Query("select a from Nickname a where a.id = ?1")
    Integer checkIfExist(Integer id);

}
