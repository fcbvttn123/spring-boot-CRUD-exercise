package ca.sheridancollege.vutran.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.vutran.beans.Kid;
import ca.sheridancollege.vutran.beans.Pet;
import ca.sheridancollege.vutran.beans.PetType;
import ca.sheridancollege.vutran.repo.KidRepo;
import ca.sheridancollege.vutran.repo.PetRepo;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private KidRepo kr;
	private PetRepo pr;

	@Override
	public void run(String... args) throws Exception {
		
		Pet p1 = Pet.builder()
				.name("Coco")
				.isFurry(true)
				.petType(PetType.DOG)
				.build();
		pr.save(p1);
		Pet p2 = Pet.builder()
				.name("Hazard")
				.isFurry(false)
				.petType(PetType.FISH)
				.build();
		pr.save(p2);	
		Pet p3 = Pet.builder()
				.name("Ronaldo")
				.isFurry(true)
				.petType(PetType.CAT)
				.build();
		pr.save(p3);
		Pet p4 = Pet.builder()
				.name("Kaka")
				.isFurry(true)
				.petType(PetType.BIRD)
				.build();
		pr.save(p4);
		
		
		
		Kid k1 = Kid.builder()
				.name("David")
				.age(5)
				.pet(p2)
				.build();
		kr.save(k1);
		Kid k2 = Kid.builder()
				.name("Linda")
				.age(10)
				.pet(p3)
				.build();
		kr.save(k2);
		Kid k3 = Kid.builder()
				.name("Peter")
				.age(7)
				.pet(p1)
				.build();
		kr.save(k3);

	}

}
