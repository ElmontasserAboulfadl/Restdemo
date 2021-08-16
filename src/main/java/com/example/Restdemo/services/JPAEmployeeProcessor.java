package com.example.Restdemo.services;


import com.example.Restdemo.datalayer.entities.test.DepartementEntity;
import com.example.Restdemo.datalayer.entities.test.UsernEntity;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Random;

public class JPAEmployeeProcessor {




    public static void main(String[] args) {
        try {

            JPAEmployeeProcessor jPAEmployeeProcessor = new JPAEmployeeProcessor();
            EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory( "com.example.Restdemo.datalayer.entities.test");

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            //employeeProcessor.createUsern(session);
            //employeeProcessor.createDepartement(session);
            jPAEmployeeProcessor.createDepartement(entityManager);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public JPAEmployeeProcessor() throws SQLException {



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
    public DepartementEntity createDepartement(EntityManager entityManager) {
        DepartementEntity departementEntity = new DepartementEntity();
        departementEntity.setName("Einkauf" + new Random(10));
        entityManager.persist(departementEntity);
        return  departementEntity;

    }
//
//    public void createEmployee(Session session) {
//        EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeEntity.setFamilyname("Aboulfadl");
//        employeeEntity.setFirstname("ELmontasser");
//        employeeEntity.setEmail("mont_ch@yahoo.de");
//        employeeEntity.setUsernByUserntId(createUsern(session));
//        employeeEntity.setDepartementByDepartementId(createDepartement(session));
//        session.save(employeeEntity);
//    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
