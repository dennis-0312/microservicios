package academy.digitallab.store.shopping.repository.entity;

import academy.digitallab.store.shopping.model.Product;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Data
@Table(name = "tbl_invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "El stock debe ser mayor a cero")
    private Double quantity;
    private Double price;

    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column
    private Long productId;

    @Transient
    private Double subtotal;

    @Transient
    private Product product;

    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }

    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;
    }
}
