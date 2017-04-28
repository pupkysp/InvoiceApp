package lt.vtvpmc.ems.ims.ui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lt.vtvpmc.ems.ims.entities.Item;
import lt.vtvpmc.ems.ims.models.InvoiceModel;
import lt.vtvpmc.ems.ims.models.ItemModel;
import lt.vtvpmc.ems.ims.repositories.InvoiceRepo;
import lt.vtvpmc.ems.ims.repositories.ItemRepo;

@Controller
@Scope("request")
public class NewItemBean {

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private ItemModel itemModel;
	
	@Autowired
	private InvoiceRepo invoiceRepo;
	
	@Autowired
	private InvoiceModel invoiceModel;

	public String save(){
		itemRepo.save(itemModel.getCurrentItem());
		return "";
	}
	public String create(){
		itemModel.setCurrentItem(new Item());
		return "show-item-page";
	}
	public ItemRepo getItemRepo() {
		return itemRepo;
	}

	public void setItemRepo(ItemRepo itemRepo) {
		this.itemRepo = itemRepo;
	}

	public ItemModel getItemModel() {
		return itemModel;
	}

	public void setItemModel(ItemModel itemModel) {
		this.itemModel = itemModel;
	}
	
	public List<Item> getItemList(){
		return itemRepo.findAll();
	}

}
