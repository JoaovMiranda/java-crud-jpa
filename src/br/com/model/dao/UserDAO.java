/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.bean.User;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author joaomiranda
 */
public class UserDAO {


    public User save(User user) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            // Insert table
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return user;
    }

    public User update(User user) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            if (user.getId() == null) {
                System.out.println("br.com.model.dao.UserDAO.update()");
                em.persist(user);
            } else {
                // Update table
                em.merge(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return user;
    }

    public User findbyID(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();

        User user = null;

        try {
            // Select table
            user = em.find(User.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
        } finally {
            em.close();
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = null;
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            // Select table
            users = em.createQuery("from User u").getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao encontrar: " + e);
        } finally {
            em.close();
        }
        return users;
    }

    public User delete(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();

        User user = em.find(User.class, id);

        try {
            em.getTransaction().begin();
            // Delete table
            em.remove(user);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return user;
    }

}
