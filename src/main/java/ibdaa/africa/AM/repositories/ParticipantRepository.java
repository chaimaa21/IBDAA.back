package ibdaa.africa.AM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibdaa.africa.AM.models.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {

}
