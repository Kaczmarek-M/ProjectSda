package com.barterownia.repository;

import com.barterownia.model.Category;
import com.barterownia.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByCategoryAndItemId(Category category, Long id);
}
