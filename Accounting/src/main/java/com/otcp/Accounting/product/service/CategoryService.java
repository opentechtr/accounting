package com.otcp.Accounting.product.service;

import com.otcp.Accounting.product.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
    List<Category> searchCategoriesByName(String name);
}
