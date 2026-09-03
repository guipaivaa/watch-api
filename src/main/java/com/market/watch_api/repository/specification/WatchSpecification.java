package com.market.watch_api.repository.specification;

import com.market.watch_api.entity.Watch;
import com.market.watch_api.entity.enums.MovementType;
import org.springframework.data.jpa.domain.Specification;

public class WatchSpecification {

    public static Specification<Watch> brandEquals(String brand) {
        return (root, query, criteriaBuilder) ->
                brand == null ? null : criteriaBuilder.equal(criteriaBuilder.lower(root.get("brand")), brand.toLowerCase());
    }

    public static Specification<Watch> movementTypeEquals(MovementType movementType) {
        return (root, query, criteriaBuilder) ->
                movementType == null ? null : criteriaBuilder.equal(root.get("movementType"), movementType);
    }

    public static Specification<Watch> priceBetween(Long minPrice, Long maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) return null;
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("priceInCents"), minPrice, maxPrice);
            }
            if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("priceInCents"), minPrice);
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("priceInCents"), maxPrice);
        };
    }

}