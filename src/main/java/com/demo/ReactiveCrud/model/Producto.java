package com.demo.ReactiveCrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productos")
public class Producto {

    @Id
    private String _id;
    private String nombre;
    private int cantidad;
    private double precio;

}
