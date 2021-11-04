package com.devsuperior.dsvendas.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SaleMapper {
	
	private ModelMapper mapper;
	
	public SaleDTO toDTO(Sale sale) {
		return mapper.map(sale, SaleDTO.class);
	}
	
	public List<SaleDTO> toListDTO(List<Sale> sales) {
		return sales.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public Page<SaleDTO> toPageableDTO(Page<Sale> sales) {
		return sales.map(this::toDTO);
	}

}
