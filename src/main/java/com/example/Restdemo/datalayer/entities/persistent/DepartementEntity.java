package com.example.Restdemo.datalayer.entities.persistent;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "\"Departement\"", schema = "public", catalog = "HibernateTraining")
public class DepartementEntity {

    private int id;
    private String name;
    private Integer noEmp;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departement_generator")
//    @SequenceGenerator(name="departement_generator", sequenceName = "Departement_id_seq", allocationSize=1)
//    //@Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoEmp() {
        return noEmp;
    }

    public void setNoEmp(Integer noEmp) {
        this.noEmp = noEmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartementEntity that = (DepartementEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(noEmp, that.noEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,noEmp);
    }
}
