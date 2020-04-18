package oiasso.systems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }
    
    @RequestMapping( value="/sumar" , headers = "x-requested-with=XMLHttpRequest")
    @ResponseBody
    public String sumar(Model model, @RequestParam("numero1") String numero1, @RequestParam("numero2") String numero2){
    	
    	Integer n1 = 0;
    	Integer n2 = 0;
    	
    	try {
			 n1 = Integer.parseInt(numero1);
		} catch (Exception e) {
		}

    	
    	try {
			 n2 = Integer.parseInt(numero2);
		} catch (Exception e) {
		}

   		Integer total = n1 + n2;
    	
        return total.toString();
    }

}
