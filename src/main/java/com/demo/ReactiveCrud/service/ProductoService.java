package com.demo.ReactiveCrud.service;

import com.demo.ReactiveCrud.model.Producto;
import com.demo.ReactiveCrud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    //devuelve el listado de todos los productos
    public Flux listado(){
        return repository.findAll();
    }

    //devuelve el producto que coincida con el Id provisto
    public Mono<Producto> buscarProducto(String id){
        return repository.findById(id);
    }

    // Crea un nuevo producto
    public Mono<Producto> nuevoProducto(Producto producto){
        return repository.save(producto);
    }

    // Actualiza los datos del producto que coincida con el ID
    public Mono<Producto> updateProducto(Producto producto, String id){
        return repository.findById(id)
                .doOnNext(p->p.set_id(id))
                .flatMap(repository::save);
    }

    // Elimina el producto que coincida con el ID
    public Mono<Void> delete(String id){
        return repository.deleteById(id);
    }
}
