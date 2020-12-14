  	package com.tts.EcommerceBooks.model;

	import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor

	@Entity
	@Table(name = "cart")

	public class Cart {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "cart_id")
	    
				
		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Cart [ quantity=" + quantity + ", price=" + price + "]";
		}

		public Cart(Long id, String item,
				@Min(value = 0, message = "*Quantity has to be non negative number") Integer quantity,
				@DecimalMin(value = "0.00", message = "*Price has to be non negative number") BigDecimal price) {
			super();
			this.quantity = quantity;
			this.price = price;
		}

		
		
	    @Column(name = "quantity", nullable = false)
	    @Min(value = 0, message = "*Quantity has to be non negative number")
	    private Integer quantity;

	    @Column(name = "price", nullable = false)
	    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
	    private BigDecimal price;

	}

