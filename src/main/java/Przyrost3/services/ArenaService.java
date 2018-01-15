package Przyrost3.services;

import Przyrost3.entities.Arena;

public interface ArenaService {

    Iterable<Arena> listAllArenas();

    Arena getArenaById(Integer id);

    Iterable<Arena> getArenasByName(String name);

    Arena saveArena(Arena arena);

    void deleteArena(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Arena> listAllArenasPaging(Integer pageNr, Integer howManyOnPage);

    long howManyArenas();

}
