package com.honchar.broken;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    String content;
    @OneToOne
    Email email;

    public Message() {}

    public Message(String content) {
        setContent(content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Message{id=%d, content='%s', email.subject='%s'}",
                id,
                content,
                (email != null ? email.getSubject() : "null")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) && Objects.equals(content, message.content) &&
                Objects.equals(email, message.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, email);
    }
}