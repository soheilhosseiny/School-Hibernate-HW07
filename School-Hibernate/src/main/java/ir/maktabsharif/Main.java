package ir.maktabsharif;

import ir.maktabsharif.model.Address;
import ir.maktabsharif.model.Gender;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.thread.MyThread;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println(Thread.currentThread().getName());
//
//        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();
//        {
//        }
//        Thread thread = new Thread(new MyThread(studentRepository));
//        thread.start();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Address address = Address.builder()
                .country("iran")
                .city("tehran")
                .zipCode("1234567891")
                .street("azadi")
                .build();
        Teacher teacher = Teacher.builder().firstName("jack").lastName("smith").gender(Gender.MALE).address(address).build();
        em.persist(teacher);
        em.getTransaction().commit();
        emf.close();

    }
}