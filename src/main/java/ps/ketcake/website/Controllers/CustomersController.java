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
@RequestMapping("/items")
public class CustomersController {

    private final ItemRepository itemRepository;

    @GetMapping("/{itemEndPointIdentifier}")
    public String oneItem(Model model, @PathVariable String itemEndPointIdentifier) {
        // Add error handling here
        model.addAttribute("item", itemRepository.findByEndPointIdentifier(itemEndPointIdentifier).orElseThrow(null));
        return "customers/item";
    }
}