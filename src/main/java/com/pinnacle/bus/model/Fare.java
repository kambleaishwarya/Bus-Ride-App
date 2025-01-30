package com.pinnacle.bus.model;

public class Fare {

    private String id;
    private String routeId;
    private String fromLocationId;
    private String toLocationId;
    private float price;
    private String createdByUserId;

    public Fare() {
    }

    public Fare(String id, String routeId, String fromLocationId, String toLocationId, float price, String createdByUserId) {
        this.id = id;
        this.routeId = routeId;
        this.fromLocationId = fromLocationId;
        this.toLocationId = toLocationId;
        this.price = price;
        this.createdByUserId = createdByUserId;
    }

    public String getId() {
        return id;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getFromLocationId() {
        return fromLocationId;
    }

    public String getToLocationId() {
        return toLocationId;
    }

    public float getPrice() {
        return price;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setFromLocationId(String fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    public void setToLocationId(String toLocationId) {
        this.toLocationId = toLocationId;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "id='" + id + '\'' +
                ", routeId='" + routeId + '\'' +
                ", fromLocationId='" + fromLocationId + '\'' +
                ", toLocationId='" + toLocationId + '\'' +
                ", price=" + price +
                ", createdByUserId='" + createdByUserId + '\'' +
                '}';
    }
}