package ibdaa.africa.AM.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ibdaa.africa.AM.models.Formateur;

import ibdaa.africa.AM.services.FormateurService;


import java.util.List;




@RestController
@RequestMapping(path = "api/v1/formateur")
@CrossOrigin

public class FormateurController {

    private final FormateurService service ;

    @Autowired
 
    public FormateurController(FormateurService service) {
        this.service = service;
    }
    
    @GetMapping(path="/find/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable("id") Long id,@RequestBody Formateur formateur) {
    	Formateur newFormateur = service.getFormateurById(id);
        return new ResponseEntity<>(newFormateur, HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Formateur> getFormateursList(){
        return service.getFormateursList();
    }
    @PostMapping("/add")
    public ResponseEntity<Formateur> addFormateur(@RequestBody  Formateur formateur){
       Formateur newFormateur= service.addFormateur(formateur);
       return new ResponseEntity<>(newFormateur, HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeFormateur(@PathVariable("id") Long id){
    	System.out.println("called");
        service.removeFormateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
  
    
    @PutMapping( "/update")
    public ResponseEntity<Formateur> updateFormateur(@RequestBody Formateur formateur) {
        Formateur updateFormateur = service.updateFormateur(formateur);
        return new ResponseEntity<>(updateFormateur, HttpStatus.OK);
    }
}