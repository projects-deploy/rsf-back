package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.DepartmentNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.ProductNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.CategoryNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.ProductMapper;
import com.aledguedes.shop.eccomerce.model.Product;
import com.aledguedes.shop.eccomerce.repository.BrandRepository;
import com.aledguedes.shop.eccomerce.repository.ProductRepository;
import com.aledguedes.shop.eccomerce.repository.CategoryRepository;
import com.aledguedes.shop.eccomerce.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	public static final Integer PAGE_SIZE = 12;
	private final ProductMapper productMapper;
	private final BrandRepository brandRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		try {

			var produto = productMapper.toProduct(productRequest);

			var category = categoryRepository.findById(productRequest.getCategory_idd())
					.orElseThrow(CategoryNotFoundException::new);

			var marca = brandRepository.findById(productRequest.getBrand().getId())
					.orElseThrow(DepartmentNotFoundException::new);

			produto.setBrand(marca);
			produto.setCategory(category);
			produto.setPrice_promo(changePromotion(produto));
			produto.setAvailable(existStok(produto.getIn_stok()));

			var createdProduct = productRepository.save(produto);

			return productMapper.toProductResponse(createdProduct);
		} catch (Exception ex) {
			System.out.println("----- ProdutoService.inserirNovoProduto ---");
			ex.printStackTrace();
			System.out.println("-------------------------------------------");
		}
		return null;
	}

	@Override
	public ProductResponse updateProduct(ProductRequest productRequest, Long product_id) {
		try {
			var category = categoryRepository.findById(productRequest.getCategory_idd())
					.orElseThrow(CategoryNotFoundException::new);

			var marca = brandRepository.findById(productRequest.getBrand().getId())
					.orElseThrow(DepartmentNotFoundException::new);

			var produto = productRepository.findById(product_id).orElseThrow(ProductNotFoundException::new);
			BeanUtils.copyProperties(productRequest, produto, "id", "createdAt", "updatedAt");
			produto.setBrand(marca);
			produto.setCategory(category);
			produto.setPrice_promo(changePromotion(produto));
			produto.setAvailable(existStok(produto.getIn_stok()));
			var userAtualizado = productRepository.save(produto);
			return productMapper.toProductResponse(userAtualizado);
		} catch (Exception ex) {
			System.out.println("-------------- ProdutoService.alterarProduto----------");
			ex.printStackTrace();
			System.out.println("--------------------------------------------");
		}
		return null;
	}

	@Override
	public List<ProductResponse> listAll() {
		return productRepository.findAll().stream().map(productMapper::toProductResponse).toList();
	}

	@Override
	public Page<ProductResponse> listarDisponiveis(Integer page) {
		PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
		return productRepository.findAllByAvailable(1, pageable);
	}

	@Override
	public Page<ProductResponse> listarDestaques(Integer page) {
		PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
		return productRepository.findAllByDeliveryAndAvailable(1, 1, pageable);
	}

	@Override
	public List<ProductResponse> listaIndisponiveis() {
		return productRepository.findAllByAvailable(0, null).toList();
	}

	@Override
	public List<ProductResponse> listByDepartment(Long department_id) {
		var category = categoryRepository.findById(department_id)
				.orElseThrow(CategoryNotFoundException::new);
		return productRepository.findAllByAvailableAndCategory(1, category);
	}

	@Override
	public Page<ProductResponse> listarPorPalavraChave(String key, Integer page) {
		PageRequest pageable = PageRequest.of(page, PAGE_SIZE);
		return productRepository.findAllByAvailableAndNameContainingOrAvailableAndDetailContaining(1, key, 1, key,
				pageable);
	}

	@Override
	public ProductResponse listById(Long product_id) {
		return productRepository.findById(product_id).map(productMapper::toProductResponse)
				.orElseThrow(ProductNotFoundException::new);
	}

	private Double changePromotion(Product produto) {

		if (produto.getDiscount() > 0) {
			return produto.getPrice_product() - ((produto.getPrice_product() * produto.getDiscount()) / 100);
		} else {
			return produto.getPrice_product();
		}
	}

	private int existStok(int inStok) {
		return inStok > 1 ? 1 : 0;
	}

}
