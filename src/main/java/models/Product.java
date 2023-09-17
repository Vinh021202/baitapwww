package models;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
@NamedQueries({
    //    @NamedQuery(name = "Product.getAll", query = "FROM Product ORDER BY id"),
     //   @NamedQuery(name = "Product.updateStatus", query = "UPDATE Product SET status = :status WHERE product_id = :product_id")
})
public class Product {
    private int produc_id;
    private String name;
    private String description;

}
