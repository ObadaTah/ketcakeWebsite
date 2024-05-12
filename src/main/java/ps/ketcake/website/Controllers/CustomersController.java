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
public class CustomersController {

    private final ItemRepository itemRepository;

    @GetMapping("/items/{itemEndPointIdentifier}")
    public String oneItem(Model model, @PathVariable String itemEndPointIdentifier) {
        // Add error handling here
        System.out.println("itemEndPointIdentifier");
        System.out.println(itemEndPointIdentifier);
        model.addAttribute("item", itemRepository.findByEndPointIdentifier(itemEndPointIdentifier)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item identifier")));
        return "customers/item";
    }

    @GetMapping("/menu")
    public String menu() {
        return "customers/menu";
    }
}