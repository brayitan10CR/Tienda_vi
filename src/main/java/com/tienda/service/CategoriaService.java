
package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaRepository.findAll();
        
        return lista;
    
    }
    
    //se crean los metodos para un  CRUD Create Read Update Delete
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
        categoria =
                categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
        
        return categoria;
    }
    
    @Transactional
    public void delete(Categoria categoria){
        //elimina el registro que tiene el id de categoria pasado en el objeto categoria
        categoriaRepository.delete(categoria);

    }
    
    @Transactional
    public void save(Categoria categoria){
        //si el idCategoria tiene un valor... se actualiza el registro de ese idcategoria
        //si el idcategoria no tiene valor.. se inserta un registro con la informacion de la categoria
        categoriaRepository.save(categoria);
    }
}
