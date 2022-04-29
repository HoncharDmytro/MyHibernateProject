package chapterSeven.validator;

import chapterSeven.validated.Coordinate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.honchar.hibernate.util.SessionUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jakarta.validation.ConstraintViolationException;

public class CoordinateTest {
    private void persist(Coordinate entity) {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        }
    }
    @DataProvider(name = "validCoordinates")
    private Object[][] validCoordinates() {
        return new Object[][]{
                {1, 1},
                {-1, 1},
                {1, -1},
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1},
                {0, 0}
        };
    }
    @Test(dataProvider = "validCoordinates")
    public void testValidCoordinate(Integer x, Integer y) {
        Coordinate c = Coordinate.builder().x(x).y(y).build();
        persist(c);
    }
    @Test(expectedExceptions = ConstraintViolationException.class)//!!!!!!!!!!!!!Expected exception test!!!!!!!!
    public void testInvalidCoordinate() {
        testValidCoordinate(-1, -1);
    }
}