package Przyrost3.services;

import Przyrost3.entities.Arena;
import Przyrost3.repositories.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ArenasServiceImpl implements ArenaService{

    @Autowired
    private ArenaRepository arenaRepository;

    @Override
    public Iterable<Arena> listAllArenas() {
        return arenaRepository.findAll();
    }

}
