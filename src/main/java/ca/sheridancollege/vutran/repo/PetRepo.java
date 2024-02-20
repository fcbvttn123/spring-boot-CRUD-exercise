package ca.sheridancollege.vutran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Pet;

public interface PetRepo extends JpaRepository<Pet, Long> {

}
