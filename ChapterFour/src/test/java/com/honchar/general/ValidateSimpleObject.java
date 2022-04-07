package com.honchar.general;

import org.hibernate.Session;
import org.honchar.hibernate.util.SessionUtil;
import com.honchar.model.SimpleObject;

import static org.testng.Assert.assertEquals;

public class ValidateSimpleObject {
    public static SimpleObject validate(
        Long id,
        Long expectedValue,
        String expectedKey) {
        SimpleObject so = null;

        try (Session session = SessionUtil.getSession()) {
            // will throw an Exception if the id isn't found
            // in the database
            so = session.load(SimpleObject.class, id);
            assertEquals(so.getKey(), expectedKey);
            assertEquals(so.getValue(), expectedValue);
            }
            
        return so;
    }
}