package com.example.PeopleTest.api.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "psychologist")
public class PsychologistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Integer Id;

    @Column(length = 300)
    @NonNull
    private String fio;

    @Column(length = 64)
    @NonNull
    String login;

    @Column(length = 64)
    @NonNull
    String password;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "psychologist_id", referencedColumnName = "id")
    List<TestEntity> tests = new ArrayList<>();
}