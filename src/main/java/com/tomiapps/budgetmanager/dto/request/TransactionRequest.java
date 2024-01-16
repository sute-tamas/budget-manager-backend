package com.tomiapps.budgetmanager.dto.request;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NonNull;

@Data
public class TransactionRequest {

    @NonNull
    private Long id;

    private ItemRequest item;

    private Long value;

    private LocalDateTime timestamp;

}
