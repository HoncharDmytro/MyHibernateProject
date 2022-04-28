package com.honchar.general;

import com.honchar.model.SimpleObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SaveLoadTest {
    //@Test
    public void testSaveLoad() {
        Long id = null;
        SimpleObject obj;

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            obj = new SimpleObject();
            obj.setKey("test");
            obj.setValue(10L);

            session.save(obj);
            assertNotNull(obj.getId());
            id = obj.getId();
            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            SimpleObject o2 = session.load(SimpleObject.class, id);
            assertEquals(o2.getKey(), "test");
            assertNotNull(o2.getValue());
            assertEquals(o2.getValue().longValue(), 10L);
            SimpleObject o3 = session.load(SimpleObject.class, id);
//            assertEquals(o2, o3);
//            assertEquals(obj, o2);
//            assertEquals(obj, o3);
//            assertSame(o2, o3);
//            assertFalse(o2 == obj);
//            assertSame(obj, o3);
//            assertFalse(obj == o3);
        }
    }
}