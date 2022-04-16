package com.honchar.embedded;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Author {
    String name;
    LocalDate dateOfBirth;
}