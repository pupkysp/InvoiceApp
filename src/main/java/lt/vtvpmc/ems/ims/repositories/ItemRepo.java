package lt.vtvpmc.ems.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import lt.vtvpmc.ems.ims.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

	@Transactional
	Long deleteById(Long id);

}
