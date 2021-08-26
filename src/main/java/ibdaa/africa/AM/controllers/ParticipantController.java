package ibdaa.africa.AM.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import ibdaa.africa.AM.models.Participant;

import ibdaa.africa.AM.services.ParticipantService;

import java.util.List;



@RestController
@RequestMapping(path = "api/v1/participant")

public class ParticipantController {
    private final ParticipantService service ;

    @Autowired
    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Participant> getParticipant(){
        return service.getParticipant();
    }
    @PostMapping
    public void addParticipant(@RequestBody Participant participant){
        service.addParticipant(participant);
    }
    @DeleteMapping(path = "{id}")
    public void removeParticipant(@PathVariable("id") Long id){
        service.removeParticipant(id);
    }
    @PutMapping(path = "{id}")
    public void updateParticipant(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String cin,
            @RequestParam(required = false) String tel,
            @RequestParam(required = false) String adresse,
            @RequestParam(required = false) String entr,
            @RequestParam(required = false) String domaine,
            @RequestParam(required = false) String phase
    ){
        service.updateParticipant(id,nom, prenom,email,cin,tel,adresse,entr,domaine,phase);
    }

}