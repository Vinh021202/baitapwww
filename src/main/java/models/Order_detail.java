package models;


import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(name = "order_detail.findAll", query = "select od  from Order_detail od"),
        @NamedQuery(name = "order_detail.findById",
                query = "select od  from Order_detail  od where od.order.id=:orderID and od.product.product_id = :procId"),
})
public class Order_detail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity", nullable = false)
    private double quantity;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note")
    private String note;

    public Order_detail() {
    }

    public Order_detail(Order order, Product product, double quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Order_detail{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
