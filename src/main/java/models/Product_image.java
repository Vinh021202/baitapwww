package models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_imgae")
@NamedQueries(
        {
                @NamedQuery(name = "product_image.findAll", query = "select procImage from Product_image procImage"),
        }
)
public class Product_image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;
    private String alternative;
    private String path;
    @Id
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    public Product_image() {
    }

    public Product_image(Long imageId, String alternative, String path, Product product) {
        this.imageId = imageId;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public Long getImageId() {
        return imageId;
    }

    public String getAlternative() {
        return alternative;
    }

    public String getPath() {
        return path;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Product_image{" +
                "imageId=" + imageId +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                ", product=" + product +
                '}';
    }
}
