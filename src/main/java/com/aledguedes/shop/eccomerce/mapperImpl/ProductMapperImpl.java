package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;
import com.aledguedes.shop.eccomerce.mapper.ProductMapper;
import com.aledguedes.shop.eccomerce.model.Brand;
import com.aledguedes.shop.eccomerce.model.Category;
import com.aledguedes.shop.eccomerce.model.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }

        return Product.builder()
                .name(productRequest.getName())
                .detail(productRequest.getDetail())
                .link_photo(productRequest.getLink_photo())
                .price_product(productRequest.getPrice_product())
                .discount(productRequest.getDiscount())
                .isNew(productRequest.getIsNew())
                .in_stok(productRequest.getIn_stok())
                .product_size(productRequest.getProduct_size())
                .product_colors(productRequest.getProduct_colors())
                .delivery(productRequest.getDelivery())
                .multipleImages(productRequest.getMultipleImages())
                .tags(productRequest.getTags())
                .brand(Brand.builder().id(productRequest.getBrand_idd()).build())
                .category(Category.builder().id(productRequest.getCategory_idd()).build())
                .build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        if (product == null) {
            return null;
        }

        return ProductResponse.builder()
        		.id(product.getId())
                .name(product.getName())
                .detail(product.getDetail())
                .link_photo(product.getLink_photo())
                .price_product(product.getPrice_product())
                .price_promo(product.getPrice_promo())
                .discount(product.getDiscount())
                .in_stok(product.getIn_stok())
                .available(product.getAvailable())
                .isNew(product.getIsNew())
                .delivery(product.getDelivery())
                .average_rating(product.getAverage_rating())
                .review_count(product.getReview_count())
                .product_size(product.getProduct_size())
                .product_colors(product.getProduct_colors())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .multipleImages(product.getMultipleImages())
                .tags(product.getTags())
                .brand(product.getBrand())
                .category(product.getCategory())
                .reviews(product.getReviews())
                .build();
    }

}
