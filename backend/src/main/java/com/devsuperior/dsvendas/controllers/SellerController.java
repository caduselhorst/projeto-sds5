package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sellers")
@AllArgsConstructor
public class SellerController {
	
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

}
