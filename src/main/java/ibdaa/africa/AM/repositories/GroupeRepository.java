package ibdaa.africa.AM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibdaa.africa.AM.models.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe,Long> {

}