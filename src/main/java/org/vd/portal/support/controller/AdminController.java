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

/**
 * Controller de admin
 */
@Controller
public class AdminController {

    /**
     * Logger
     */
    private static Logger logger = LogManager.getLogger(AdminController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/admin")
    public String faq(Model model, HttpServletRequest request) {

        return "/module/admin/admin-faq.jsp";
    }

    @RequestMapping("/admin-faq")
    public String faq(@RequestParam long idCategory) {
        Category category = categoryRepository.findOne(idCategory);
        return "/module/admin/admin-faq.jsp";
    }

    @RequestMapping("/admin-support")
    public String support(Model model, HttpServletRequest request) {
        return "/module/admin/admin_support.jsp";
    }
}