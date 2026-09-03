package com.market.watch_api.dto;

import com.market.watch_api.entity.enums.CaseMaterial;
import com.market.watch_api.entity.enums.CrystalType;
import com.market.watch_api.entity.enums.MovementType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record WatchResponseDto(
        UUID id,
        String brand,
        String model,
        String reference,
        MovementType movementType,
        Integer caseDiameterMm,
        Integer lugToLugMm,
        Integer thicknessMm,
        Integer lugWidthMm,
        CaseMaterial caseMaterial,
        CrystalType crystalType,
        Integer waterResistanceMeters,
        Long priceInCents,
        String imageUrl,

        String waterResistanceLabel,
        Integer collectorScore
) {
}
