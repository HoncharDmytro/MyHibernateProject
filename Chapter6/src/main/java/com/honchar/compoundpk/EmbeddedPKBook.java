package com.honchar.compoundpk;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
public class EmbeddedPKBook {
    @EmbeddedId
    EmbeddedISBN id;
    @Column
    String name;

    static class EmbeddedISBN implements Serializable {
        @Column(name = "group_number")
        int group;
        int publisher;
        int title;
        int checkDigit;

        public EmbeddedISBN() {}

        public int getGroup() {
            return group;
        }

        public void setGroup(int group) {
            this.group = group;
        }

        public int getPublisher() {
            return publisher;
        }

        public void setPublisher(int publisher) {
            this.publisher = publisher;
        }

        public int getTitle() {
            return title;
        }

        public void setTitle(int title) {
            this.title = title;
        }

        public int getCheckDigit() {
            return checkDigit;
        }

        public void setCheckDigit(int checkDigit) {
            this.checkDigit = checkDigit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ISBN)) return false;
            ISBN isbn = (ISBN) o;
            if (checkDigit != isbn.checkDigit) return false;
            if (group != isbn.group) return false;
            if (publisher != isbn.publisher) return false;
            return title == isbn.title;
        }

        @Override
        public int hashCode() {
            int result = group;
            result = 31 * result + publisher;
            result = 31 * result + title;
            result = 31 * result + checkDigit;
            return result;
        }
    }
}