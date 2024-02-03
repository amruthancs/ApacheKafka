package com.amruthan.kafka.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amruthan.kafka.demo.entity.WikimediaEntity;

public interface WikimediaDataRepository extends JpaRepository<WikimediaEntity, Long>{

}
