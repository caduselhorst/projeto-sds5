package com.devsuperior.dsvendas;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SellerMapper {
	
	private ModelMapper mapper;
	
	public SellerDTO toDTO(Seller seller) {
		return mapper.map(seller, SellerDTO.class);
	}
	
	public Seller toEntity(SellerDTO seller) {
		return mapper.map(seller, Seller.class);
	}
	
	public List<SellerDTO> toListDTO(List<Seller> sellers) {
		return sellers.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

}
