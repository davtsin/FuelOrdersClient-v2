package com.fuelordersclient.entity;

/**
 *
 * @author denis
 */
public class Order {

    private long id;
    private long gasStationId;
    private String orderDate;
    private String gasType;
    private double costPerLiter;
    private double discount;
    private double amountLiters;
    private double totalCost;

    public Order() {
    }

    public Order(GasStation gasStation, String orderDate, String gasType,
        double costPerLiter, double discount, double amountLiters, double totalCost) {

        this.gasStationId = gasStation.getId();
        this.orderDate = orderDate;
        this.gasType = gasType;
        this.costPerLiter = costPerLiter;
        this.discount = discount;
        this.amountLiters = amountLiters;
        this.totalCost = totalCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGasStationId() {
        return gasStationId;
    }

    public void setGasStationId(long gasStationId) {
        this.gasStationId = gasStationId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public double getCostPerLiter() {
        return costPerLiter;
    }

    public void setCostPerLiter(double costPerLiter) {
        this.costPerLiter = costPerLiter;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmountLiters() {
        return amountLiters;
    }

    public void setAmountLiters(double amountLiters) {
        this.amountLiters = amountLiters;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", gasStationId=" + gasStationId
            + ", orderDate=" + orderDate + ", gasType=" + gasType
            + ", costPerLiter=" + costPerLiter + ", discount=" + discount
            + ", amountLiters=" + amountLiters + ", totalCost=" + totalCost + '}';
    }
}
