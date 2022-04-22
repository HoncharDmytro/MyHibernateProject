package org.honchar.util.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity(name = "Thing")
@Data//@ToString + @EqualsAndHashCode + @Getter + @Setter (lombok)
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column
    String name;
}