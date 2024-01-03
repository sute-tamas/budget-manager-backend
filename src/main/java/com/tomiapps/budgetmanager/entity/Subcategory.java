package com.tomiapps.budgetmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "subcategory")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subcategory {

    @Id
    @SequenceGenerator(name = "seq_subcategory", sequenceName = "seq_subcategory", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subcategory")
    private Long id;

    private String name;

}
