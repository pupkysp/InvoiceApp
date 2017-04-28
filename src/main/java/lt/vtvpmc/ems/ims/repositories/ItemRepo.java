package lt.vtvpmc.ems.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtvpmc.ems.ims.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

}
