package ibdaa.africa.AM.models;


import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_groupe;
    
    @OneToMany(mappedBy = "groupe",cascade= CascadeType.ALL)
    List<Participant> participants;
    
    String nom_groupe;
    
    @OneToMany(mappedBy = "groupe",cascade= CascadeType.ALL)
    List<Session> session;
    
}