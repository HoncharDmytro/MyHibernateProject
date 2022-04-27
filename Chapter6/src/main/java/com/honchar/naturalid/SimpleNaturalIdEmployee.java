package com.honchar.naturalid;

import org.hibernate.annotations.NaturalId;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SimpleNaturalIdEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NaturalId
    Integer badge;
    String name;
    @Column(scale=2,precision=5,nullable=false)
    double royalty;

    public SimpleNaturalIdEmployee() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRoyalty() {
        return royalty;
    }

    public void setRoyalty(double royalty) {
        this.royalty = royalty;
    }

    @Override
    public String toString() {
        return "SimpleNaturalIdEmployee{" +
                "id=" + id +
                ", badge=" + badge +
                ", name='" + name + '\'' +
                ", royalty=" + royalty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleNaturalIdEmployee that = (SimpleNaturalIdEmployee) o;
        return Double.compare(that.royalty, royalty) == 0 && id.equals(that.id) && badge.equals(that.badge)
                && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, badge, name, royalty);
    }
}