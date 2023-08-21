/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnoservices.inventory.response;

import com.tecnoservices.inventory.model.Category;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Janus
 */
@Data
public class CategoryResponse {
    
    private List<Category> category;
    
    
    
}
