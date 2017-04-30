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

	public String create() {
		itemModel.getCurrentItem().setInvoice(invoiceModel.getCurrentInvoice());
		invoiceModel.getCurrentInvoice().addItem(itemModel.getCurrentItem());
		invoiceRepo.save(invoiceModel.getCurrentInvoice());
		return "show-invoices";
	}
	
	public String editItem(Item item) {
		itemModel.setCurrentItem(item);
		return "show-item-page";
	}

	public void deleteSelectedItem(Item item) {
		itemModel.setCurrentItem(item);
		invoiceModel.getCurrentInvoice().removeItem(item);
		itemRepo.delete(itemModel.getCurrentItem());
		itemModel.setCurrentItem(new Item());
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

	public List<Item> getItemList() {
		return invoiceModel.getCurrentInvoice().getItems();
	}

}
