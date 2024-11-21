package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public Page<SaleMinDTO> searchAll(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate date1;
		LocalDate date2;
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		if (maxDate == null) {
			date2 = today;
		}
		
		else {
			date2 = LocalDate.parse(maxDate);
		}
		
		if (minDate == null) {
			date1 = date2.minusYears(1L);;
		}
		
		else {
			date1 = LocalDate.parse(minDate);
		}
		
		Page<Sale> result = repository.search1(date1, date2, name, pageable);
		return result.map(x-> new SaleMinDTO(x));
		
	}
	
	public List<SellerMinDTO> searchSeller(String minDate, String maxDate) {
		LocalDate date1;
		LocalDate date2;
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		if (maxDate == null) {
			date2 = today;
		}
		
		else {
			date2 = LocalDate.parse(maxDate);
		}
		
		if (minDate == null) {
			date1 = date2.minusYears(1L);;
		}
		
		else {
			date1 = LocalDate.parse(minDate);
		}

		List<SellerMinDTO> result = repository.search2(date1, date2);
		return result;
	}
}
	

