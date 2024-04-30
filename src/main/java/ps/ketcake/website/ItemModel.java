package ps.ketcake.website;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;
    String fileLocation;
    String endPointIdentifier;

    String itemName;
    String itemDescription;
    String itemPrice;
    String itemType;
    String itemFlavour;
    String itemSize;
    String itemShape;
}
