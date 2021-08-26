package ibdaa.africa.AM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ibdaa.africa.AM.models.Groupe;
import ibdaa.africa.AM.services.GroupeService;


import java.util.List;
@RestController
@RequestMapping(path="api/v1/group")
public class GroupeController {
    private final GroupeService service;

    @Autowired
    public GroupeController(GroupeService service) {
        this.service = service;
    }
    @GetMapping
    public List<Groupe> getGroups(){
        return service.getGroups();
    }
    @GetMapping(path = "{id_groupe}")
    public Groupe getGroupById(@PathVariable("id_groupe") Long id){
        return service.getGroupById(id);
    }
    @PostMapping
    public void createGroup(Groupe group){
        service.createGroup(group);
    }
    @DeleteMapping(path = "{id_groupe}")
    public void removeGroup(@PathVariable("id_groupe") Long id){
        service.removeGroup(id);
    }
    @PutMapping()
    public void  updateGroup(@RequestBody() Groupe group){
        service.updateGroup(group);
    }
}