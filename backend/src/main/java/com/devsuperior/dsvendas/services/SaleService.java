package com.devsuperior.dsvendas.services;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.mappers.SaleMapper;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {
	
	private SaleRepository repository;
	private SellerRepository sellerRepository;
	private SaleMapper mapper;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		return mapper.toPageableDTO(repository.findAll(pageable));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.ammoutGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> succesGroupedBySeller() {
		return repository.succesGroupedBySeller();
	}

}
