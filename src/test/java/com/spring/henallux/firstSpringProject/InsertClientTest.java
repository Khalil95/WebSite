package com.spring.henallux.firstSpringProject;

import com.spring.henallux.firstSpringProject.configuration.MainConfiguration;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ClientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;

public class InsertClientTest {

    @Test
    public void test_insert(){

        ClientEntity entity = new ClientEntity();
        entity.setFirst_name("lionel");
        entity.setLast_name("dubois");
        entity.setCity("Marche");
        entity.setEmail("larousse@hotmail.Fr");
        entity.setNumber_address("24");

    }
}
