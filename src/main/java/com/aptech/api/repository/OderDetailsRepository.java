package com.aptech.api.repository;

import com.aptech.api.entity.OrderDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
