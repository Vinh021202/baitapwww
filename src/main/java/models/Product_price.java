package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@NamedQueries(
        {
                @NamedQuery(name = "product_price.findAll", query = "select pp from Product_price  procprice"),
        }
)
@Entity
@Table(name = "product_price")


public class Product_price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_date_time")
    private LocalDateTime priceDateTime;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String note;
    private Double price;

    public Product_price() {
    }

    public Product_price(LocalDateTime priceDateTime, Product product, String note, Double price) {
        this.priceDateTime = priceDateTime;
        this.product = product;
        this.note = note;
        this.price = price;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
