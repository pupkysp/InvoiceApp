package lt.vtvpmc.ems.ims.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lt.vtvpmc.ems.ims.entities.Invoice;

@Component
@Scope("session")
public class InvoiceModel {

	private Invoice currentInvoice;

	public Invoice getCurrentInvoice() {
		return currentInvoice;
	}

	public void setCurrentInvoice(Invoice currentInvoice) {
		this.currentInvoice = currentInvoice;
	}

}
