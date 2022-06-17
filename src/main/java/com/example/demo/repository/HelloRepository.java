package com.example.demo.repository;

import com.example.demo.model.Hello;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends CrudRepository<Hello, Long> {

    @Query("SELECT h FROM Hello h WHERE LOWER(h.lang) = LOWER(:lang)")
    Hello findByLang(@Param("lang") String lang);
}
