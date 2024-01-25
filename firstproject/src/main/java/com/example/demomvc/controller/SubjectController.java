package com.example.demomvc.controller;

import com.example.demomvc.domain.Subject;
import com.example.demomvc.domain.SubjectMapper;
import com.example.demomvc.dto.SubjectPatchDto;
import com.example.demomvc.dto.SubjectPostDto;
import com.example.demomvc.service.SubjectService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectMapper mapper;

    @GetMapping("/{subjectId}")
    public ResponseEntity getSubjectById(@PathVariable("subjectId") Long subjectId) {
        return ResponseEntity.ok(subjectService.findSubject(subjectId));
    }

    @GetMapping("")
    public ResponseEntity getAllSubject() {
        return ResponseEntity.ok(subjectService.findSubjects());
    }

    @PostMapping("")
    public ResponseEntity createSubject(@RequestBody SubjectPostDto subjectPostDto) {
        Subject createdSubject = subjectService.createSubject(subjectPostDto.toEntity());
        if (createdSubject == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.created(URI.create("/" + createdSubject.getSubjectId())).build();
    }

    @PatchMapping("/{subjectId}")
    public ResponseEntity updateSubject(@PathVariable("subjectId") Long subjectId, @RequestBody SubjectPatchDto subjectPatchDto) {
        Subject subject = mapper.subjectPatchDtoToSubject(subjectPatchDto);
        return ResponseEntity.ok(subjectService.updateSubject(subject));
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable("subjectId") Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.noContent().build();
    }
}
