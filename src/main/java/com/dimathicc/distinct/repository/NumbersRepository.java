package com.dimathicc.distinct.repository;

import com.dimathicc.distinct.model.Numbers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Long> {
    Page<Numbers> findAll(Pageable pageable);

}
