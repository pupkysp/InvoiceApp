package lt.vtvpmc.ems.ims.models;

import lt.vtvpmc.ems.ims.entities.Invoice;

public class InvoiceModel {

	private Invoice currentInvoice;

	public Invoice getCurrentInvoice() {
		return currentInvoice;
	}

	public void setCurrentInvoice(Invoice currentInvoice) {
		this.currentInvoice = currentInvoice;
	}

}
