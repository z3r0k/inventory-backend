/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnoservices.inventory.services;

import com.tecnoservices.inventory.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Janus
 */
public interface ICategoryServices {
    
    public ResponseEntity<CategoryResponseRest> search();
    
    
}
