package ibdaa.africa.AM.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibdaa.africa.AM.models.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Long> {
	void deleteById(Long id);

    Optional<Formateur> getFormateurById(Long id);
}
