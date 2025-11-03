package edu.com.community.inventory.management.domain.helpers;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Sort.Direction;

public record Paginator(
        @NotNull(message = "direction requerido")
        Direction direction,
        @NotNull(message = "property requerido")
        String property,
        @NotNull(message = "pageNumber requerido")
        Integer pageNumber,
        @NotNull(message = "pageSize requerido")
        Integer pageSize
) {
}
