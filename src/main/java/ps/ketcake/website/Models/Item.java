package ps.ketcake.website.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;
    String fileName;

    @Lob
    private String image;

    String endPointIdentifier;

    String itemName;
    String itemDescription;
    Integer itemPrice;
    String itemType;
    String itemFlavour;
    Integer itemSize;
    String itemShape;
}
