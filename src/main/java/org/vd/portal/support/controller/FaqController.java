package org.vd.portal.support.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vd.portal.support.data.model.Category;
import org.vd.portal.support.data.model.Suggestion;
import org.vd.portal.support.data.repository.CategoryRepository;
import org.vd.portal.support.data.repository.SuggestionRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller de Faq
 */
@Controller
public class FaqController {

    /**
     * Logger
     */
    private static Logger logger = LogManager.getLogger(FaqController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SuggestionRepository suggestionRepository;

    @RequestMapping("/faq")
    public String faq(Model model, HttpServletRequest request) {
        return "/module/faq/faq.jsp";
    }
}