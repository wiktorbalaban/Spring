package Przyrost3.services;


import Przyrost3.entities.Tournament;
import Przyrost3.entities.Warrior;

public interface TournamentService {
    Iterable<Tournament> listAll();

    Tournament getById(Integer id);

    Iterable<Tournament> getByName(String name);

    Tournament save(Tournament arena);

    void delete(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Tournament> listAllPaging(Integer pageNr, Integer howManyOnPage);

    Warrior getWinner(Integer id);

}
