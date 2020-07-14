
package com.cafe24.ecoshaur;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
  // http://localhost:9090/ecoshaur/
  @RequestMapping(value = "/", method=RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:index.do");
    return mav;
  }//home() end
  
}// class end