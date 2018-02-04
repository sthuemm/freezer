package com.stl.freezer.productmanagement.service;

import com.stl.freezer.FreezerApplication;
import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.internal.util.Assert;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FreezerApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("Test")
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(0L, "product1", 3));
        products.add(new Product(1L, "product2", 6));
        products.add(new Product(2L, "product3", 4));
        products.add(new Product(3L, "product4", 4));
        when(productRepository.findAll()).thenReturn(products);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveProduct() throws Exception {
        //TODO implement
    }

    @Test
    public void getProduct() throws Exception {
        //TODO implement
    }

    @Test
    public void getAllProducts() throws Exception {
        List<Product> allProducts = productService.getAllProducts();
        Assert.notNull(allProducts);
        Assert.isTrue(allProducts.size() == 4);
        Assert.isTrue(allProducts.get(0).getQuantity() == 3);
        Assert.isTrue(allProducts.get(1).getQuantity() == 6);
        Assert.isTrue(allProducts.get(2).getQuantity() == 4);
        Assert.isTrue(allProducts.get(3).getQuantity() == 4);
    }

    @Test
    public void getAllProductsDescendingByQuantity() throws Exception {
        List<Product> allProducts = productService.getAllProductsDescendingByQuantity();
        Assert.notNull(allProducts);
        Assert.isTrue(allProducts.size() == 4);
        Assert.isTrue(allProducts.get(0).getQuantity() == 3);
        Assert.isTrue(allProducts.get(1).getQuantity() == 4);
        Assert.isTrue(allProducts.get(2).getQuantity() == 4);
        Assert.isTrue(allProducts.get(3).getQuantity() == 6);
    }

}