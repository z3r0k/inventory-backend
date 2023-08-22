/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnoservices.inventory.services;

import com.tecnoservices.inventory.dao.ICategoryDao;
import com.tecnoservices.inventory.model.Category;
import com.tecnoservices.inventory.response.CategoryResponseRest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Janus
 */
@Service
public class CategoryServicesImpl implements  ICategoryServices {
    
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
       
        CategoryResponseRest response = new  CategoryResponseRest();
        
        try {
            
            List<Category> category = (List<Category>) categoryDao.findAll();
            
            response.getCategoryResponse().setCategory(category);
            response.setMetadata("Respuesta Correcta", "200", "Respuesta exitosa");
            
        } catch (Exception e) {
            
            
         response.setMetadata("Respuesta Error", "500", "Error al consultar");
         e.getStackTrace();
           return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
          
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }   

    
    
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
      
     CategoryResponseRest response = new  CategoryResponseRest();
      List<Category> list = new ArrayList<>();
        try {
            
            Optional<Category> category = categoryDao.findById(id);
            
            if (category.isPresent()) {
                list.add(category.get());
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Respuesta Correcta", "200", "Categoria encontrada");
            } else {
                response.setMetadata("Not Found", "404", "Categoria no encontrada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception e) {
            
            
         response.setMetadata("Respuesta Error", "500", "Error al consultar por id");
         e.getStackTrace();
           return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
          
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
    }        
    
    
    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        
      CategoryResponseRest response = new  CategoryResponseRest();
      List<Category> list = new ArrayList<>();
        try {
            
            Category categorySaved = categoryDao.save(category);
            
            if (categorySaved != null) {
                list.add(categorySaved);
                response.getCategoryResponse().setCategory(list);
                response.setMetadata("Respuesta Correcta", "200", "Categoria guardada");
            } else {
                response.setMetadata("Failed To Save", "400", "Categoria no guardada");
                return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
            }
            
            
        } catch (Exception e) {
            
            
         response.setMetadata("Respuesta Error", "500", "Error al guardar registro");
         e.getStackTrace();
           return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
          
        }
        return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
        
    }
            
}
