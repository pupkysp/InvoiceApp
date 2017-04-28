package lt.vtvpmc.ems.ims.ui.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lt.vtvpmc.ems.ims.entities.Invoice;
import lt.vtvpmc.ems.ims.models.InvoiceModel;
import lt.vtvpmc.ems.ims.repositories.InvoiceRepo;

@Controller
@Scope("request")
public class NewInvoiceBean {

	@Autowired
	private InvoiceRepo invoiceRepo;

	@Autowired
	private InvoiceModel invoiceModel;

	public String save() {
		invoiceRepo.save(invoiceModel.getCurrentInvoice());
		return "main";
	}

	public String create() {
		invoiceModel.setCurrentInvoice(new Invoice());
		return "create-invoices";
	}

	public String showInvoiceList() {
		
		return "show-invoices";
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

}
