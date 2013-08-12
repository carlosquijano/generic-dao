package com.sobrejava.dao;

import com.sobrejava.javaee.eventos.model.Evento;
import java.sql.Timestamp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EventoDaoTest {

    String pu = "pu-generic-dao-test";
    EntityManager em;
    EntityManagerFactory emf;

    @Before
    public void before() {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.em = emf.createEntityManager();
    }

    @Test
    public void testSaveEvents() {
        Assert.assertNotNull(em);
        
        Timestamp stamp;
        EntityTransaction trx = null;
        
        try {
            trx = em.getTransaction();
            stamp = new Timestamp(System.currentTimeMillis());

            Evento evento = new Evento();
            evento.setFecha(stamp);
            evento.setMensaje("Este es un mensaje generado en " + stamp);
            evento.setSeveridad(Evento.SEVERIDAD_INFO);

            trx.begin();
            em.persist(evento);
            trx.commit();
        } catch (RuntimeException e) {
            if (trx != null && trx.isActive()) {
                trx.rollback();
            }
        }
    }
    
    @After 
    public void after() {
        em.close();
        emf.close();
    }
}
