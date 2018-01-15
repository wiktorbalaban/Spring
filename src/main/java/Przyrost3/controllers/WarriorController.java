package Przyrost3.controllers;

import Przyrost3.entities.Warrior;
import Przyrost3.services.WarriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WarriorController {

    @Autowired
    private WarriorService service;

    @RequestMapping(value = "/warriors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Warrior> list(Model model) {
        return service.listAll();
    }

    @RequestMapping(value = "/warriors/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Warrior> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/warriors_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Warrior> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/warrior", method = RequestMethod.POST)
    public ResponseEntity<Warrior> create(@RequestBody @Valid @NotNull Warrior obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/warrior", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Warrior getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/warrior/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        service.delete(id);
        return new RedirectView("/api/warriors", true);
    }

    @RequestMapping(value = "/warrior", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Warrior obj) {
        Warrior arenaFromData = service.getById(obj.getId());
        if (Objects.nonNull(arenaFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
