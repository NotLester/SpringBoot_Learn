package org.lester.springbootlearn.jpalearnfinal.repositories;

import org.lester.springbootlearn.jpalearnfinal.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}