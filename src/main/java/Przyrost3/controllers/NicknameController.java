package Przyrost3.controllers;

import Przyrost3.entities.Nickname;
import Przyrost3.services.NicknameService;
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
public class NicknameController {

    @Autowired
    private NicknameService service;

    @RequestMapping(value = "/nicknames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Nickname> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/nicknames/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Nickname> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/nicknames_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Nickname> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/nickname", method = RequestMethod.POST)
    public ResponseEntity<Nickname> create(@RequestBody @Valid @NotNull Nickname obj) {
        service.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/nickname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Nickname getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/nickname/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        service.delete(id);
        return new RedirectView("/api/nicknames", true);
    }

    @RequestMapping(value = "/nickname", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Nickname obj) {
        Nickname arenaFromData = service.getById(obj.getId());
        if (Objects.nonNull(arenaFromData)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/nickname/theLongest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Nickname howMany() {
        return service.getTheLongest();
    }

}
