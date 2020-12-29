package dsbd2020.proj.ecommproducts.products;

import dsbd2020.proj.ecommproducts.categories.Categories;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Products{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToMany(cascade = CascadeType.PERSIST)
    private List <Categories> categories;


    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }


    @NotNull
    private String brand;

    @NotNull
    private String model;

    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;




    public Integer getId() {
        return id;
    }

    public Products setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Products setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Products setModel(String model) {
        this.model = model;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Products setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Products setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Products setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }





    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +

                '}';
    }
}
