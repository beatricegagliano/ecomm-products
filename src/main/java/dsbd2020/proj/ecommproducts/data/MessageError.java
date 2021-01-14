package dsbd2020.proj.ecommproducts.data;

import java.io.Serializable;

public class MessageError implements Serializable {
    private long timestamp;
    private String sourceIp;
    private String service;
    private String request;
    private String error;

    public long getTimestamp() {
        return timestamp;
    }

    public MessageError setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public MessageError setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
        return this;
    }

    public String getService() {
        return service;
    }

    public MessageError setService(String service) {
        this.service = service;
        return this;
    }

    public String getRequest() {
        return request;
    }

    public MessageError setRequest(String request) {
        this.request = request;
        return this;
    }

    public String getError() {
        return error;
    }

    public MessageError setError(String error) {
        this.error = error;
        return this;
    }
}
