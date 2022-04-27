package com.honchar.joined;

import jakarta.persistence.Entity;
import java.util.Objects;

@Entity(name="JoinedCBook")
public class ComputerBook extends Book{
    String primaryLanguage;

    public ComputerBook() {
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public String toString() {
        return "ComputerBook{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", primaryLanguage='" + primaryLanguage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComputerBook that = (ComputerBook) o;
        return Objects.equals(primaryLanguage, that.primaryLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), primaryLanguage);
    }
}