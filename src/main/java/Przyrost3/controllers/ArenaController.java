package Przyrost3.controllers;

import Przyrost3.entities.Arena;
import Przyrost3.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ArenaController {

    @Autowired
    private ArenaService arenaService;

    @RequestMapping(value = "/list_all_arenas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Arena> list(Model model) {
        return arenaService.listAllArenas();
    }

    @RequestMapping(value = "/list_arenas_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Arena> getByName(@RequestParam("name") String name) {
        return arenaService.getArenasByName(name);
    }

    @RequestMapping(value = "/arena", method = RequestMethod.POST)
    public ResponseEntity<Arena> create(@RequestBody @Valid @NotNull Arena arena) {
        arenaService.saveArena(arena);
        return ResponseEntity.ok().body(arena);
    }

    @RequestMapping(value = "/arena", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Arena getByParamPublicId(@RequestParam("id") Integer publicId) {
        return arenaService.getArenaById(publicId);
    }

    @RequestMapping(value = "/arena/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        arenaService.deleteArena(id);
        return new RedirectView("/api/arena", true);
    }

    @RequestMapping(value = "/arena", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Arena arena) {
        if(!arenaService.checkIfExist(arena.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            arenaService.saveArena(arena);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

}