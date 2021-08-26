package ibdaa.africa.AM.models;


import lombok.Data;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;


@Data
@Entity

public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_session;
    String nom_session;
    Date date_session;
    Time heure_debut;
    Time heure_fin;

    @JoinColumn(name="formateur")
    @ManyToOne
    Formateur formateur;

    @ManyToOne
    @JoinColumn(name="id_formation")
    Formation formation;

    @ManyToOne
    @JoinColumn(name="id_groupe")
    Groupe groupe;
    
    
    
}