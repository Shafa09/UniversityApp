package com.univapp.dao;

import java.util.List;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.univapp.model.Applicant;
@Repository


public interface ApplicantDAO extends CrudRepository<Applicant,Integer>{
	
	@Query(value="select applicant_Status, applicant_Degree from Applicant a where a. applicant_status =:applicantStatus", nativeQuery=true) 
	List<Applicant[]> getapplicantStatus(@Param("applicantStatus") String applicantStatus);
	
}
