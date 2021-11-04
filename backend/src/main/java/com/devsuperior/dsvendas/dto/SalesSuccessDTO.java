package com.devsuperior.dsvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesSuccessDTO {
	
	private String sellerName;
	private Long visited;
	private Long deals;

}
