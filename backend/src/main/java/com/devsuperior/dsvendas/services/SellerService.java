package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.SellerMapper;
import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.repositories.SellerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SellerService {
	
	private SellerRepository repository;
	private SellerMapper mapper;
	
	public List<SellerDTO> findAll() {
		return mapper.toListDTO(repository.findAll());
	}

}
