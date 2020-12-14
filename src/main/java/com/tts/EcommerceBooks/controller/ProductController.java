package com.tts.EcommerceBooks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.EcommerceBooks.model.Product;
import com.tts.EcommerceBooks.service.ProductService;



@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    
  @GetMapping("/products")
  public String getProduct(Model model) {
	  List<Product> products = new ArrayList<>();
	  
	  products=productService.findAll();
	  if(products!=null) {
		  model.addAttribute("productList", products);  
	  }
	  else {
		  model.addAttribute("productList",products.add(new Product()));
	  }
       return "products";
   }
//  @GetMapping("/product/{id}")
//  public String show(@RequestParam(value = "id",  required=true) Integer id, Model model) {
//      Product product = productService.findById(id);
//     
//      model.addAttribute(product);
//      return "product";
//  }
  @GetMapping(value = "/product/{name}")
  public String getByName(@PathVariable(value="name") String name, Model model) {
	  
	Product product = productService.findByName(name);
   
    model.addAttribute(product);
    return "product";
 }
    // TODO: Either implement admin controls or remove these methods.

    @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public String createOrUpdate(@Valid Product product) {
        productService.save(product);
        return "redirect:/product/" + product.getId();
    }
	@Override
	public String toString() {
		return "ProductController [productService=" + productService + "]";
	}
}

