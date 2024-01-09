package com.tomiapps.budgetmanager.repository;

import com.tomiapps.budgetmanager.entity.Subcategory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    Optional<Subcategory> findByName(String name);

}
