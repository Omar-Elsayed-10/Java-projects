package pl.edu.vistula.firstrestapispring.product.service;

import org.springframework.stereotype.Service;
import pl.edu.vistula.firstrestapispring.product.api.request.ProductRequest;
import pl.edu.vistula.firstrestapispring.product.api.request.UpdateProductRequest;
import pl.edu.vistula.firstrestapispring.product.api.response.ProductResponse;
import pl.edu.vistula.firstrestapispring.product.domain.Product;
import pl.edu.vistula.firstrestapispring.product.repository.ProductRepository;
import pl.edu.vistula.firstrestapispring.product.support.ProductExceptionSupplier;
import pl.edu.vistula.firstrestapispring.product.support.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductExceptionSupplier productExceptionSupplier;

    // ONLY ONE CONSTRUCTOR ALLOWED
    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper,
                          ProductExceptionSupplier productExceptionSupplier) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productExceptionSupplier = productExceptionSupplier;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(productExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(productExceptionSupplier.productNotFound(id));
        productMapper.toProduct(product, updateProductRequest);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    public void delete(Long id) {
        // JPA provides findById and deleteById automatically
        productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));

        productRepository.deleteById(id);
    }

    public List<ProductResponse> findByName(String name) {
        return productRepository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}