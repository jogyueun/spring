package com.example.demomvc.service;

import com.example.demomvc.domain.MemoryDbRepository;
import com.example.demomvc.domain.Subject;
import com.example.demomvc.exception.ExceptionCode;
import com.example.demomvc.exception.ServiceLogicException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final MemoryDbRepository subjectRepository;

    public SubjectService(MemoryDbRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findSubjects() {
        return subjectRepository.findAll();
    }

    public Subject findSubject(long subjectId) {
        return subjectRepository.findById(subjectId)
            .orElseThrow(() -> new ServiceLogicException(ExceptionCode.SUBJECT_NOT_FOUND));
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Subject subject) {

        Subject findSubject = subjectRepository.findById(subject.getSubjectId())
            .orElseThrow(() -> new ServiceLogicException(ExceptionCode.SUBJECT_NOT_FOUND));

        Optional.ofNullable(subject.getName())
            .ifPresent(name -> findSubject.setName(name));
        Optional.ofNullable(subject.getPrice())
            .ifPresent(price -> findSubject.setPrice(price));

        return subjectRepository.save(findSubject);
    }

    public void deleteSubject(long subjectId) {
        subjectRepository.delete(subjectId);
    }

}
