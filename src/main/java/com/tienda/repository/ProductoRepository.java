
package com.tienda.repository;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductoRepository 
        extends JpaRepository <Producto,Long>{
    
    
    //consult ampliada, el findby es para buscar en algo especifico
    public List<Producto> findByPrecioBetweenOrderByPrecio(
            double precioInf,
            double precioSup);
            
            
    
            
            
    //Consulta JPQL
    @Query(value="SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.precio")
     public List<Producto> consultaJPQL(
            double precioInf,
            double precioSup);
    
    
    //Consulta SQL
    @Query(nativeQuery = true, value = "SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.precio")
    public List<Producto> consultaSQL(
            double precioInf,
            double precioSup);
    
    
    //Consulta JPQL
    @Query(value="SELECT a FROM Producto a WHERE a.descripcion LIKE %:descripcion% ORDER BY a.descripcion")
     public List<Producto> consultaJPQLdescripcion(
            String descripcion);

}
