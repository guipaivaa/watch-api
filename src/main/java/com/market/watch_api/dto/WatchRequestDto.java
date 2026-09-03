package com.market.watch_api.dto;

import com.market.watch_api.entity.enums.CaseMaterial;
import com.market.watch_api.entity.enums.CrystalType;
import com.market.watch_api.entity.enums.MovementType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record WatchRequestDto(
        @NotBlank(message = "Brand is mandatory")
        @Size(max = 100, message = "Brand must not exceed 100 characters")
        String brand,

        @NotBlank(message = "Model is mandatory")
        @Size(max = 100, message = "Model must not exceed 100 characters")
        String model,

        @NotBlank(message = "Reference is mandatory")
        @Size(max = 100, message = "Reference must not exceed 100 characters")
        String reference,

        @NotNull(message = "Movement type is mandatory")
        MovementType movementType,

        @NotNull(message = "Case material is mandatory")
        CaseMaterial caseMaterial,

        @NotNull(message = "Crystal type is mandatory")
        CrystalType crystalType,

        @NotNull(message = "Water resistance is mandatory")
        @PositiveOrZero(message = "Water resistance must be zero or positive")
        Integer waterResistanceMeters,

        @NotNull(message = "Case diameter is mandatory")
        @Positive(message = "Case diameter must be greater than zero")
        Integer caseDiameterMm,

        @NotNull(message = "Lug to lug is mandatory")
        @Positive(message = "Lug to lug must be greater than zero")
        Integer lugToLugMm,

        @NotNull(message = "Thickness is mandatory")
        @Positive(message = "Thickness must be greater than zero")
        Integer thicknessMm,

        @NotNull(message = "Lug width is mandatory")
        @Positive(message = "Lug width must be greater than zero")
        Integer lugWidthMm,

        @NotNull(message = "Price in cents is mandatory")
        @Positive(message = "Price must be greater than zero")
        Long priceInCents,

        @NotBlank(message = "Image URL is mandatory")
        @Size(max = 500, message = "Image URL must not exceed 500 characters")
        String imageUrl
) {}