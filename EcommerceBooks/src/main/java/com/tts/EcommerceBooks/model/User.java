	package com.tts.EcommerceBooks.model;

	import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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
	public class User {

		@Override
		public String toString() {
			return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
					+ ", firstName=" + firstName + ", lastName=" + lastName + ", roles=" + roles + ", cart=" + cart
					+ "]";
		}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	    private Long id;
	    
	    @Email(message = "Please provide a valid email")
	    @NotEmpty(message = "Please provide an email")
	    private String email;
	    
	    @NotEmpty(message = "Please provide a username")
	    @Length(min = 3, message = "Your username must have at least 3 characters")
	    @Length(max = 15, message = "Your username cannot have more than 15 characters")
	    @Pattern(regexp="[^\\s]+", message="Your username cannot contain spaces")
	    private String username;
	    
	    @Length(min = 5, message = "Your password must have at least 5 characters")
	    @NotEmpty(message = "Please provide a password")
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private String password;
	    
	    @NotEmpty(message = "Please provide your first name")
	    private String firstName;
	    
	    @NotEmpty(message = "Please provide your last name")
	    private String lastName;
	    
	    @ManyToMany( fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;
	   
	    @ElementCollection
		private Map<Product,Integer> cart;

		public Map<Product, Integer> getCart() {
			// TODO Auto-generated method stub
			return null;
		}

		public CharSequence getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setPassword(String encode) {
			// TODO Auto-generated method stub
			
		}

		public void setCart(Map<Product, Integer> cart2) {
			// TODO Auto-generated method stub
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		public void setPassword1(String encode) {
			// TODO Auto-generated method stub
			
		}

		public void setPassword11(String encode) {
			// TODO Auto-generated method stub
			
		}

	}
