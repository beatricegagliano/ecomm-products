package dsbd2020.proj.ecommproducts.data;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Map;


public class OrderValidation implements Serializable {
    private Timestamp timestamp;
    private Integer status;
    private Integer orderId;
    private Map<Integer, Integer> extraArgs;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public OrderValidation setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public OrderValidation setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderValidation setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Map<Integer, Integer> getExtraArgs() {
        return extraArgs;
    }

    public OrderValidation setExtraArgs(Map<Integer, Integer> extraArgs) {
        this.extraArgs = extraArgs;
        return this;
    }
}
