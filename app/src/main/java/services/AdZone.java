
package services;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdZone {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public AdZone withSuccess(Integer success) {
        this.success = success;
        return this;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

    public AdZone withPayloads(List<Payload> payloads) {
        this.payloads = payloads;
        return this;
    }

    public Payload findAdZoneByName(String name) {

        for (Payload payload : this.getPayloads()) {
            if (payload.getName().equals(name)) {
                return payload;
            }
        }
        return null;
    }

}
