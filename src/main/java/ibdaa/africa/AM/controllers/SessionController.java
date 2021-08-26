package ibdaa.africa.AM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ibdaa.africa.AM.models.Formateur;
import ibdaa.africa.AM.models.Formation;
import ibdaa.africa.AM.models.Groupe;
import ibdaa.africa.AM.models.Session;
import ibdaa.africa.AM.services.SessionService;

import java.sql.Date;
import java.sql.Time;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/session")
public class SessionController {
    private final SessionService service;

    @Autowired
    public SessionController(SessionService service){this.service = service;}

    @GetMapping
    public List<Session> getSession(){return service.getSESSIONS();}
    @PostMapping
    public void createSceance(@RequestBody Session session){service.createSceance(session);}
    @GetMapping(path = "{id_session}")
    public Session getSceanceById(@PathVariable("id_session") Long id){
        return service.getSessionById(id);
    }
    @DeleteMapping(path="{id_session}")
    public void removeSceance(@PathVariable("id_session") Long id){service.removeSession(id);}
    @PutMapping(path="{id_session}")
    public  void updateSession(@PathVariable("id_session") Long id,
                               @RequestParam(required = false) String nom,
                               @RequestParam(required = false) Date date,
                               @RequestParam(required = false) Time h1,
                               @RequestParam(required = false) Time h2,
                               @RequestParam(required = false) Formateur formateur,
                               @RequestParam(required = false) Formation formation,
                               @RequestParam(required = false) Groupe groupe
    ){
        service.updateSession(id,nom,date,h1,h2,formateur,formation,groupe);
    }
}