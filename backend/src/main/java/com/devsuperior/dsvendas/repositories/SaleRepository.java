package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("select "
			+ "new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller.name, SUM(obj.amount) ) "
			+ "from Sale AS obj "
			+ "group by obj.seller")
	public List<SaleSumDTO> ammoutGroupedBySeller();
	
	@Query("select "
			+ "new com.devsuperior.dsvendas.dto.SalesSuccessDTO(obj.seller.name, SUM(obj.visited), sum(obj.deals) ) "
			+ "from Sale AS obj "
			+ "group by obj.seller")
	public List<SalesSuccessDTO> succesGroupedBySeller();
	
}
