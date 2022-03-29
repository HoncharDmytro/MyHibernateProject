package com.chapter.three.simple;

import java.util.Objects;

public class Ranking {
    private Person subject;
    private Person observer;
    private Skill skill;
    private Integer ranking;

    public Ranking() { }

    public Person getSubject() {
        return subject;
    }

    public void setSubject(Person subject) {
        this.subject = subject;
    }

    public Person getObserver() {
        return observer;
    }

    public void setObserver(Person observer) {
        this.observer = observer;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "subject=" + subject +
                ", observer=" + observer +
                ", skill=" + skill +
                ", ranking=" + ranking +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranking ranking1 = (Ranking) o;
        return Objects.equals(subject, ranking1.subject) && Objects.equals(observer, ranking1.observer) &&
                Objects.equals(skill, ranking1.skill) && Objects.equals(ranking, ranking1.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, observer, skill, ranking);
    }
}