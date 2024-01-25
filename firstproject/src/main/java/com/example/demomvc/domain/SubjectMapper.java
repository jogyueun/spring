package com.example.demomvc.domain;

import com.example.demomvc.dto.SubjectPatchDto;
import com.example.demomvc.dto.SubjectResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject subjectPatchDtoToSubject(SubjectPatchDto subjectPatchDto);

    SubjectResponseDto subjectToSubjectResponseDto(Subject subject);

}
