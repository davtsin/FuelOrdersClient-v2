package com.fuelordersclient.dao;

import com.fuelordersclient.entity.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author denis
 */
public class CompanyDao {

    private static final String SQL_INSERT_COMPANY
        = "insert into COMPANY (name) values (?)";

    private static final String SQL_SELECT_ALL_COMPANIES
        = "select id, name from COMPANY";

//    private static final String SQL_SELECT_COMPANY_BY_NAME
//        = "select id, name from COMPANY where name = ?";
    
    private final PetrolDBConnection connection;

    public CompanyDao(PetrolDBConnection conn) {
        connection = conn;
    }

    public void addCompany(Company company) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            conn = connection.getPetrolConnection();
            stmt = conn.prepareStatement(SQL_INSERT_COMPANY);
            stmt.setString(1, company.getName());
            stmt.execute();

            System.out.println(company + " was added to COMPANY");

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

    public Set<Company> getCompanies() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Set<Company> companies = new HashSet<>();
        try {

            conn = connection.getPetrolConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT_ALL_COMPANIES);

            Company company = null;
            while (rs.next()) {
                company = new Company();
                company.setId(rs.getLong("id"));
                company.setName(rs.getString("name"));
                companies.add(company);
            }
            return companies;
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

//    public Company getCompanyByName(String name) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            
//            conn = connection.getPetrolConnection();
//            stmt = conn.prepareStatement(SQL_SELECT_COMPANY_BY_NAME);
//            stmt.setString(1, name);
//            rs = stmt.executeQuery();
//
//            Company company = null;
//            if (rs.next()) {
//                company = new Company();
//                company.setId(rs.getLong("id"));
//                company.setName(rs.getString("name"));
//            }
//            return company;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                }
//            }
//
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                }
//            }
//
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//
//        return null;
//    }
}
