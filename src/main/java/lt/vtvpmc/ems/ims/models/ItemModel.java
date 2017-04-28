package lt.vtvpmc.ems.ims.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lt.vtvpmc.ems.ims.entities.Item;

@Component
@Scope("session")
public class ItemModel {

	private Item currentItem;

	public Item getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(Item currentItem) {
		this.currentItem = currentItem;
	}
}
