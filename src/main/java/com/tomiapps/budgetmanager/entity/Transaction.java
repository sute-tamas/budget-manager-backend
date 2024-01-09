package com.tomiapps.budgetmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transactions")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_transaction", sequenceName = "seq_transaction", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transaction")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Long value;

    private LocalDateTime timestamp;

}
