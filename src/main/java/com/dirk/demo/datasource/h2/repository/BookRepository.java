package com.dirk.demo.datasource.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dirk.demo.datasource.h2.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}