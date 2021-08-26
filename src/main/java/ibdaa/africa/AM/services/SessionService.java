package ibdaa.africa.AM.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibdaa.africa.AM.models.Formateur;
import ibdaa.africa.AM.models.Formation;
import ibdaa.africa.AM.models.Groupe;
import ibdaa.africa.AM.models.Session;
import ibdaa.africa.AM.repositories.SessionRepository;

import javax.transaction.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Service
public class SessionService {
    private final SessionRepository repository;

    @Autowired
    public SessionService(SessionRepository repository) {this.repository = repository ;}

    public List<Session> getSESSIONS() { return repository.findAll();}
    public void createSceance(Session session) {repository.save(session);}
    public Session getSessionById(Long id_session){
        return repository.findById(id_session)
                .orElseThrow(()->new IllegalStateException("Session does not exist"));
    }
    public void removeSession (Long id_session){
        boolean exist = repository.existsById(id_session);
        if(!exist){
            throw new IllegalStateException("La Sceance n'existe pas");
        }
        repository.deleteById(id_session);
    }
    @Transactional
    public void updateSession(Long id, String nom,Date date,Time h1,Time h2, Formateur formateur, Formation formation, Groupe groupe){
        Session session = repository.findById(id).orElseThrow(()->new IllegalStateException("Sceance n'existe pas"));
        if(nom != null && nom.length()>0 && !Objects.equals(formation.getNom_formation(),nom)){
            session.setNom_session(nom);
        }
        if(date != null && !Objects.equals(session.getDate_session(),date)){
            session.setDate_session(date);
        }
        if(h1 != null  && !Objects.equals(session.getHeure_debut(),h1)){
            session.setHeure_debut(h1);
        }
        if(h2 != null  && !Objects.equals(session.getHeure_fin(),h2)){
            session.setHeure_fin(h2);
        }
        if(formateur != null && !Objects.equals(session.getFormateur(),formateur)){
            session.setFormateur(formateur);
        }
        if(formation != null  && !Objects.equals(session.getFormation(),formation)){
            session.setFormation(formation);
        }
        if(groupe != null && !Objects.equals(session.getGroupe(),groupe)){
            session.setGroupe(groupe);
        }
    }
}