package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.services.SaleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class SaleController {
	
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		return ResponseEntity.ok(service.amountGroupedBySeller());
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller() {
		return ResponseEntity.ok(service.succesGroupedBySeller());
	}

}
