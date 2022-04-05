package com.honchar.general;

import com.honchar.model.SimpleObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

public class SaveOrUpdateTest {
    @Test
    public void testSaveOrUpdateEntity() {
        Long id;
        SimpleObject obj;

        try (Session session= SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session
                    .createQuery("delete from SimpleObject")
                    .executeUpdate();
            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            obj = new SimpleObject();
            obj.setKey("Open Source and Standards");
            obj.setValue(14L);
            session.persist(obj);
            assertNotNull(obj.getId());
            id = obj.getId();
            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            obj.setValue(12L);
            session.saveOrUpdate(obj);
            tx.commit();
        }
        assertEquals(id, obj.getId());

        try (Session session = SessionUtil.getSession()) {
            List<SimpleObject> objects=session
                    .createQuery("from SimpleObject", SimpleObject.class)
                    .list();
            assertEquals(objects.size(), 1);
        }
    }
}