package com.honchar.general;

import com.honchar.model.SimpleObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

public class DuplicateSaveTest {
    @Test
    public void duplicateSaveTest() {
        Long id;
        SimpleObject obj;

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            obj = new SimpleObject();
            obj.setKey("Open Source and Standards");
            obj.setValue(10L);
            session.persist(obj);
            assertNotNull(obj.getId());
            id = obj.getId();
            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            obj.setValue(12L);
            session.persist(obj);//WRONG!!!! CREATE DUPLICATE!!!!
            tx.commit();
        }
        assertNotEquals(id, obj.getId());

        try (Session session = SessionUtil.getSession()) {
            List<SimpleObject> objects = session
                    .createQuery("from SimpleObject", SimpleObject.class)
                    .list();
            assertEquals(objects.size(), 2);
        }
    }
}