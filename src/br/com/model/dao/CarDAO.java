/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.Car;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joaomiranda
 */
public class CarDAO {

    public Car save(Car car) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            // Insert table
            em.persist(car);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return car;
    }

    public Car update(Car car) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            if (car.getId() == null) {
                System.out.println("NOT PASSED");
                em.persist(car);
            } else {
                // Update table
                em.merge(car);
            }
            em.getTransaction().commit();
        } catch (Exception e) {

            System.out.println("Erro ao salvar: " + e);
            em.getTransaction().rollback();

        } finally {
            em.close();
        }

        return car;
    }

    public Car findbyID(Integer id) {

        Car car = null;
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            // Select table
            car = em.find(Car.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
        } finally {
            em.close();
        }
        return car;
    }

    public List<Car> findAll() {
        List<Car> cars = null;
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            // Select table
            cars = em.createQuery("from Car u").getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
        } finally {
            em.close();
        }
        return cars;
    }
}
