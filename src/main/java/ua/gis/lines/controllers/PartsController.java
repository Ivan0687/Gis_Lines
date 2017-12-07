package ua.gis.lines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.gis.lines.services.TowerMarkService;
import ua.gis.lines.services.impl.parts.TowerMarkServiceImpl;

@Controller
@RequestMapping("/parts")
public class PartsController {

    private final TowerMarkService towerMarkService;

    @Autowired
    public PartsController(TowerMarkService towerMarkService) {
        this.towerMarkService = towerMarkService;
    }

    @GetMapping("/tower_marks")
    public ModelAndView showTowerTypes(){
        ModelAndView marks = new ModelAndView("tower_marks");

        marks.addObject("marks", towerMarkService.getAll());

        return marks;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView view = new ModelAndView("error");
        view.addObject("message", e.getMessage());
        return view;
    }
}
