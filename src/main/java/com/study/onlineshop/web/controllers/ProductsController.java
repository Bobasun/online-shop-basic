package com.study.onlineshop.web.controllers;

import com.study.onlineshop.entity.Product;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.service.ServiceLocator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private ProductService productService = (ProductService) ServiceLocator.getService("productService");

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String editGetById(@RequestParam int id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "edit";
    }

    @PostMapping("/product/{id}")
    public String editPostProductById(@ModelAttribute Product product){
        productService.add(product);
        return "redirect:/products";
    }
//    @GetMapping("/products")
//    public String add(Model model){
//        model.addAttribute(productService.add())
//        return "products";
//    }
}
