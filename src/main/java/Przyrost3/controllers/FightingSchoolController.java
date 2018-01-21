package Przyrost3.controllers;

import Przyrost3.entities.FightingSchool;
import Przyrost3.services.FightingSchoolService;
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
public class FightingSchoolController {

    @Autowired
    private FightingSchoolService service;

    @RequestMapping(value = "/fightingSchools", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FightingSchool> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/fightingSchools/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FightingSchool> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/fightingSchools_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FightingSchool> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/fightingSchool", method = RequestMethod.POST)
    public ResponseEntity<FightingSchool> create(@RequestBody @Valid @NotNull FightingSchool obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/fightingSchool", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FightingSchool getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/fightingSchool/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FightingSchool getByPublicId(@PathVariable("id") Integer publicId){ return service.getById(publicId); }

    @RequestMapping(value = "/fightingSchool/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        service.delete(id);
        return new RedirectView("/api/fightingSchools", true);
    }

    @RequestMapping(value = "/fightingSchool", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull FightingSchool obj) {
        FightingSchool arenaFromData = service.getById(obj.getId());
        if (Objects.nonNull(arenaFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/fightingSchool/best", method = RequestMethod.GET)
    public FightingSchool getBest() {
        return service.getBest();
    }

}
