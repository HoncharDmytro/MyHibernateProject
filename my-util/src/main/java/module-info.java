module myUtil{
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires org.slf4j;
    requires java.naming;
    exports org.honchar.hibernate.util;
    exports org.honchar.jpa.util;
}