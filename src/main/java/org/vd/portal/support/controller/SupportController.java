package org.vd.portal.support.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/** Controller de support */
@Controller
public class SupportController {

    /** Logger */
    private static Logger logger = LogManager.getLogger(SupportController.class);

    @RequestMapping("/")
    public String root(Model model, HttpServletRequest request) {

        return support(model, request);
    }

    @RequestMapping("/support")
    public String support(Model model, HttpServletRequest request) {

        return "/module/support/support.jsp";
    }
}