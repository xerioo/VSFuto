package GDE.futo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import GDE.futo.Runner;
import GDE.futo.service.RunnerService;
import java.util.Map;

@Controller
public class ListController {
    
    @Autowired
    private RunnerService runnerService; 

    @PostMapping("/selectComp")
    public String getListCompPage(@ModelAttribute("id") int id, Model model) {

        model.addAttribute("id", id);
        model.addAttribute("results", runnerService.getRunnersByCompetition(id));     
        return "selected_comp";
    }

}
