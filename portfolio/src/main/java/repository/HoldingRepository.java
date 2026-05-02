package com.agregate.portfolio.repository;

import com.agregate.portfolio.entity.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
}