package ps.ketcake.website.DataInit;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ps.ketcake.website.Models.Item;
import ps.ketcake.website.Repositories.ItemRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    // private final RandomDataGenerator dataGenerator;
    private final ItemRepository itemRepository;

    @Override
    public void run(String... args) {
        long startTime = System.currentTimeMillis();
        generateItems();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time: " + totalTime + "ms");
    }

    public void generateItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 5; i++) {
            Item item = Item.builder().endPointIdentifier(RandomDataGenerator.generateRandomWords())
                    .itemName(RandomDataGenerator.generateRandomWords())
                    .itemDescription(RandomDataGenerator.generateRandomWords())
                    .itemPrice(RandomDataGenerator.generateRandomPrice())
                    .itemType(RandomDataGenerator.generateRandomWords())
                    .itemShape(RandomDataGenerator.generateRandomWords())
                    .itemSize(RandomDataGenerator.generateRandomPrice())
                    .build();
            items.add(item);
        }
        itemRepository.saveAll(items);
    }

}
