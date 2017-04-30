package lt.vtvpmc.ems.ims.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lt.vtvpmc.ems.ims.entities.Invoice;

@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = -3994013865628704099L;

	@Id
	@SequenceGenerator(name="Item",sequenceName="oracle_seq") 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Item")
	private long id;

	@NotNull
	@NotBlank
	private String title;

	private int amount;
	private double price;

	@JoinColumn(name = "invoice_id")
	@ManyToOne(optional = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Invoice invoice;

	public Item() {
	}

	public double getTotalPrice(){
		return amount * price;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
