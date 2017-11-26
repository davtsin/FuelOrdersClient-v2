package com.fuelordersclient.dao;

import com.fuelordersclient.entity.GasStation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author denis
 */
public class GasStationDao {

    private static final String SQL_INSERT_GAS_STATION
        = "insert into GAS_STATION (company_id, code, address) values (?, ?, ?)";

    private static final String SQL_SELECT_GAS_STATIONS_BY_COMPANY_ID
        = "select id, company_id, code, address from GAS_STATION where company_id = ?";

    private final PetrolDBConnection connection;

    public GasStationDao(PetrolDBConnection conn) {
        connection = conn;
    }

    public void addGasStation(GasStation gasStation) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            conn = connection.getPetrolConnection();
            stmt = conn.prepareStatement(SQL_INSERT_GAS_STATION);
            stmt.setLong(1, gasStation.getCompanyId());
            stmt.setString(2, gasStation.getCode());
            stmt.setString(3, gasStation.getAddress());
            stmt.execute();

            System.out.println(gasStation + " was added to GAS_STATION");

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

    public Set<GasStation> getGasStationsByCompanyId(long companyId) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Set<GasStation> gasStations = new HashSet<>();
        try {

            conn = connection.getPetrolConnection();
            stmt = conn.prepareStatement(SQL_SELECT_GAS_STATIONS_BY_COMPANY_ID);
            stmt.setLong(1, companyId);
            rs = stmt.executeQuery();

            GasStation gasStation = null;
            while (rs.next()) {
                gasStation = new GasStation();
                gasStation.setId(rs.getLong("id"));
                gasStation.setCompanyId(rs.getLong("company_id"));
                gasStation.setCode(rs.getString("code"));
                gasStation.setAddress(rs.getString("address"));
                gasStations.add(gasStation);
            }
            return gasStations;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
