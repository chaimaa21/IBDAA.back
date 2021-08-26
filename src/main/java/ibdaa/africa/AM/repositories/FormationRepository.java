package ibdaa.africa.AM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibdaa.africa.AM.models.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {

}