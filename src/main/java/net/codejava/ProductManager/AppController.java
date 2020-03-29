package net.codejava.ProductManager;

import net.codejava.ProductManager.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("listProducts",productList);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_product");
        Optional<Product> product = productService.getProduct(id);
        mav.addObject("product",product);

        return mav;
    }

}
