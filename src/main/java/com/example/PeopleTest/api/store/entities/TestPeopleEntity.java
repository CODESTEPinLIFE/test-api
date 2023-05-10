package com.example.PeopleTest.api.store.entities;

import jakarta.persistence.*;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="test_people")
public class TestPeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    @Column(length = 50)
    private String answer;

    @Builder.Default
    Instant createdAt = Instant.now();

    @NonNull
    @ManyToOne
    @JoinColumn(name = "school_class_id", referencedColumnName = "id")
    SchoolClassEntity schoolClass;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    TestEntity testEntity;



}
