package tesis.Paschini.Benedictus.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final Long id;
    @Column(name="name")
    private String name;
    @Column(name="type_of_product")
    private String typeOfProduct;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
    private Set<Attribute> attributes = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER,
            mappedBy = "products")
    private Set<Movement> movements = new HashSet<>();

    public Product(Long id, String name, String typeOfProduct) {
        this.id = id;
        this.name = name;
        this.typeOfProduct = typeOfProduct;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}
