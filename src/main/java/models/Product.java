package models;

import enums.ProductStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries({
       @NamedQuery(name = "Product.getAll", query = " select p from Product p where p.status = 1"),
        @NamedQuery(name = "Product.updateStatus", query = "UPDATE Product SET status = :status WHERE product_id = :product_id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;
    @Column(name = "description", length = 250, nullable = false)
    private String description;
    @Column(name = "manufacturer_name", length = 100, nullable = false)
    private String manufacturer;
    @Column(name = "name", length = 150, nullable = false)
    private String name;
    @Column(name = "status", nullable = false)
    private ProductStatus status;
    @Column(name = "unit", length = 25, nullable = false)
    private String unit;
    @OneToMany(mappedBy = "product")
    private List<Order_detail> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "product")

    private List<Product_image> productImageList = new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<Product_price> productPrices = new ArrayList<>();




}
