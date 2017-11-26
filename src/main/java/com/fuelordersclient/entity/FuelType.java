package com.fuelordersclient.entity;

/**
 *
 * @author denis
 */
public enum FuelType {
    AI92("AИ-92"),
    AI95("АИ-95"),
    AI98("АИ-98"),
    DIESEL("ДТ");

    private final String name;

    FuelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
