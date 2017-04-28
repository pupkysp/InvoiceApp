package lt.vtvpmc.ems.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtvpmc.ems.ims.entities.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long>{

}
