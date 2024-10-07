package com.example.franchise.application.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.usecase.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@Operation(summary = "Crear nuevo producto.", description = "Se envia solo el atributo name en el body")
	public Mono<Product> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar producto")
	public Mono<Void> deleteProduct(@PathVariable("id") Integer id) {
		return productService.deleteProduct(id);
	}

	@PostMapping("/subsidiary")
	@Operation(summary = "4. Agregar un nuevo producto a una sucursal.", description = "Se envia el id, stockQuantity y subsidiary.id del producto en el body")
	public Mono<Product> addProductToSubsidiary(@RequestBody Product product) {
		return productService.addProductToSubsidiary(product);
	}

	@DeleteMapping("/subsidiary")
	@Operation(summary = "5. Eliminar producto de una sucursal, si el producto no esta en ninguna otra sucursal tambien elimina el producto.")
	public Mono<Void> deleteProductFromSubsidiary(@RequestParam("productId") Integer productId,
			@RequestParam("subsidiaryId") Integer subsidiaryId) {
		return productService.deleteProductFromSubsidiary(productId, subsidiaryId);
	}

	@PatchMapping("/subsidiary")
	@Operation(summary = "6. Modificar el stock de un producto.", description = "Se envia el id, stockQuantity y subsidiary.id del producto en el body")
	public Mono<Void> changeProductStockFromSubsidiary(@RequestBody Product product) {
		return productService.changeProductStockFromSubsidiary(product);
	}

	@PatchMapping("/name")
	@Operation(summary = "Pe5. actualizar el nombre de un producto", description = "Se envia el atributo id y name en el body")
	public Mono<Void> changeProductName(@RequestBody Product product) {
		return productService.changeProductName(product);
	}
	
	@GetMapping
	@Operation(summary = "7. Listado de productos con mas stock de cada sucursal para una franquicia.", description = "Si dos productos tienen el mismo stock devuelve ambos productos de la sucursal")
	public Flux<Product> getProductsWithGreaterStock(@RequestParam("franchiseId") Integer franchiseId) {
		return productService.getProductsWithGreaterStock(franchiseId);
	}

}
