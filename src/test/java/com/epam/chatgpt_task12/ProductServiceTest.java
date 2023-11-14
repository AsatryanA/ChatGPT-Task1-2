package com.epam.chatgpt_task12;

import com.epam.chatgpt_task12.model.Product;
import com.epam.chatgpt_task12.repository.ProductRepository;
import com.epam.chatgpt_task12.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllProducts() {
        // Arrange
        when(productRepository.findAll()).thenReturn(Arrays.asList(
                new Product(1L, "Product1", "Description1", 10.0, 20),
                new Product(2L, "Product2", "Description2", 15.0, 30)
        ));

        // Act
        List<Product> products = productService.getAllProducts();

        // Assert
        assertEquals(2, products.size());
    }

    @Test
    void getProductById() {
        // Arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(new Product(1L, "Product1", "Description1", 10.0, 20)));

        // Act
        Optional<Product> product = productService.getProductById(1L);

        // Assert
        assertEquals("Product1", product.get().getName());
        assertEquals(10.0, product.get().getPrice());
    }

    @Test
    void saveProduct() {
        // Arrange
        Product productToSave = new Product(null, "NewProduct", "New Description", 25.0, 50);
        when(productRepository.save(productToSave)).thenReturn(new Product(1L, "NewProduct", "New Description", 25.0, 50));

        // Act
        Product savedProduct = productService.saveProduct(productToSave);

        // Assert
        assertEquals(1L, savedProduct.getId());
        assertEquals("NewProduct", savedProduct.getName());
    }

    @Test
    void deleteProduct() {
        // Arrange
        Long productId = 1L;

        // Act
        productService.deleteProduct(productId);

        // Assert
        verify(productRepository, times(1)).deleteById(productId);
    }
}
