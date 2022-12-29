package com.demo.ReactiveCrud.repository;

import com.demo.ReactiveCrud.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository <Producto, String> {
}
