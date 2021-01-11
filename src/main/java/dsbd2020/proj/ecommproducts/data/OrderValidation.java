package dsbd2020.proj.ecommproducts.data;

import java.io.Serializable;
import java.util.Map;


public class OrderValidation implements Serializable {
    private long timestamp;
    private Integer status;
    private Integer orderId;
    private Map<Integer, Integer> extraArgs;

    public long getTimestamp() {
        return timestamp;
    }

    public OrderValidation setTimestamp(long timestamp) {
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
