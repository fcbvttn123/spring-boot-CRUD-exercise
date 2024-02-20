package ca.sheridancollege.vutran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Kid;

public interface KidRepo extends JpaRepository<Kid, Long> {

}
