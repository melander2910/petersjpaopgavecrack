package com.jpaopgave.peter.repository;


import com.jpaopgave.peter.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {




}