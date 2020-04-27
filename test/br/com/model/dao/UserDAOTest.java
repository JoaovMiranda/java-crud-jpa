/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.model.bean.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author joaomiranda
 */
public class UserDAOTest {

    public UserDAOTest() {
    }

    @Ignore
    @Test
    public void testAdd() {

        User us;
        UserDAO desc;
        us = new User();
        desc = new UserDAO();

        us.setName("Batata");
        desc.save(us);

        assertTrue(us.getName() != null);

    }

    @Ignore
    @Test
    public void testRead() {

        UserDAO dao;
        dao = new UserDAO();

        for (User u : dao.findAll()) {
            System.out.println("ID: " + u.getId());
        }

    }
    
    @Ignore
    @Test
    public void testDelete() {

        User us;
        UserDAO desc;

        us = new User();
        desc = new UserDAO();
        
        desc.delete(7);

        assertTrue(us.getId() == null);
    }
    
    @Ignore
    @Test
    public void testUpdate() {

        User us;
        UserDAO desc;

        us = new User();
        desc = new UserDAO();

        us.setId(1);
        us.setName("Potatoes");
        desc.update(us);

        // us.getNome() == "Batata"
        assertTrue("Potatoes".equals(us.getName()));

    }
}
