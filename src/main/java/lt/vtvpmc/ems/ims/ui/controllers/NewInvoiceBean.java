package lt.vtvpmc.ems.ims.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import lt.vtvpmc.ems.ims.models.InvoiceModel;
import lt.vtvpmc.ems.ims.repositories.InvoiceRepo;

public class NewInvoiceBean {

	@Autowired
	InvoiceRepo invoiceRepo;

	private InvoiceModel invoiceModel;

	public String save() {
		
		invoiceRepo.save(invoiceModel.getCurrentInvoice());
		return "main";
	}

}
