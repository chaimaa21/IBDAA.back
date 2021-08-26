package ibdaa.africa.AM.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Administrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    String nom="MOULAD";
    String prenom="CHAIMAA";
    String email="chaimaamoulad21112000@gmail.com";
}