package sample.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.security.MyUserDetails;

@Controller
@RequestMapping("/admin")
public class AdminPageController {
   private static final Logger log = LoggerFactory.getLogger(AdminPageController.class);

   @RequestMapping("/sample")
   public String adminSample(Principal principal, Model model) {
       Authentication auth = (Authentication)principal;
       MyUserDetails userDetails = (MyUserDetails)auth.getPrincipal();

       log.info(userDetails.getUsername()+":"+userDetails.getAuthorities()+":"+ userDetails.getOrgName());

       return "admin/adminSample";
   }
}