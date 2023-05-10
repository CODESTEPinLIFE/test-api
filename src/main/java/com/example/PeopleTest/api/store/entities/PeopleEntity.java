package com.example.PeopleTest.api.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
public class PeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 64)
    @NonNull
    private String firstName;

    @Column(length = 64)
    @NonNull
    private String lastName;

    @Column(length = 64)
    private String middleName;

    @NonNull
    private Instant birthday;

    @ManyToOne
    @JoinColumn(name = "psychologist_id", referencedColumnName = "id")
    PsychologistEntity psychologist;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "school_class_id", referencedColumnName = "id")
    List<AnswerEntity> answers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "test_people_id", referencedColumnName = "id")
    TestPeopleEntity testPeopleEntity;

}
