package ps.ketcake.website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class QrController {

    private final ItemRepository itemRepository;

    @GetMapping("/")
    public String one(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @PostMapping("/add-item")
    public String save_item(@ModelAttribute ItemModel item, Model model) {
        model.addAttribute("item", item);
        itemRepository.save(item);
        return "index";
    }

    @GetMapping("/add-item")
    public String addItem(Model model) {
        model.addAttribute("item", new ItemModel());
        return "add-new-item";
    }
}