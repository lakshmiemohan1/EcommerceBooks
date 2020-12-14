package com.tts.EcommerceBooks.controller;

 import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.ServletException;
import org.springframework.web.bind.annotation.RequestParam;
import com.tts.EcommerceBooks.model.User;
import com.tts.EcommerceBooks.service.UserService;

    @Controller
      class AuthenticationController {
     

    
  @GetMapping("/signin")
  public String login() {
      return "signin";
  }
  
//  @PostMapping("/signin")
//  public String signup(@Valid User user,
//                       @RequestParam String submit,
//                       BindingResult bindingResult,
//                       HttpServletRequest request) throws ServletException {
//      String password = user.getPassword();
//      if(submit.equals("up")) {
//          if(userService.findByUsername(user.getUsername()) == null) {
//              userService.saveNew(user);
//          } else {
//              bindingResult.rejectValue("username", "error.user", "Username is already taken.");
//              return "signin";
//          }
//      }
//      request.login(user.getUsername(), password);
//      return "redirect:/";
//  }
  

   @GetMapping(value="/signup")
   public String signup(Model model){
      User user = new User();
      model.addAttribute("user", user);
      return "signup";
   }

   @PostMapping(value = "/signup")
   public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
     // User userExists = userService.findByUsername(user.getUsername());
     // if (userExists != null) {
          bindingResult.rejectValue("username", "error.user", "Username is already taken");
		return null;
      
			/*
			 * if (!bindingResult.hasErrors()) { userService.saveNew(user);
			 * model.addAttribute("success", "Sign up successful!");
			 * model.addAttribute("user", new User()); } return "signup";
			 */
  }
}

