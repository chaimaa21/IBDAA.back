package ibdaa.africa.AM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ibdaa.africa.AM.models.Formation;
import ibdaa.africa.AM.services.FormationService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/formation")
public class FormationController {
    private final FormationService service ;

    @Autowired
    public FormationController(FormationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Formation> getFormation(){
        return service.getFormation();
    }
    @PostMapping
    public void createFormation(@RequestBody Formation formation){
        service.createFormation(formation);
    }
    @DeleteMapping(path = "{id_formation}")
    public void removeFormation(@PathVariable("id_formation") Long id){
        service.removeFormation(id);
    }
    @PutMapping(path = "{id_formation}")
    public void updateFormation(
            @PathVariable("id_formation") Long formationId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String obj,
            @RequestParam(required = false) Integer duration,
            @RequestParam(required = false) String desc,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Date d1,
            @RequestParam(required = false) Date d2
    ){
        service.updateFormation(formationId,name,obj,duration,desc,status,d1,d2);
    }

}