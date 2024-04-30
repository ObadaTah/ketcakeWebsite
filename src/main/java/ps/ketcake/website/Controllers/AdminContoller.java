package ps.ketcake.website.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import ps.ketcake.website.Models.Item;
import ps.ketcake.website.Repositories.ItemRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminContoller {

    private final ItemRepository itemRepository;

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @GetMapping("/view-item/{id}")
    public String viewOne(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        model.addAttribute("items", item);
        // make the view-item.html
        return "index";
    }

    @PostMapping("/add-item")
    public String save_item(@ModelAttribute Item item, Model model) {
        model.addAttribute("item", item);
        itemRepository.save(item);
        return "index";
    }

    @GetMapping("/add-item")
    public String addItem(Model model) {
        model.addAttribute("item", new Item());
        return "add-new-item";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));

        model.addAttribute("item", item);
        return "edit-item";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable("id") long id, Item item,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            item.setId(id);
            return "edit-user";
        }

        itemRepository.save(item);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        itemRepository.delete(item);
        return "redirect:/admin";
    }
}