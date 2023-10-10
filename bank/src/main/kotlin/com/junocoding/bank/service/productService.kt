package com.junocoding.bank.service

import com.junocoding.bank.DTOS.addProduct
import com.junocoding.bank.models.Product
import com.junocoding.bank.repositories.productRepository
import org.springframework.stereotype.Service
import java.util.Optional
import javax.persistence.EntityNotFoundException

@Service
class productService(private val productRepository: productRepository){
    //adding the product
    fun addProduct(product:Product):Product{
        println("Added products")
        return productRepository.save(product)
    }
    //getting all products
    fun getAllProducts(product: Product): List<Product> {
        val products=productRepository.findAll()
        return products
    }
    //getting product by Id
    fun getProductByID(id: Long): Optional<Product> {
        val productId=productRepository.findById(id)
        return productId

    }
    //updating product by Id
    fun updateProduct(id: Long, productDto:addProduct): Product {
        val presentproduct=productRepository.findById(id)
            .orElseThrow{EntityNotFoundException("Product not found")}
        productDto.name.let { presentproduct.name=it }
        productDto.image1.let { presentproduct.image1=it }
        productDto.image2.let { presentproduct.image2=it }
        productDto.stock.let { presentproduct.stock=it }
        productDto.stockLevel.let { presentproduct.stockLevel=it }
        productDto.offerprice.let { presentproduct.offerprice=it}
        productDto.price.let { presentproduct.price=it }
        productDto.brandName.let { presentproduct.brandName=it }
        productDto.categoryName.let { presentproduct.categoryName=it }
        productDto.size1.let { presentproduct.size1=it }
        productDto.size2.let { presentproduct.size2=it }
        productDto.size3.let { presentproduct.size3 =it }
        productDto.quantity.let { presentproduct.quantity=it }

        val updatedProduct=productRepository.save(presentproduct)
        return updatedProduct

    }
    //delete product
    fun deleteProduct(id:Long){
        val product=productRepository.findById(id)
        if(product.isPresent){
            productRepository.deleteById(id)
        }else{
            throw EntityNotFoundException("Product not found")
        }
    }

}



