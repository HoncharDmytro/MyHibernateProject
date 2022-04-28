package com.honchar.naturalid;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class IdTestSimple extends IdTestBase {
    @Test
    public void testSimpleNaturalId() {
        Integer id = createSimpleEmployee("Sorhed", 5401).getId();

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            SimpleNaturalIdEmployee employee = session.byId(SimpleNaturalIdEmployee.class).load(id);
            assertNotNull(employee);
            SimpleNaturalIdEmployee badgedEmployee = session.bySimpleNaturalId(SimpleNaturalIdEmployee.class)
                            .load(5401);
            assertEquals(badgedEmployee, employee);
            tx.commit();
        }
    }
}