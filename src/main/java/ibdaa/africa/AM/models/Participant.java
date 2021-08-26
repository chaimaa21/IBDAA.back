package ibdaa.africa.AM.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;


@Entity


public @Data
@EqualsAndHashCode(callSuper=true)
class Participant extends Internaute{
	String entreprise;
	String domaine;
    String phase;

    @ManyToMany
    List<Formation> formations;
    
    
    @JoinColumn(name ="groupe")
    @ManyToOne
    Groupe groupe;
    
}

