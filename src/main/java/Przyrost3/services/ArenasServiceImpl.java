package Przyrost3.services;

import Przyrost3.entities.Arena;
import Przyrost3.repositories.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArenasServiceImpl implements ArenaService{

    @Autowired
    private ArenaRepository arenaRepository;

    @Override
    public Iterable<Arena> listAllArenas() {
        return arenaRepository.findAll();
    }

    @Override
    public Arena getArenaById(Integer id){return arenaRepository.findOne(id);}

    @Override
    public Arena saveArena(Arena arena){return arenaRepository.save(arena);}

    @Override
    public void deleteArena(Integer id){arenaRepository.delete(id);}

    @Override
    public Boolean checkIfExist(Integer id){
        if (arenaRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    public Iterable<Arena> listAllProductsPaging(Integer pageNr, Integer howManyOnPage){
        return arenaRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Arena> getArenasByName(String name){
        return arenaRepository.findArenasByName("%"+name+"%");
    }

}
