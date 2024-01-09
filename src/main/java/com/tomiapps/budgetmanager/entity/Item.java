package com.tomiapps.budgetmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "items")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_item", sequenceName = "seq_item", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @OneToMany(mappedBy = "item")
    private List<Transaction> transactions;

}
