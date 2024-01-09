package com.tomiapps.budgetmanager.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TransactionRequest {

    private Long id;

    private ItemRequest item;

    private Long value;

    private LocalDateTime timestamp;

}
