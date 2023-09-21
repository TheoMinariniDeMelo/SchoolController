package io.pro.educare;

public record SearchQuery(
        int page,
        int offSet,
        String terms,
        String sorts,
        String direction
) {
}
