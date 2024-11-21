package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMinDTO>> searchAll(
			@RequestParam(name = "minDate", required = false) @DateTimeFormat(iso = ISO.DATE) String minDate,
			@RequestParam(name = "maxDate", required = false) @DateTimeFormat(iso = ISO.DATE) String maxDate,
			@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable){ 
		Page<SaleMinDTO> dto = service.searchAll(minDate, maxDate, name,pageable);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SellerMinDTO>> searchSeller(
			@RequestParam(name = "minDate", required = false) @DateTimeFormat(iso = ISO.DATE) String minDate,
			@RequestParam(name = "maxDate", required = false) @DateTimeFormat(iso = ISO.DATE) String maxDate){ 
		List<SellerMinDTO> dto = service.searchSeller(minDate, maxDate);
		return ResponseEntity.ok(dto);
	}
}
