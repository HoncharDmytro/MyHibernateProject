package com.chapter.three.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Skill {
    @Column
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Skill() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(name, skill.name) && Objects.equals(id, skill.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
