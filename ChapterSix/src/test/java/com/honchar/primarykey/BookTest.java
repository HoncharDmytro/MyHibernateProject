package com.honchar.primarykey;

import org.hibernate.Session;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class BookTest {
    @Test
    public void bookTest() {
        try (Session session = SessionUtil.getSession()) {
            assertNotNull(session);
        }
    }
}