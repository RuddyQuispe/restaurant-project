package edu.com.community.inventory.management.infrastructure.input.exceptions;

import java.time.LocalDateTime;

public record GlobalError(
        String message,
        String path,
        LocalDateTime timestamp
) {
}
