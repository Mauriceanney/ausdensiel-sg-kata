package com.audensiel.kata.domain.operation;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

/**
 * @author Maurice Aney
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Operation {
    private final OperationsTypes operationsTypes;
    private final LocalDateTime date;
    private final BigDecimal amount;
    private final BigDecimal balance;

    public Operation(OperationBuilder operation) {
        this.operationsTypes = requireNonNull(operation.operationsTypes, "Operation type must be specify");
        this.amount =requireNonNull(operation.amount, "Operation amount must not be null");
        this.balance = requireNonNull(operation.balance, "Operation Account balance must not be null");
        this.date = LocalDateTime.now();
    }
}
