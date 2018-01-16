package Przyrost3.controllers;

import Przyrost3.entities.Tournament;
import Przyrost3.entities.Warrior;
import Przyrost3.services.TournamentService;
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
public class TournamentController {

    @Autowired
    private TournamentService service;

    @RequestMapping(value = "/tournaments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tournament> list() {
        return service.listAll();
    }

    @RequestMapping(value = "/tournaments/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tournament> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return service.listAllPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/tournaments_by_name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tournament> getByName(@RequestParam("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.POST)
    public ResponseEntity<Tournament> create(@RequestBody @Valid @NotNull Tournament obj) {
        if (obj.getParticipants().isEmpty() && obj.getArena() == null) {
            service.save(obj);
            return ResponseEntity.ok().body(obj);
        } else {
            return ResponseEntity.badRequest().body(obj);
        }
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tournament getByParamPublicId(@RequestParam("id") Integer publicId) {
        return service.getById(publicId);
    }

    @RequestMapping(value = "/tournament/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        service.delete(id);
        return new RedirectView("/api/tournaments", true);
    }

    @RequestMapping(value = "/tournament", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Tournament obj) {
        Tournament arenaFromData = service.getById(obj.getId());
        boolean isParticipantsCorrect = true;
        for (Warrior w : obj.getParticipants()) {
            if (w.getId() == 0) {
                isParticipantsCorrect = false;
                break;
            }
        }
        if (Objects.nonNull(arenaFromData) && (
                (Objects.isNull(obj.getArena()) || obj.getArena().getId() != 0)
                        && isParticipantsCorrect)) {
            service.save(obj);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/tournaments/getWinner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Warrior getWinner(@RequestParam("id") Integer publicId) {
        return service.getWinner(publicId);
    }

}
