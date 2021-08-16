package com.example.Restdemo.services;

import com.example.Restdemo.datalayer.EmployeeDataAccess;
import com.example.Restdemo.datalayer.entities.persistent.DepartementEntity;
import com.example.Restdemo.datalayer.entities.persistent.EmployeeEntity;
import com.example.Restdemo.datalayer.entities.persistent.UsernEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

public class HibernateEmployeeProcessor {

    EmployeeDataAccess employeeDataAccess;
    Connection conn;
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public static void main(String[] args) {
        try {

            HibernateEmployeeProcessor employeeProcessor = new HibernateEmployeeProcessor();
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

            SessionFactory factory = meta.getSessionFactoryBuilder().build();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            //employeeProcessor.createUsern(session);
            employeeProcessor.createDepartement(session);
            //employeeProcessor.createEmployee(session);
            transaction.commit();
            factory.close();
            session.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public HibernateEmployeeProcessor() throws SQLException {



    }

    public UsernEntity createUsern(Session session) {
        UsernEntity usernEntity = new UsernEntity();
        usernEntity.setFamilyname("Aboulfadl");
        usernEntity.setFirstname("Elmontasser");
        java.sql.Date sqlDate = java.sql.Date.valueOf( "2017-11-15");
        usernEntity.setBirthday(sqlDate);
        usernEntity.setPrivateEmail("mont_ch@yahoo.de");
        session.save(usernEntity);
        return usernEntity;

    }
    public DepartementEntity createDepartement(Session session) {

        DepartementEntity departementEntity = new DepartementEntity();
        departementEntity.setName("Einkauf" + new Random().nextLong());
        session.save(departementEntity);
        return  departementEntity;

    }

    public void createEmployee(Session session) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFamilyname("Aboulfadl");
        employeeEntity.setFirstname("ELmontasser");
        employeeEntity.setEmail("mont_ch@yahoo.de");
        employeeEntity.setUsernByUserntId(createUsern(session));
        employeeEntity.setDepartementByDepartementId(createDepartement(session));
        session.save(employeeEntity);
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(null != conn && !conn.isClosed()) {
            conn.close();
        }
    }
}
