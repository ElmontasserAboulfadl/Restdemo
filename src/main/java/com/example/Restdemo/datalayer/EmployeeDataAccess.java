package com.example.Restdemo.datalayer;

import com.example.Restdemo.database.DatabaseConnection;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

public class EmployeeDataAccess {

    public EmployeeDataAccess() {
    }

    public static void main(String[] args) {
        try {
            EmployeeDataAccess testDatabaseConnection = new EmployeeDataAccess();
            Connection conn = DatabaseConnection.getConnection();
            testDatabaseConnection.printAllUser(conn);
            testDatabaseConnection.printAllDepartement(conn);
            testDatabaseConnection.printAllEmployee(conn);
            System.out.println("Connection closed" + conn.isClosed());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void printAllUser(Connection conn) throws SQLException {
        String query = "SELECT * from public.\"Usern\" order by familyname, firstname";
        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.execute();
        ResultSet rs = pst.getResultSet();
        while(rs.next()) {
            String firstname = rs.getString("firstname");
            String familyname = rs.getString("familyname");
            String email = rs.getString("private_email");
            Date birthdate = rs.getDate("birthday");
            System.out.printf("firstname %s familyname %s birthdate %s email %s%n" ,firstname, familyname, birthdate.toString(),email );

        }
    }

    public void printAllDepartement(Connection conn) throws SQLException {
        String query = "SELECT * from public.\"Departement\" order by name";
        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.execute();
        ResultSet rs = pst.getResultSet();
        while(rs.next()) {
            Long   id = rs.getLong("id");
            String name = rs.getString("name");
            System.out.printf("id =  %d name %s%n" ,id, name );

        }
    }

    public void printAllEmployee(Connection conn) throws SQLException {
        String query = "SELECT * from public.\"Employee\" order by familyname, firstname";
        Statement st = conn.createStatement();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.execute();
        ResultSet rs = pst.getResultSet();
        while(rs.next()) {
            Long   id = rs.getLong("id");
            Double salary = rs.getDouble("salary");
            String firstname = rs.getString("firstname");
            String familyname = rs.getString("familyname");
            System.out.printf("id =  %d firstname %s  familyname %s salary %s %n" ,id, firstname,familyname,salary.toString() );

        }
    }

    @Entity
    @Table(name = "Departement",schema = "public",  catalog = "HibernateTraining")
    public static class DepartementEntity implements Serializable {

        private Integer id;
        private String name;
        private Integer numberOfEmployees;
        public DepartementEntity(String name , Integer numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
            this.name = name;
        }

        public DepartementEntity() {

        }

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        public Integer getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setId(Integer id) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DepartementEntity that = (DepartementEntity) o;
            return Objects.equals(id, that.id) && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        public Integer getNumberOfEmployees() {
            return numberOfEmployees;
        }

        public void setNumberOfEmployees(Integer numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
        }
    }
}
