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
@Table(name = "school")
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 128)
    @NonNull
    String name;

    @Builder.Default
    @OneToMany
    @JoinColumn(referencedColumnName = "id",name= "school_id")
    private List<SchoolClassEntity> schoolClass = new ArrayList<>();

    public static SchoolEntity makeDefault(String schoolName){
        return builder().name(schoolName).build();
    }
}
