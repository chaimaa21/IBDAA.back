package ibdaa.africa.AM.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibdaa.africa.AM.models.Groupe;
import ibdaa.africa.AM.repositories.GroupeRepository;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class GroupeService {
    private final GroupeRepository repository;

    @Autowired
    public GroupeService(GroupeRepository repository) {
        this.repository = repository;
    }
    public List<Groupe> getGroups(){
        return repository.findAll();
    }
    public Groupe getGroupById(Long id){
         return repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Group does not exist"));
    }
    public void createGroup(Groupe group){
        repository.save(group);
    }
    public void removeGroup(Long id_groupe){
        boolean exist = repository.existsById(id_groupe);
        if(!exist){
            throw new IllegalStateException("the Group with the id " + id_groupe + " does not exist") ;
        }
        repository.deleteById(id_groupe);
    }
    @Transactional
    public void updateGroup(Groupe gp){
         Groupe group= repository.findById(gp.getId_groupe())
                .orElseThrow(()->new IllegalStateException("Group does not exist"));
         if (gp.getParticipants() !=null){
             group.setParticipants(gp.getParticipants());
         }
         if(gp.getNom_groupe() != null && gp.getNom_groupe().length() > 0){
             group.setNom_groupe(gp.getNom_groupe());
         }
    }
}