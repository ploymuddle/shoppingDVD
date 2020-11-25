/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author PLOYMUDDLE
 */
public class ProductTable {
    public static Vector<Product> findAllProduct(EntityManager em) {
        Vector<Product> dvdList = null;
        try {
            dvdList = (Vector<Product>) em.createNamedQuery("Product.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return dvdList;
    }
    public static Product findProductById(EntityManager em, int id) {
        Product dvd = null;
        try {
            dvd = em.find(Product.class, id);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return dvd;
    }
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateProduct(EntityManager em, Product dvd) {
        try {
            em.getTransaction().begin();
            Product target = em.find(Product.class, dvd.getProductid());
            if (target == null) {
                return 0;
            }
            target.setName(dvd.getName());
            target.setRate(dvd.getRate());
            target.setProductyear(dvd.getProductyear());
            target.setPrice(dvd.getPrice());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
        
    }
    public static int removeProduct(EntityManager em, int id) {
        try {
            em.getTransaction().begin();
            Product target = em.find(Product.class, id);
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
    
    public static int insertProduct(EntityManager em, Product emp) {
        try {
            em.getTransaction().begin();
            Product target = em.find(Product.class, emp.getProductid());
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
}
