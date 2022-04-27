package com.chapter.three.application;

import com.chapter.three.hibernate.Person;

import java.util.Map;

public interface RankingService {
    int getRankingFor(String subject, String skill);

    void addRanking(String subject, String observer, String skill, int ranking);

    //end::preamble[]
    void updateRanking(String subject, String observer, String skill, int ranking);

    void removeRanking(String subject, String observer, String skill);

    Map<String, Integer> findRankingsFor(String subject);

    Person findBestPersonFor(String skill);
}