package GDE.futo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    @RequestMapping("/home")
    public String getHomePage() {
        return("futo_home");
    }

/*    @GetMapping
    public String getDataPage(@RequestParam(required = true, name="new_comp") String new_comp) {
        return "new_comp";
    }*/

}
