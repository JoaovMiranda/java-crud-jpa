/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.bean.Car;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author joaomiranda
 */
public class CarDAOTest {
    
    public CarDAOTest() {
    }

    @Ignore
    @Test
    public void testAdd() {

        Car c;
        CarDAO desc;
        c = new Car();
        desc = new CarDAO();

        c.setModel("Batata");
        desc.save(c);

        assertTrue(c.getModel()!= null);

    }

    @Ignore
    @Test
    public void testRead() {

        CarDAO dao;
        dao = new CarDAO();

        for (Car u : dao.findAll()) {
            System.out.println("ID: " + u.getId());
        }

    }
    
    @Ignore
    @Test
    public void testUpdate() {

        Car c;
        CarDAO desc;

        c = new Car();
        desc = new CarDAO();

        c.setId(1);
        c.setModel("Potatoes");
        desc.update(c);

        // c.getNome() == "Batata"
        assertTrue("Potatoes".equals(c.getModel()));

    }
    
}
