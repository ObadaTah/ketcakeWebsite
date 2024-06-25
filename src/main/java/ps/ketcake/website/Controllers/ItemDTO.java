package ps.ketcake.website.Controllers;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ItemDTO {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;

    String endPointIdentifier;

    String itemName;
    String itemDescription;
    Integer itemPrice;
    String itemType;
    String itemFlavour;
    Integer itemSize;
    String itemShape;

}
