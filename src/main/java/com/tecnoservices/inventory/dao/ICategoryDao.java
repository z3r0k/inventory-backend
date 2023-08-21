/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnoservices.inventory.dao;

import com.tecnoservices.inventory.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Janus
 */
public interface ICategoryDao extends CrudRepository<Category, Long>{
    
}
