package ibdaa.africa.AM.models;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public @Data
@EqualsAndHashCode(callSuper=true)
class Formateur extends Internaute {
	String profil;

    @OneToMany(mappedBy = "formateur",cascade= CascadeType.ALL)
    List<Session> sessions;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_formation", referencedColumnName = "id_formation")
    @JsonManagedReference
    
    private Formation formation;

}