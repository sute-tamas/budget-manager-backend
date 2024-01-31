package com.tomiapps.budgetmanager.repository;

import com.tomiapps.budgetmanager.entity.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findById(Long id);

    List<Item> findBySubcategoryId(Long id);
    
}
