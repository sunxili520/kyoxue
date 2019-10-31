package com.example.demo.dao.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.order.EntityOrder;
@Qualifier("orderJPA")
public interface OrderJPADao extends JpaRepository<EntityOrder, Long> {

}
