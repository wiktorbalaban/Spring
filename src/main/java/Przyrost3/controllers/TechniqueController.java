package Przyrost3.controllers;

import Przyrost3.entities.Technique;
import Przyrost3.services.TechniqueService;
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
public class TechniqueController {

    @Autowired
    private TechniqueService service;

    @RequestMapping(value = "/arenas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Technique> list(Model model) {
        return service.listAll();
    }

    @RequestMapping(value = "/arenas/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Technique> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/arenas_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Technique> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/arena", method = RequestMethod.POST)
    public ResponseEntity<Technique> create(@RequestBody @Valid @NotNull Technique obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/arena", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Technique getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/arena/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        service.delete(id);
        return new RedirectView("/api/arenas", true);
    }

    @RequestMapping(value = "/arena", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Technique obj) {
        Technique arenaFromData = service.getById(obj.getId());
        if (Objects.nonNull(arenaFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
