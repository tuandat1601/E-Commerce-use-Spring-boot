package com.bootcamp.admin.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.library.dto.ProductDto;
import com.bootcamp.library.model.Category;
import com.bootcamp.library.service.CategoryService;
import com.bootcamp.library.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	 private final ProductService productService;

	    private final CategoryService categoryService;


	    @GetMapping("/products")
	    public String products(Model model, Principal principal) {
	        if (principal == null) {
	            return "redirect:/login";
	        }
	        List<ProductDto> products = productService.allProduct();
	        model.addAttribute("products", products);
	        model.addAttribute("size", products.size());
	        return "products";
	    }

	    @GetMapping("/products/{pageNo}")
	    public String allProducts(@PathVariable("pageNo") int pageNo, Model model, Principal principal) {
	        if (principal == null) {
	            return "redirect:/login";
	        }
	        Page<ProductDto> products = productService.getAllProducts(pageNo);
	        model.addAttribute("title", "Manage Products");
	        model.addAttribute("size", products.getSize());
	        model.addAttribute("products", products);
	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", products.getTotalPages());
	        return "products";
	    }

	    @GetMapping("/search-products/{pageNo}")
	    public String searchProduct(@PathVariable("pageNo") int pageNo,
	                                @RequestParam(value = "keyword") String keyword,
	                                Model model, Principal principal
	    ) {
	        if (principal == null) {
	            return "redirect:/login";
	        }
	        Page<ProductDto> products = productService.searchProducts(pageNo, keyword);
	        model.addAttribute("title", "Result Search Products");
	        model.addAttribute("size", products.getSize());
	        model.addAttribute("products", products);
	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", products.getTotalPages());
	        return "product-result";

	    }

	    @GetMapping("/add-product")
	    public String addProductPage(Model model, Principal principal) {
	        if (principal == null) {
	            return "redirect:/login";
	        }
	        model.addAttribute("title", "Add Product");
	        List<Category> categories = categoryService.findAllByActivatedTrue();
	        model.addAttribute("categories", categories);
	        model.addAttribute("productDto", new ProductDto());
	        return "add-product";
	    }

	    @PostMapping("/save-product")
	    public String saveProduct(@ModelAttribute("productDto") ProductDto product,
	                              @RequestParam("imageProduct") MultipartFile imageProduct,
	                              RedirectAttributes redirectAttributes, Principal principal) {
	        try {
	            if (principal == null) {
	                return "redirect:/login";
	            }
	            productService.save(imageProduct, product);
	            redirectAttributes.addFlashAttribute("success", "Add new product successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("error", "Failed to add new product!");
	        }
	        return "redirect:/products/0";
	    }

	    @GetMapping("/update-product/{id}")
	    public String updateProductForm(@PathVariable("id") Long id, Model model, Principal principal) {
	        if (principal == null) {
	            return "redirect:/login";
	        }
	        List<Category> categories = categoryService.findAllByActivatedTrue();
	        ProductDto productDto = productService.getById(id);
	        model.addAttribute("title", "Add Product");
	        model.addAttribute("categories", categories);
	        model.addAttribute("productDto", productDto);
	        return "update-product";
	    }

	    @PostMapping("/update-product/{id}")
	    public String updateProduct(@ModelAttribute("productDto") ProductDto productDto,
	                                @RequestParam("imageProduct") MultipartFile imageProduct,
	                                RedirectAttributes redirectAttributes, Principal principal) {
	        try {
	            if (principal == null) {
	                return "redirect:/login";
	            }
	            productService.update(imageProduct, productDto);
	            redirectAttributes.addFlashAttribute("success", "Update successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("error", "Error server, please try again!");
	        }
	        return "redirect:/products/0";
	    }

	    @RequestMapping(value = "/enable-product", method = {RequestMethod.PUT, RequestMethod.GET})
	    public String enabledProduct(Long id, RedirectAttributes redirectAttributes, Principal principal) {
	        try {
	            if (principal == null) {
	                return "redirect:/login";
	            }
	            productService.enableById(id);
	            redirectAttributes.addFlashAttribute("success", "Enabled successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("error", "Enabled failed!");
	        }
	        return "redirect:/products/0";
	    }

	    @RequestMapping(value = "/delete-product", method = {RequestMethod.PUT, RequestMethod.GET})
	    public String deletedProduct(Long id, RedirectAttributes redirectAttributes, Principal principal) {
	        try {
	            if (principal == null) {
	                return "redirect:/login";
	            }
	            productService.deleteById(id);
	            redirectAttributes.addFlashAttribute("success", "Deleted successfully!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("error", "Deleted failed!");
	        }
	        return "redirect:/products/0";
	    }
}
