package com.market.watch_api.entity.enums;

import org.springframework.data.domain.Sort;

public enum WatchSortOption {
    NEWEST("newest", "id", Sort.Direction.DESC),
    PRICE_ASC("price_asc", "priceInCents", Sort.Direction.ASC),
    PRICE_DESC("price_desc", "priceInCents", Sort.Direction.DESC),
    DIAMETER_ASC("diameter_asc", "caseDiameterMm", Sort.Direction.ASC),
    WR_DESC("wr_desc", "waterResistanceMeters", Sort.Direction.DESC);

    private final String value;
    private final String sortByField;
    private final Sort.Direction direction;

    WatchSortOption(String value, String sortByField, Sort.Direction direction) {
        this.value = value;
        this.sortByField = sortByField;
        this.direction = direction;
    }

    public static WatchSortOption fromValue(String value) {
        if (value == null) {
            return NEWEST;
        }
        for (WatchSortOption option : values()) {
            if (option.value.equalsIgnoreCase(value)) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid sort option: " + value);
    }

    public Sort toSort() {
        return Sort.by(direction, sortByField);
    }
}