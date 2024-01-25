package com.example.demomvc.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryDbRepository {

    private static final Map<Long, Subject> map = new HashMap<>();
    static {
        map.put(1L, new Subject("도레미 파이썬 Vol.1", 119000));
        map.put(2L, new Subject("TOPA 3급 자격증 6주 완성", 249000));
        map.put(3L, new Subject("만들며 배우는 HTML/CSS", 119000));
        map.put(4L, new Subject("당신의 삶을 바꿀 생성 AI의 A-Z", 150000));
        map.put(5L, new Subject("프로젝트로 배우는 SQL 핵심 완성", 408000));
        map.put(6L, new Subject("제대로 배워 딱 붙는 SQLD", 142000));
        map.put(7L, new Subject("성공하는 서비스를 위한 UX 포인트", 99000));
        map.put(8L, new Subject("기초부터 배우는 프론트엔드 A-Z", 95000));
        map.put(9L, new Subject("딥러닝을 이용한 자연어 처리", 170000));
        map.put(10L, new Subject("클라우드 컴퓨팅", 180000));
    }


    public List<Subject> findAll() {
        return map.values().parallelStream().toList();
    }

    public Optional<Subject> findById(long subjectId) {
        return Optional.of(map.get(subjectId));
    }

    public Subject save(Subject subject) {
        if (subject == null) {
            return null;
        }

        if (map.containsKey(subject.getSubjectId())) {
            throw new RuntimeException("Already exists");
        }

        Long maxId = map.keySet().stream()
            .reduce(Long::max)
            .orElse(0L);

        return map.put(maxId + 1, subject);
    }

    public void delete(long subjectId) {
        if (map.containsKey(subjectId)) {
            map.remove(subjectId);
        }
    }

}
