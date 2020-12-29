package dsbd2020.proj.ecommproducts.categories;



import dsbd2020.proj.ecommproducts.products.Products;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idC;

    @NotNull
    private String name;

    @ManyToMany(cascade=CascadeType.PERSIST)
    public List<Products> products;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Integer getIdC() {
        return idC;
    }

    public Categories setIdC(Integer idC) {
        this.idC = idC;
        return this;
    }

    public String getName() {
        return name;
    }

    public Categories setName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "idC=" + idC +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}

