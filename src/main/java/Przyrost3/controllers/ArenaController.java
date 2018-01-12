package Przyrost3.controllers;

import Przyrost3.entities.Arena;
import Przyrost3.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ArenaController {

    @Autowired
    private ArenaService arenaService;

    @RequestMapping(value = "/listallarenas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Arena> list(Model model) {
        return arenaService.listAllArenas();
    }

    @RequestMapping(value = "/listarenasbyname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Arena> getByName(@RequestParam("name") String name) {
        return arenaService.getArenasByName(name);
    }

}
