package com.backbase.assignment.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "address",
        "distance",
        "type"
})
public class INGAtmLocation {

    @JsonProperty("address")
    private Address address;
    @JsonProperty("distance")
    private Integer distance;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The address
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return The distance
     */
    @JsonProperty("distance")
    public Integer getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    @JsonProperty("distance")
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "INGAtmLocation{" +
                "address=" + address +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        INGAtmLocation that = (INGAtmLocation) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(type, that.type) &&
                Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, distance, type, additionalProperties);
    }
}