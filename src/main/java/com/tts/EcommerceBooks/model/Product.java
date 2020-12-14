package com.tts.EcommerceBooks.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product")

public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

	@Column(name = "name", nullable = false, unique = true)
	
    private String name;

    @Column(name = "description")
    private String description;
    
    @Column(name = "category")
    private String category;

    @Column(name = "brand")
    private String brand;
    
    @Column(name = "image")
    private String image;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
//	 private int quantity;
//	 private int price;
//	 
//	 private String description;
//	 private String name;
//	 private String brand;
//	 private String category;
//	 private String image;
	 
	
}
