package com.demo.ReactiveCrud.service;

import com.demo.ReactiveCrud.model.Producto;
import com.demo.ReactiveCrud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository dao;

 /*   //-- ROUTER -- ( No USADO )

    //Devuelve un flujo con el listado de productos
    public Mono<ServerResponse> listarProductos(ServerRequest request) {
        Flux<Producto> customersStream = dao.findAll();
        return ServerResponse.ok().
                contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customersStream, Producto.class);
    }

    // Busca y devuelve un producto por su ID
    public Mono<ServerResponse> buscarProducto(ServerRequest request){
        String productoId= request.pathVariable("id");
        Mono<Producto> productoMono = dao.findById(productoId);
        return ServerResponse.ok().body(productoMono, Producto.class);
    }

    // Crea y almacena un nuevo producto en la DB
    public Mono<ServerResponse> guardarProducto(ServerRequest request){
       Mono<Producto> productoMono = request.bodyToMono(Producto.class);
       Mono<Producto> response = productoMono.flatMap(producto -> dao.save(producto));
       return (ServerResponse.ok().body(response, Producto.class));
    }

*/
    
    //-- API Standar --

    //devuelve el listado de todos los productos
    public Flux<Producto> listado(){
        return dao.findAll();
    }

    //devuelve el producto que coincida con el Id provisto
    public Mono<Producto> buscarProducto(String id){
        return dao.findById(id);
    }

    // Crea un nuevo producto
    public Mono<Producto> nuevoProducto(Producto producto){
        return dao.save(producto);
    }

    // Actualiza los datos del producto que coincida con el ID
    public Mono<Producto> updateProducto(Producto producto, String id){
        return dao.findById(id)
                .doOnNext(p->p.set_id(id))
                .flatMap(dao::save);
    }

    // Elimina el producto que coincida con el ID
    public Mono<Void> delete(String id){
        return dao.deleteById(id);
    }
}
