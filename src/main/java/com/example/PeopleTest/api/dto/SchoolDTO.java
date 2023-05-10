package com.example.PeopleTest.api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SchoolDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
}
