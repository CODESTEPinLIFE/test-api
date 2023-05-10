package com.example.PeopleTest.api.controller;

import com.example.PeopleTest.api.exceptions.BadRequestException;
import com.example.PeopleTest.api.factory.FactorySchoolDto;
import com.example.PeopleTest.api.store.repositories.SchoolRepositories;
import com.example.PeopleTest.api.store.entities.SchoolEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller

public class SchoolController {
    private static final String CREATE_SCHOOL = "/api/school/{schoolName}";
    private SchoolRepositories schoolRepositories;
    private FactorySchoolDto factorySchoolDto;

    @PostMapping(CREATE_SCHOOL)
    public ResponseEntity<?> createSchool(@PathVariable String schoolName) {
        if (schoolRepositories.existByName(schoolName)) {
            throw new BadRequestException(String.format("Учебное заведение с названием \"s\" уже существует"));
        }
      SchoolEntity schoolEntity =   schoolRepositories.saveAndFlush(SchoolEntity.makeDefault(schoolName));
       return ResponseEntity.ok();

    }

}
