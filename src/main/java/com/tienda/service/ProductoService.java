
package com.tienda.service;

import com.tienda.domain.Producto;
import com.tienda.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    
    
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos){
        var lista = productoRepository.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    
    }
    
    //se crean los metodos para un  CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto){
        producto =
                productoRepository.findById(producto.getIdProducto()).orElse(null);
        
        return producto;
    }
    
    @Transactional
    public void delete(Producto producto){
        //elimina el registro que tiene el id de producto pasado en el objeto producto
        productoRepository.delete(producto);

    }
    
    @Transactional
    public void save(Producto producto){
        //si el idProducto tiene un valor... se actualiza el registro de ese idproducto
        //si el idproducto no tiene valor.. se inserta un registro con la informacion de la producto
        productoRepository.save(producto);
    }
    
    //se crean los metodos para las busquedas
    @Transactional(readOnly=true)
    public List<Producto> consultaAmpliada(double precioInf, double precioSup){

        return productoRepository.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);
    }
    
    
    
    //se crean los metodos para un  CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup){

        return productoRepository.consultaJPQL(precioInf, precioSup);
    }
    
    
    //se crean los metodos para un  CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public List<Producto> consultaSQL(double precioInf, double precioSup){

        return productoRepository.consultaSQL(precioInf, precioSup);
    }
    
    //se crean los metodos para un  CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public List<Producto> consultaJPQLdescripcion(String descripcion){

        return productoRepository.consultaJPQLdescripcion(descripcion);
    }
}
