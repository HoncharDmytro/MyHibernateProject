package com.chapterone.hibernate;

import com.chapterone.pojo.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class PersistenceTest {
    private SessionFactory factory = null;
    @BeforeClass
    public void setup() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }
    public Message saveMessage(String text) {
        Message message = new Message(text);
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(message);
            tx.commit();
        }
        return message;
    }
    @Test
    public void readMessage() {
        Message savedMessage = saveMessage("Hello, World");
        List<Message> list;
        try (Session session = factory.openSession()) {
            list = session
                    .createQuery("from Message", Message.class)//its ok
                    .list();
        }
        assertEquals(list.size(), 1);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(list);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for (var m : list) {
            System.out.println(m);
        }
        assertEquals(list.get(0), savedMessage);
    }
}