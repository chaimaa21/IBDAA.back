package ibdaa.africa.AM.services;

import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibdaa.africa.AM.models.Participant;

import ibdaa.africa.AM.repositories.ParticipantRepository;

@Service
public class ParticipantService {
	private final ParticipantRepository repository;

    @Autowired
    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public List<Participant> getParticipant(){
        return repository.findAll();
    }
    
    public Participant addParticipant(Participant participant){
    	return repository.save(participant);
    }
    public void removeParticipant(Long id){
        boolean exist = repository.existsById(id);
        if(!exist){
            throw new IllegalStateException("the participant with the id " + id + " does not exist") ;
        }
        repository.deleteById(id);
    }
    public void updateParticipant(Long id, String nom, String prenom,String email,String cin,String tel,String adresse,String entr,String domaine,String phase){
        Participant participant= repository.findById(id)
                .orElseThrow(()->new IllegalStateException("Participant does not exist"));

        if(nom != null && nom.length()>0 && !Objects.equals(participant.getNom(),nom)){
            participant.setNom(nom);
        }
        if(prenom != null && prenom.length()>0 && !Objects.equals(participant.getPrenom(),prenom)){
            participant.setPrenom(prenom);
        }
        if(email!= null && email.length()>0 && !Objects.equals(participant.getEmail(),email)){
            participant.setEmail(email);
        }
        if(cin!= null && cin.length()>0 && !Objects.equals(participant.getCin(),cin)){
            participant.setCin(cin);
        }
        if(tel!= null && tel.length()>0 && !Objects.equals(participant.getTelephone(),tel)){
            participant.setTelephone(tel);
        }
        if(adresse!= null && adresse.length()>0 && !Objects.equals(participant.getAdresse(),adresse)){
            participant.setAdresse(adresse);
        }
        if(entr!= null && entr.length()>0 && !Objects.equals(participant.getEntreprise(),entr)){
            participant.setEntreprise(entr);
        }
        if(domaine!= null && domaine.length()>0 && !Objects.equals(participant.getDomaine(),domaine)){
            participant.setDomaine(domaine);
        }
        if(phase!= null && phase.length()>0 && !Objects.equals(participant.getPhase(),phase)){
            participant.setPhase(phase);
        }
       
    }
}
