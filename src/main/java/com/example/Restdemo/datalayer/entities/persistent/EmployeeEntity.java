package com.example.Restdemo.datalayer.entities.persistent;

import com.example.Restdemo.datalayer.EmployeeDataAccess;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "\"Employee\"", schema = "public", catalog = "HibernateTraining")
public class EmployeeEntity implements Serializable {
    private Integer id;
    private String email;
    private Date contractDate;
    private Date startDate;
    private Date endDate;
    private String phone;
    private String familyname;
    private String firstname;
    private AddressEntity addressByAddressId;
    private DepartementEntity departementByDepartementId;
    private UsernEntity usernByUserntId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "departement_id", nullable = false)
//    public Integer getDepartementId() {
//        return departementId;
//    }
//
//    public void setDepartementId(Integer departementId) {
//        this.departementId = departementId;
//    }

    @Basic
    @Column(name = "email", nullable = false, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "contract_date", nullable = true)
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "familyname", nullable = false, length = 50)
    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(contractDate, that.contractDate) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(phone, that.phone) && Objects.equals(familyname, that.familyname) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, contractDate, startDate, endDate, phone, familyname, firstname);
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public AddressEntity getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(AddressEntity addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "usern_id", referencedColumnName = "id")
    public UsernEntity getUsernByUserntId() {
        return usernByUserntId;
    }

    public void setUsernByUserntId(UsernEntity usernByUserntId) {
        this.usernByUserntId = usernByUserntId;
    }

    @ManyToOne
    @JoinColumn(name = "departement_id", referencedColumnName = "id")
    public DepartementEntity getDepartementByDepartementId() {
        return departementByDepartementId;
    }

    public void setDepartementByDepartementId(DepartementEntity departementByDepartementId) {
        this.departementByDepartementId = departementByDepartementId;
    }
}
