package com.documents.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.documents.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
