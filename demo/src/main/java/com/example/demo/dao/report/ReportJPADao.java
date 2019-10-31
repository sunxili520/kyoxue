package com.example.demo.dao.report;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.report.EntityReport;
@Qualifier("reportJPA")
public interface ReportJPADao extends JpaRepository<EntityReport, Integer> {

}
