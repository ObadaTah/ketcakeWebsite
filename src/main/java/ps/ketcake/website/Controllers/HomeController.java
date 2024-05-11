package ps.ketcake.website.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import ps.ketcake.website.Repositories.ItemRepository;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemRepository itemRepository;

    @GetMapping("/")
    public String oneItem(Model model) {
        // Add error handling here
        // model.addAttribute("item",
        // itemRepository.findByEndPointIdentifier(itemEndPointIdentifier).orElseThrow(null));
        return "index";
    }
}