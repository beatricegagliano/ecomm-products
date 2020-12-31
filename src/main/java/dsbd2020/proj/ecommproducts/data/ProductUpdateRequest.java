package dsbd2020.proj.ecommproducts.data;

import dsbd2020.proj.ecommproducts.products.Products;

import java.io.Serializable;
import java.util.List;

public class ProductUpdateRequest implements Serializable {
    private Integer orderId;
    private Products products;
    private List<Products> lproducts;
    private Double total;
    private String shippingAddress;
    private String billingAddress;
    private Integer userId;
    private String extraArgs;


    public Integer getOrderId() {
        return orderId;
    }

    public ProductUpdateRequest setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Products getProducts() {
        return products;
    }

    public ProductUpdateRequest setProducts(Products products) {
        this.products = products;
        return this;
    }

    public List<Products> getLproducts() {
        return lproducts;
    }

    public ProductUpdateRequest setLproducts(List<Products> lproducts) {
        this.lproducts = lproducts;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public ProductUpdateRequest setTotal(Double total) {
        this.total = total;
        return this;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public ProductUpdateRequest setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public ProductUpdateRequest setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
        return this;

    }

    public Integer getUserId() {
        return userId;
    }

    public ProductUpdateRequest setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getExtraArgs() {
        return extraArgs;
    }

    public ProductUpdateRequest setExtraArgs(String extraArgs) {
        this.extraArgs = extraArgs;
        return this;
    }
}