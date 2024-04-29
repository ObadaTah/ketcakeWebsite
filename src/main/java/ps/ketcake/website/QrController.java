package ps.ketcake.website;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class QrController {

    private final ItemRepository itemRepository;

    @GetMapping("/all")
    public String one(Model model) {
        model.addAttribute("item", itemRepository.findAll());
        return "index";
    }

    @PostMapping("/save-item")
    public String saveItem(ItemModel item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-new-item";
        }

        itemRepository.save(item);
        return "redirect:/index";
    }

    @GetMapping("/add-item")
    public String addItem() {
        return "add-new-item";
    }
}