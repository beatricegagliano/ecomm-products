package dsbd2020.proj.ecommproducts.data;



import java.io.Serializable;
import java.util.Map;

public class ProductUpdateRequest implements Serializable {
    private Integer orderId;
    private Map<Integer, Integer> products;
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

    public Map<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Integer> products) {
        this.products = products;
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