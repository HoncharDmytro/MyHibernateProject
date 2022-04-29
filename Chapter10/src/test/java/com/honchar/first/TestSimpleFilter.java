package com.honchar.first;

import com.honchar.model.User;
import org.hibernate.query.Query;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestSimpleFilter extends TestBase {
    @Test
    public void testNoParameterFilter() {
        SessionUtil.doWithSession((session) -> {
            Query<User> query = session.createQuery("from User", User.class);

            session.enableFilter("userEndsWith1");
            List<User> users = query.list();
            assertEquals(users.size(), 1);
            assertEquals(users.get(0).getName(), "user1");
        });
    }
}
