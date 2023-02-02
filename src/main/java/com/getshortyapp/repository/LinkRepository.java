package com.getshortyapp.repository;

import com.getshortyapp.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
   Link findByShortened(String path);

   Link findByCurated(String path);
}
