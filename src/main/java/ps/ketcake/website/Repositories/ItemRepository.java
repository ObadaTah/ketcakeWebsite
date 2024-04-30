package ps.ketcake.website.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ps.ketcake.website.Models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByEndPointIdentifier(String endPointIdentifier);
}
