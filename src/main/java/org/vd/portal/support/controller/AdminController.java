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
import org.vd.portal.support.data.model.Suggestion;
import org.vd.portal.support.data.repository.CategoryRepository;
import org.vd.portal.support.data.service.SuggestionService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller de admin
 */
@Controller
public class AdminController {

    /**
     * Logger
     */
    private static Logger logger = LogManager.getLogger(AdminController.class);

    @RequestMapping("/admin")
    public String faq(Model model, HttpServletRequest request) {

        return "/module/admin/admin.jsp";
    }
}