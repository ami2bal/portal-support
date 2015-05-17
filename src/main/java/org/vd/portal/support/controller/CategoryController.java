package org.vd.portal.support.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vd.portal.support.data.model.Category;
import org.vd.portal.support.data.repository.CategoryRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller de admin
 */
@Controller
public class CategoryController {

    /**
     * Logger
     */
    private static Logger logger = LogManager.getLogger(CategoryController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/category/getCategories")
    @ResponseBody
    public List<Category> getCategories(Model model, HttpServletRequest request) {

        List<Category> categoryList = new ArrayList<>();

        Iterable<Category> categoryIterable = categoryRepository.findAll();
        for (Category aCategoryIterable : categoryIterable) {
            categoryList.add(aCategoryIterable);
        }

        return categoryList;
    }

    @RequestMapping("/category/getCategory")
    @ResponseBody
    public Category getCategory(@RequestParam Long idCategory) {

        Category category = categoryRepository.findOne(idCategory);
        return category;
    }

    @RequestMapping("/category/updateCategory")
    @ResponseBody
    public void updateCategory(@RequestParam Long idCategory, @RequestParam String name) {

        Category category = categoryRepository.findOne(idCategory);
        category.setName(name);
        categoryRepository.save(category);
    }

    @RequestMapping("/category/createCategory")
    @ResponseBody
    public void createCategory(@RequestParam String name) {

        Category category = new Category(name);
        categoryRepository.save(category);
    }
}