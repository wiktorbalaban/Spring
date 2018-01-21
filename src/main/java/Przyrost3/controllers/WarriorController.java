package Przyrost3.controllers;

import Przyrost3.entities.Technique;
import Przyrost3.entities.Warrior;
import Przyrost3.services.WarriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class WarriorController {

    @Autowired
    private WarriorService service;

    @RequestMapping(value = "/warriors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Warrior> list() {
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
        if (obj.getFightingschool() == null && obj.getTechniques().isEmpty()) {
            service.save(obj);
            return ResponseEntity.ok().body(obj);
        } else {
            return ResponseEntity.badRequest().body(obj);
        }
    }

    @RequestMapping(value = "/warrior", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Warrior getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/warrior/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Warrior getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @RequestMapping(value = "/warrior/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        service.delete(id);
        return new RedirectView("/api/warriors", true);
    }

    @RequestMapping(value = "/warrior", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Warrior obj) {
        Warrior arenaFromData = service.getById(obj.getId());
        boolean isTechniquesCorrect = true;
        for (Technique t : obj.getTechniques()) {
            if (t.getId() == 0) {
                isTechniquesCorrect = false;
                break;
            }
        }
        if (Objects.nonNull(arenaFromData) && (
                (Objects.isNull(obj.getNickname()) || obj.getNickname().getId() != 0)
                        && (Objects.isNull(obj.getFightingschool()) || obj.getFightingschool().getId() != 0)
                        && (Objects.isNull(obj.getWife()) || obj.getWife().getId() != 0)
                        && isTechniquesCorrect)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/warrior/getMostKnownTechnique", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Technique getMostKnownTechnique() {
        return service.getTheMostKnown();
    }

}
