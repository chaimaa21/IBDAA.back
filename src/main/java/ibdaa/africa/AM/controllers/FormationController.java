package ibdaa.africa.AM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ibdaa.africa.AM.models.Formateur;
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

    @GetMapping("/all")
    public List<Formation> getFormation(){
        return service.getFormation();
    }
    @PostMapping("/add")
    public ResponseEntity<Formation> addFormation(@RequestBody  Formation formation){
        Formation newFormation= service.addFormation(formation);
        return new ResponseEntity<>(newFormation, HttpStatus.CREATED);
     }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeFormation(@PathVariable("id") Long id){
    	System.out.println("called");
        service.removeFormation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
  
    @PutMapping("/update")
    public ResponseEntity<Formation> updateFormation(@RequestBody Formation formation) {
        Formation updateFormation = service.updateFormation(formation);
        return new ResponseEntity<>(updateFormation, HttpStatus.OK);
    }

}