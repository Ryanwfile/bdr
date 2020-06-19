package com.codereese.BDR.repos;

import com.codereese.BDR.models.Comedian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComedianRepo extends JpaRepository<Comedian, Long> {
}
