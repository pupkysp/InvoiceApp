package lt.vtvpmc.ems.ims.repositories;

import org.springframework.data.repository.CrudRepository;

import lt.vtvpmc.ems.ims.entities.Invoice;

public interface InvoiceRepo extends CrudRepository<Invoice, Long>{

}
