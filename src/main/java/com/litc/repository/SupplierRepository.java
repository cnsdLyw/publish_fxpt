package com.litc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.litc.security.model.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	
	@Modifying
	@Query("delete from com.litc.security.model.Supplier where id in :ids")
	int deleteUserIn(@Param("ids")Long[] ids);
}