package ibdaa.africa.AM.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ibdaa.africa.AM.exceptions.UserNotFoundException;
import ibdaa.africa.AM.models.Formateur;

import ibdaa.africa.AM.repositories.FormateurRepository;

@Service
public class FormateurService {
	private final FormateurRepository repository;

    @Autowired
    public FormateurService(FormateurRepository repository) {
        this.repository = repository;
    }
    
    public Formateur getFormateurById(Long id) {
        return repository.getFormateurById(id)
                .orElseThrow(() -> new UserNotFoundException("instuctor by id " + id + " was not found"));
    }

    public List<Formateur> getFormateursList(){
        return repository.findAll();
    }
    
    public Formateur addFormateur(Formateur formateur){
    	return repository.save(formateur);
    }
    public void removeFormateur(Long id){
    	System.out.println(id);
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("the intructor with the id " + id + " does not exist") ;
        }
        repository.deleteById(id);
    }
   
    public Formateur updateFormateur(Formateur formateur) {
    	Formateur uform=repository.findById(formateur.getId()).orElseThrow(()-> new UserNotFoundException("client with id "+formateur.getId()+" not found"));
    	System.out.print(uform);
    	if(formateur.getNom()!=null && !formateur.getNom().isEmpty()) uform.setNom(formateur.getNom());
        if(formateur.getPrenom()!=null && !formateur.getPrenom().isEmpty()) uform.setPrenom(formateur.getPrenom());
        if(formateur.getCin()!=null && !formateur.getCin().isEmpty()) uform.setCin(formateur.getCin());
        if(formateur.getTelephone()!=null && !formateur.getTelephone().isEmpty()) uform.setTelephone(formateur.getTelephone());
        if(formateur.getAdresse()!=null && !formateur.getAdresse().isEmpty()) uform.setAdresse(formateur.getAdresse());
        if(formateur.getEmail()!=null && !formateur.getEmail().isEmpty()) uform.setEmail(formateur.getEmail());
        if(formateur.getProfil()!=null && !formateur.getProfil().isEmpty()) uform.setProfil(formateur.getProfil());
        return repository.save(uform);
    }
   
}
