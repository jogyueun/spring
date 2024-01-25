package com.example.demomvc.domain;

import com.example.demomvc.dto.SubjectPatchDto;
import com.example.demomvc.dto.SubjectResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T01:18:30+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public Subject subjectPatchDtoToSubject(SubjectPatchDto subjectPatchDto) {
        if ( subjectPatchDto == null ) {
            return null;
        }

        Subject subject = new Subject();

        return subject;
    }

    @Override
    public SubjectResponseDto subjectToSubjectResponseDto(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectResponseDto subjectResponseDto = new SubjectResponseDto();

        return subjectResponseDto;
    }
}
