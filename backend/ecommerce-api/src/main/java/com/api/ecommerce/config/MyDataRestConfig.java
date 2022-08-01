package com.api.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.api.ecommerce.entity.Product;
import com.api.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        //Disable http method for Product: POST, PUT, DELETE
        config.getExposureConfiguration()
        		.forDomainType(Product.class)
        		.withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions))
        		.withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions));
        
      //Disable http method for ProductCategory: POST, PUT, DELETE
        config.getExposureConfiguration()
        		.forDomainType(ProductCategory.class)
        		.withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions))
        		.withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions));

    }
}
