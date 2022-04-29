package com.honchar.first;

import com.honchar.model.User;
import org.hibernate.query.Query;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setupTest() {
        SessionUtil.doWithSession((session) -> {
            User user = new User("user1", true);
            user.addGroups("group1", "group2");
            session.save(user);
            user = new User("user2", true);
            user.addGroups("group2", "group3");
            session.save(user);
            user = new User("user3", false);
            user.addGroups("group3", "group4");
            session.save(user);
            user = new User("user4", true);
            user.addGroups("group4", "group5");
            session.save(user);
        });
    }

    @AfterMethod
    public void endTest() {
        SessionUtil.doWithSession((session) -> {
            // need to manually delete all of the Users since
            // HQL delete doesn't cascade over element collections
            Query<User> query = session.createQuery("from User", User.class);
            for (User user : query.list()) {
                session.delete(user);
            }
        });
    }
}
