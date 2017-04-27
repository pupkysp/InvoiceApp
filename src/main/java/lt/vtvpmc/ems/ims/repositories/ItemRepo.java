package lt.vtvpmc.ems.ims.repositories;

import org.springframework.data.repository.CrudRepository;

import lt.vtvpmc.ems.ims.entities.Item;

public interface ItemRepo extends CrudRepository<Item, Long>{

}
