package ibdaa.africa.AM.models;


import lombok.Data;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Internaute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    String email;
    String cin;
    String telephone;
    String adresse;

}