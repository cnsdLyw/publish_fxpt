package com.litc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litc.repository.SupplierRepository;
import com.litc.security.model.Supplier;
import com.litc.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	@Transactional
	public void addSupplier(Supplier supplier) {
		supplier.setLastModifyTime(new Date());
		supplierRepository.save(supplier);

	}

	@Override
	public Supplier getSupplier(Long id) {
		return supplierRepository.findOne(id);
	}

	@Override
	@Transactional
	public Supplier updateSupplier(Supplier supplier) {
		supplier.setLastModifyTime(new Date());
		supplierRepository.save(supplier);
		return supplier;
	}

	@Override
	public void deleteSupplier(Long id) {
		supplierRepository.delete(id);
	}

	@Override
	public int deleteSuppliers(Long[] ids) {
		return supplierRepository.deleteUserIn(ids);
	}

	@Override
	public List<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	@Override
	public Page<Supplier> getSuppliersByPages(int pageNo, int pageSize,
			Direction driection, String orderType, String orgCode,
			String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmailExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmailExist(Long id, String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
