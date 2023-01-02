package com.demo.ReactiveCrud.controller;

import com.demo.ReactiveCrud.model.Producto;
import com.demo.ReactiveCrud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoService service;


    //Get Request - Listado de productos
    @GetMapping("/listado")
    public Flux<Producto> listarProductos(){
        return service.listado();
    }

    //Get Request - Buscar producto por ID
    @GetMapping("/find/{id}")
    public Mono<Producto> buscarProducto(@PathVariable String id){
        return service.buscarProducto(id);
    }

    //Post Request - Nuevo producto
    @PostMapping("/nuevo")
    public Mono<Producto> nuevoProducto(@RequestBody Producto producto){
        return service.nuevoProducto(producto);
    }

    //Put Request - Actualizacion de datos de producto
    @PutMapping("/update/{id}")
    public Mono<Producto> actualizarProducto(@RequestBody Producto producto, @PathVariable String id){
        return service.updateProducto(producto, id);
    }

    //Delete Request - Borrar producto segun ID
    @DeleteMapping("/delete/{id}")
    public Mono<Void> borrarProducto(@PathVariable String id){
        return service.delete(id);
    }
}
