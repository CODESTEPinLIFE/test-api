package com.example.PeopleTest.api.store.repositories;

import com.example.PeopleTest.api.store.entities.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepositories extends JpaRepository<SchoolEntity, Integer> {
    boolean existByName(String name);
}
