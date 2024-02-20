package com.bootcamp.library.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.bootcamp.library.dto.ProductDto;
import com.bootcamp.library.model.Product;

public interface ProductService {
	 	List<Product> findAll();

	    List<ProductDto> products();

	    List<ProductDto> allProduct();

	    Product save(MultipartFile imageProduct, ProductDto product);

	    Product update(MultipartFile imageProduct, ProductDto productDto);

	    void enableById(Long id);

	    void deleteById(Long id);

	    ProductDto getById(Long id);

	    Product findById(Long id);

	    List<ProductDto> randomProduct();

	    Page<ProductDto> searchProducts(int pageNo, String keyword);

	    Page<ProductDto> getAllProducts(int pageNo);

	    Page<ProductDto> getAllProductsForCustomer(int pageNo);

	    List<ProductDto> findAllByCategory(String category);

	    List<ProductDto> filterHighProducts();

	    List<ProductDto> filterLowerProducts();

	    List<ProductDto> listViewProducts();

	    List<ProductDto> findByCategoryId(Long id);

	    List<ProductDto> searchProducts(String keyword);
}
