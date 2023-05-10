package com.example.PeopleTest.api.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.SQLData;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school_class")
public class SchoolClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 8)
    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private SchoolEntity schoolEntity;
    @Column(name = "school_id", updatable = false, insertable = false)
    Integer schoolId;

}
