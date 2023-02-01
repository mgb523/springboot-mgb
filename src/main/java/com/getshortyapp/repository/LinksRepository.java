package com.getshortyapp.repository;

import com.getshortyapp.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<Link, Integer> {
}
