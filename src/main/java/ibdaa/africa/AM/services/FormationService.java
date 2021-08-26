package ibdaa.africa.AM.services;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibdaa.africa.AM.models.Formation;

import ibdaa.africa.AM.repositories.FormationRepository;

@Service
public class FormationService {
    private final FormationRepository repository;

    @Autowired
    public FormationService(FormationRepository repository) {
        this.repository = repository;
    }
    
    
    public List<Formation> getFormation(){
        return repository.findAll();
    }
    
    public void createFormation(Formation formation){
        repository.save(formation);
    }
    public void removeFormation(Long id_formation){
        boolean exist = repository.existsById(id_formation);
        if(!exist){
            throw new IllegalStateException("the Formation with the id " + id_formation + " does not exist") ;
        }
        repository.deleteById(id_formation);
    }
    
    @Transactional
    public void updateFormation(Long formationId,String name,String obj,Integer duration,String desc,String status,Date d1,Date d2){
        Formation formation= repository.findById(formationId)
                .orElseThrow(()->new IllegalStateException("Formation does not exist"));

        if(name != null && name.length()>0 && !Objects.equals(formation.getNom_formation(),name)){
            formation.setNom_formation(name);
        }
        if(obj != null && obj.length()>0 && !Objects.equals(formation.getObjectifs(),obj)){
            formation.setObjectifs(obj);
        }
        if(duration != null && duration>0 && !Objects.equals(formation.getDuree(),duration)){
            formation.setDuree(duration);
        }
        if(desc != null && desc.length()>0 && !Objects.equals(formation.getPrerequis(),desc)){
            formation.setPrerequis(desc);
        }
        if(status != null && status.length()>0 && !Objects.equals(formation.getPhase(),status)){
            formation.setPhase(status);
        }
        if(d1 != null && !Objects.equals(formation.getDate_debut(),d1)){
            formation.setDate_debut(d1);
        }
        if(d2 != null && !Objects.equals(formation.getDate_fin(),d2)){
            formation.setDate_fin(d2);
        }

    }

}