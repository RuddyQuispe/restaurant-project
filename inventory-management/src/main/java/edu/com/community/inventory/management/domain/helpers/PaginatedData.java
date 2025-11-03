package edu.com.community.inventory.management.domain.helpers;

public record PaginatedData<T>(
        Iterable<T> data,
        Integer pageNo,
        Integer size,
        Integer totalPages,
        Long totalElements
) {
}
