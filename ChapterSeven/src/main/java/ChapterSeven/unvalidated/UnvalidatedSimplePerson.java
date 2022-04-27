package chapterSeven.unvalidated;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UnvalidatedSimplePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String fname;
    @Column
    String lname;
    @Column
    Integer age;
}