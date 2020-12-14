package com.tts.EcommerceBooks.model;

import java.util.Collection;

import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

public class  UserDetails extends SpringSecurityDialect{
	
	  @Transient
	  private boolean accountNonExpired = true;
	  @Transient
	  private boolean accountNonLocked = true;
	  @Transient
	  private boolean credentialsNonExpired = true;
	  @Transient
	  private boolean enabled = true;
	  @Transient
	  private Collection<GrantedAuthority> authorities = null;
}
