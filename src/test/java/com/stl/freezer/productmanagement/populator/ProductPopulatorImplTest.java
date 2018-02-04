package com.stl.freezer.productmanagement.populator;

import com.stl.freezer.FreezerApplication;
import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FreezerApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("Test")
public class ProductPopulatorImplTest {

    @Resource
    private ProductPopulator productPopulator;

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
        product.setId(1L);
        product.setName("testProduct");
        product.setQuantity(1);
    }

    @After
    public void tearDown() throws Exception {
        product = null;
    }

    @Test
    public void convertToProductDto() throws Exception {
        ProductDto productDto = productPopulator.convertToDto(product);
        Assert.assertTrue(product.getName().equals(productDto.getName()));
        Assert.assertTrue(product.getId().equals(productDto.getId()));
        Assert.assertTrue(product.getQuantity() == productDto.getQuantity());
    }

    @Test
    public void testForNull(){
        ProductDto productDto = productPopulator.convertToDto(null);
        Assert.assertNull(productDto);
    }

}