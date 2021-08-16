package com.example.Restdemo.datalayer.entities.persistent;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "usern", schema = "public", catalog = "HibernateTraining")
public class UsernEntity implements Serializable {
    private Integer id;
    private String familyname;
    private String firstname;
    private Date birthday;
    private String privateEmail;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "firstname", nullable = false, length = 30)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "private_email", nullable = true, length = 100)
    public String getPrivateEmail() {
        return privateEmail;
    }

    public void setPrivateEmail(String privateEmail) {
        this.privateEmail = privateEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsernEntity that = (UsernEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(familyname, that.familyname) && Objects.equals(firstname, that.firstname) && Objects.equals(birthday, that.birthday) && Objects.equals(privateEmail, that.privateEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyname, firstname, birthday, privateEmail);
    }
}
