package com.stl.freezer.productmanagement.populator;


import com.stl.freezer.productmanagement.model.Product;
import com.stl.freezer.productmanagement.model.ProductDto;



import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;


import javax.annotation.Nullable;
import javax.annotation.Resource;


@Service
@Slf4j
public class ProductPopulatorImpl implements ProductPopulator {

    private final String TAG = this.getClass().getSimpleName();

    @Resource
    private ModelMapper modelMapper;

    @Override
    @Nullable
    public ProductDto convertToDto(@Nullable Product product) {
        if(product == null){
            log.error(TAG+": product must not be null");
            return null;
        }
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    @Nullable
    public Product convertToEntity(@Nullable ProductDto productDto) {
        if(productDto == null){
            log.error(TAG+": productDto must not be null");
            return null;
        }
        return modelMapper.map(productDto, Product.class);
    }

}
