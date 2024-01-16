package com.tomiapps.budgetmanager.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private Long id;

    private ItemResponse item;

    private Long value;

    private LocalDateTime timestamp;

}
