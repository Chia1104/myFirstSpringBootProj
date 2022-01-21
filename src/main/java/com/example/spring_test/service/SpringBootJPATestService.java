package com.example.spring_test.service;

import com.example.spring_test.model.entity.SpringBootJPATest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;

public class SpringBootJPATestService {
    EntityManager entityManager;

    public SpringBootJPATestService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public long saveUser(SpringBootJPATest sbjt){
        entityManager.persist(sbjt);
        return sbjt.getC_ID();
    }

    @Test
    public void whenNewUserIsPersisted_thenEntityHasNoId() {
        SpringBootJPATest sbjt = new SpringBootJPATest();
        sbjt.setC_Email("test@test.com");
        sbjt.setC_Name("test");
        sbjt.setC_Password(UUID.randomUUID().toString());

        entityManager.getTransaction().begin();
        long index = saveUser(sbjt);
        entityManager.getTransaction().commit();

        Assert.assertEquals(2L, index);
    }
}
