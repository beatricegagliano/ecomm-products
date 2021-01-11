package dsbd2020.proj.ecommproducts.data;



import java.io.Serializable;
import java.util.Map;

public class OrderCompleted implements Serializable {
    private Integer orderId;
    private Map<Integer, Integer> products;
    private Double total;
    private String shippingAddress;
    private String billingAddress;
    private Integer userId;
    private Map<Integer, Integer> extraArgs;


    public Integer getOrderId() {
        return orderId;
    }

    public OrderCompleted setOrderId(Integer orderId) {
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

    public OrderCompleted setTotal(Double total) {
        this.total = total;
        return this;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public OrderCompleted setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public OrderCompleted setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
        return this;

    }

    public Integer getUserId() {
        return userId;
    }

    public OrderCompleted setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Map<Integer, Integer> getExtraArgs() {
        return extraArgs;
    }

    public void setExtraArgs(Map<Integer, Integer> extraArgs) {
        this.extraArgs = extraArgs;
    }
}