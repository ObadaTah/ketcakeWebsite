package ps.ketcake.website.Controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
        List<Item> items = itemRepository.findAll();

        model.addAttribute("items", items);
        return "index";
    }

    // @GetMapping("/view-item/{id}")
    // public String viewOne(@PathVariable("id") long id, Model model) {
    // Item item = itemRepository.findById(id)
    // .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
    // model.addAttribute("item", item);
    // // make the view-item.html
    // return "view-item";
    // }

    @PostMapping("/add-item")
    public String save_item(@ModelAttribute Item item, Model model, @RequestParam("file") MultipartFile file)
            throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // file.getContentType();
        item.setFileName(fileName);
        item.setImage(Base64.getEncoder().encodeToString(file.getBytes()));

        itemRepository.save(item);
        model.addAttribute("item", item);
        return "redirect:/admin";
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
            BindingResult result, Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            item.setId(id);
            return "redirect:/admin";
        }
        Item oldItem = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));
        if (file == null) {
            item.setImage(oldItem.getImage());
        } else {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            // file.getContentType();
            item.setFileName(fileName);
            item.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
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