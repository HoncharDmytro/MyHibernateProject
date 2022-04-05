package com.honchar.broken;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    String subject;
    @OneToOne//(mappedBy = "email")
    Message message;

    public Email() {}

    public Email(String subject) {
        setSubject(subject);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {

        return String.format(
                "Email{id=%s, subject=`%s`, message.content=%s}",
                id,
                subject,
                (message != null ? message.getContent() : "null")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(subject, email.subject) &&
                Objects.equals(message, email.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, message);
    }
}