package com.fuelordersclient.dao;

import com.fuelordersclient.entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author denis
 */
public class OrderDao {

    private static final String SQL_INSERT_ORDER
        = "insert into FUEL_ORDER (gas_station_id, order_date, gas_type, cost_per_liter, "
        + "discount, amount_liters, total_cost) values (?, ?, ?, ?, ?, ?, ?)";

    public OrderDao(PetrolDBConnection conn) {
        connection = conn;
    }

    private final PetrolDBConnection connection;

    public void addOrder(Order order) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            conn = connection.getPetrolConnection();
            stmt = conn.prepareStatement(SQL_INSERT_ORDER);
            stmt.setLong(1, order.getGasStationId());
            stmt.setString(2, order.getOrderDate());
            stmt.setString(3, order.getGasType());
            stmt.setDouble(4, order.getCostPerLiter());
            stmt.setDouble(5, order.getDiscount());
            stmt.setDouble(6, order.getAmountLiters());
            stmt.setDouble(7, order.getTotalCost());
            stmt.execute();

            System.out.println(order + " was added to FUEL_ORDER");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
