package demo.springboot.security.web;

import demo.springboot.security.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("Test Title", "Test Content", "Test extra information, only showed for admin.");
        model.addAttribute("msg", msg);
        return "home";
    }
}
