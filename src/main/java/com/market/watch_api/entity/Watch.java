package com.market.watch_api.entity;

import com.market.watch_api.entity.enums.CaseMaterial;
import com.market.watch_api.entity.enums.CrystalType;
import com.market.watch_api.entity.enums.MovementType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "watches")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Watch {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "reference", nullable = false, length = 100)
    private String reference;

    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type", nullable = false, length = 50)
    private MovementType movementType;

    @Enumerated(EnumType.STRING)
    @Column(name = "case_material", nullable = false, length = 50)
    private CaseMaterial caseMaterial;

    @Enumerated(EnumType.STRING)
    @Column(name = "crystal_type", nullable = false, length = 50)
    private CrystalType crystalType;

    @Column(name = "water_resistance_meters", nullable = false)
    private Integer waterResistanceMeters;

    @Column(name = "case_diameter_mm", nullable = false)
    private Integer caseDiameterMm;

    @Column(name = "lug_to_lug_mm", nullable = false)
    private Integer lugToLugMm;

    @Column(name = "thickness_mm", nullable = false)
    private Integer thicknessMm;

    @Column(name = "lug_width_mm", nullable = false)
    private Integer lugWidthMm;

    @Column(name = "price_in_cents", nullable = false)
    private Long priceInCents;

    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;
}
