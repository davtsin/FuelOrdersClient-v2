package com.fuelordersclient.dao;

import com.fuelordersclient.entity.Company;
import com.fuelordersclient.entity.GasStation;
import java.util.Set;

/**
 *
 * @author denis
 *
 * CompaniesAndStationsHolder object holds two sets: 1. Set with all companies
 * 2. Set with gas stations belonging to the current selected company. Holder
 * updates each time, when state of combo boxes are changed. It allows you to
 * find information about the required objects without unnecessary reference to
 * the database. Also it may return current selected Company object or
 * GasStation object by it's String name.
 *
 */
public class CompaniesAndStationsHolder {

    // updatable set of all companies
    private Set<Company> companies;
    // updatable set of gas stations belonging to the selected company
    private Set<GasStation> companyGasStations;

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<GasStation> getCompanyGasStations() {
        return companyGasStations;
    }

    public void setCompanyGasStations(Set<GasStation> companyGasStations) {
        this.companyGasStations = companyGasStations;
    }

    // return current selected Company object by it's name
    public Company getCurrentCompany(String name) {
        return companies
            .stream()
            .filter(c -> c.getName().equals(name))
            .findFirst().get();
    }

    // return current selected GasStation object by it's code and address 
    public GasStation getCurrentGasStation(String codeAndAddress) {
        String code = codeAndAddress.split("#")[0];
        String address = codeAndAddress.split("#")[1];
        return companyGasStations
            .stream()
            .filter(g -> g.getCode().equals(code) && g.getAddress().equals(address))
            .findFirst().get();
    }
}
