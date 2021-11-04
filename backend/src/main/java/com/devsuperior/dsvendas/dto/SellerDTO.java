package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SellerDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6091220957271040833L;
	private Long id;
	private String name;

}
