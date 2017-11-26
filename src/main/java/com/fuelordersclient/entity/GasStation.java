package com.fuelordersclient.entity;

/**
 *
 * @author denis
 */
public class GasStation {

    private long id;
    private long companyId;
    private String code;
    private String address;

    public GasStation() {
    }

    public GasStation(Company company, String code, String address) {
        companyId = company.getId();
        this.code = code;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "GasStation{" + "id=" + id + ", companyId=" + companyId
            + ", code=" + code + ", address=" + address + '}';
    }
}
