package com.example.PeopleTest.api.factory;

import com.example.PeopleTest.api.dto.SchoolDTO;
import com.example.PeopleTest.api.store.entities.SchoolEntity;

public class FactorySchoolDto {
    public SchoolDTO createSchoolDto(SchoolEntity schoolEntity) {
        return SchoolDTO.builder().id(schoolEntity.getId())
                                  .name(schoolEntity.getName())
                                  .build();
    }
}
