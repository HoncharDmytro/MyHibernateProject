package chapterSeven.lifeCycle;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.persistence.*;
import java.util.BitSet;

@Entity
@Data
public class LifeCycleThing {
    static Logger logger = LoggerFactory.getLogger(LifeCycleThing.class);
    static BitSet lifeCycleCalls = new BitSet();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column
    String name;
    @PostLoad
    public void postLoad() {
        log("postLoad", 0);
    }
    @PrePersist
    public void prePersist() {
        log("prePersist", 1);
    }
    @PostPersist
    public void postPersist() {
        log("postPersist", 2);
    }
    @PreUpdate
    public void preUpdate() {
        log("preUpdate", 3);
    }
    @PostUpdate
    public void postUpdate() {
        log("postUpdate", 4);
    }
    @PreRemove
    public void preRemove() {
        log("preRemove", 5);
    }
    @PostRemove
    public void postRemove() {
        log("postRemove", 6);
    }
    private void log(String method, int index) {
        lifeCycleCalls.set(index, true);
        logger.info("{}: {} {}", method,
                this.getClass().getSimpleName(), this);
    }
}