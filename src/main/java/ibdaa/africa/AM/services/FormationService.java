package ibdaa.africa.AM.services;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibdaa.africa.AM.exceptions.UserNotFoundException;
import ibdaa.africa.AM.models.Formateur;
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
    
    public Formation addFormation(Formation formation){
        return repository.save(formation);
    }
    public void removeFormation(Long id_formation){
        boolean exist = repository.existsById(id_formation);
        if(!exist){
            throw new IllegalStateException("the Formation with the id " + id_formation + " does not exist") ;
        }
        repository.deleteById(id_formation);
    }
    
    @Transactional
    public Formation updateFormation(Formation formation){
    	Formation uform=repository.findById(formation.getId_formation()).orElseThrow(()-> new UserNotFoundException("client with id "+formation.getId_formation()+" not found"));
    	System.out.print(uform);
    	if(formation.getNom_formation()!=null && !formation.getNom_formation().isEmpty()) uform.setNom_formation(formation.getNom_formation());
    	if(formation.getObjectifs()!=null && !formation.getObjectifs().isEmpty()) uform.setObjectifs(formation.getObjectifs());
    	if(formation.getDuree()!=null && !(formation.getDuree()>0)) uform.setDuree(formation.getDuree());
    	if(formation.getPrerequis()!=null && !formation.getPrerequis().isEmpty()) uform.setPrerequis(formation.getPrerequis());
    	if(formation.getPhase()!=null && !formation.getPhase().isEmpty()) uform.setPhase(formation.getPhase());
    	if(formation.getDate_debut()!=null ) uform.setDate_debut(formation.getDate_debut());
    	if(formation.getDate_fin()!=null ) uform.setDate_fin(formation.getDate_fin());
    	return repository.save(uform);
    }
    
}