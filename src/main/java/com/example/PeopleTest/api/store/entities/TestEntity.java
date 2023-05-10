package com.example.PeopleTest.api.store.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;



import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(length = 256)
    String name;
    @Builder.Default
    Boolean status = false;
    @ManyToOne
    @JoinColumn(name = "psychologist_id", referencedColumnName = "id")
    PsychologistEntity psychologist;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    List<QuestionEntity> questions = new ArrayList<>();
}
