package ibdaa.africa.users.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="auth_role")
public class Role {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long role_id;
private String role;

}
