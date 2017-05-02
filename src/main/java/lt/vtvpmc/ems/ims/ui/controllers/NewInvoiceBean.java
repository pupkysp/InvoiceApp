package lt.vtvpmc.ems.ims.ui.controllers;

import java.util.List;

import org.primefaces.model.chart.BarChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lt.vtvpmc.ems.ims.entities.Invoice;
import lt.vtvpmc.ems.ims.entities.Item;
import lt.vtvpmc.ems.ims.models.InvoiceModel;
import lt.vtvpmc.ems.ims.models.ItemModel;
import lt.vtvpmc.ems.ims.repositories.InvoiceRepo;

@Controller
@Scope("request")
public class NewInvoiceBean {

	@Autowired
	private InvoiceRepo invoiceRepo;

	@Autowired
	private InvoiceModel invoiceModel;

	@Autowired
	private ItemModel itemModel;

	@Autowired
	private ChartView cw;

	public BarChartModel chart(Invoice invoice) {
		cw = new ChartView();
		cw.setItemList(invoice.getItems());
		cw.init();
		return cw.getBarModel();
	}

	public String save() {
		invoiceRepo.save(invoiceModel.getCurrentInvoice());
		return "main";
	}

	public String create() {
		invoiceModel.setCurrentInvoice(new Invoice());
		return "create-invoices";
	}

	public String addNewItem(Invoice invoice) {
		itemModel.setCurrentItem(new Item());
		invoiceModel.setCurrentInvoice(invoice);
		return "show-item-page";
	}

	public String showInvoiceList() {
		return "show-invoices";
	}

	public String showItemList(Invoice invoice) {
		invoiceModel.setCurrentInvoice(invoice);
		return "show-item-view";
	}

	public String deleteSelectedInvoice(Invoice invoice) {
		invoiceModel.setCurrentInvoice(invoice);
		invoiceRepo.delete(invoiceModel.getCurrentInvoice());
		return "show-invoices";
	}

	public String editInvoice(Invoice invoice) {
		invoiceModel.setCurrentInvoice(invoice);
		return "edit-invoice";
	}

	public InvoiceRepo getInvoiceRepo() {
		return invoiceRepo;
	}

	public void setInvoiceRepo(InvoiceRepo invoiceRepo) {
		this.invoiceRepo = invoiceRepo;
	}

	public InvoiceModel getInvoiceModel() {
		return invoiceModel;
	}

	public void setInvoiceModel(InvoiceModel invoiceModel) {
		this.invoiceModel = invoiceModel;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceRepo.findAll();
	}

	public ChartView getCw() {
		return cw;
	}

	public void setCw(ChartView cw) {
		this.cw = cw;
	}

}
