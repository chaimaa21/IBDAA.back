package ibdaa.africa.AM.models;


import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Date;

import java.util.List;

@Data
@Entity

public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_formation;
    String nom_formation;
    Integer duree;
    String objectifs;
    String prerequis;
    String phase;
    Date date_debut;
    Date date_fin;

    @OneToMany(mappedBy ="formation",cascade= CascadeType.ALL )
    List<Session> sessions;

    @ManyToMany
    List<Participant> participants;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_formateur", referencedColumnName = "id")
    @JsonBackReference
   
    private Formateur formateur;
}