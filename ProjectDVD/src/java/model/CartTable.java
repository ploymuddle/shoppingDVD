/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author PLOYMUDDLE
 */
public class CartTable {
    public static Vector<Cart> findAllCart(EntityManager em) {
        Vector<Cart> dvdList = null;
        try {
            dvdList = (Vector<Cart>) em.createNamedQuery("Cart.findAll").getResultList();
            //em.close();

        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return dvdList;
    }

    public static Cart findCartById(EntityManager em, int id) {
        Cart dvd = null;
        try {
            dvd = em.find(Cart.class, id);
            //em.close();

        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return dvd;
    }

    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateCart(EntityManager em, Cart dvd) {
        try {
            em.getTransaction().begin();
            Cart target = em.find(Cart.class, dvd.getId());
            if (target == null) {
                return 0;
            }
            target.setQuantity(dvd.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;

    }

    public static int removeCart(EntityManager em, int id) {
        try {
            em.getTransaction().begin();
            Cart target = em.find(Cart.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }

    public static int insertCart(EntityManager em, Cart emp) {
        try {
            em.getTransaction().begin();
            Cart target = em.find(Cart.class, emp.getId());
            if (target != null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }
    
    public static int addToCart(EntityManager em, Cart dvd) {
        try {
            em.getTransaction().begin();
            Cart target = em.find(Cart.class, dvd.getId());
            if (target == null) {
                return 0;
            }
            target.setQuantity(target.getQuantity() + dvd.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);

        }
        return 1;
    }
}
