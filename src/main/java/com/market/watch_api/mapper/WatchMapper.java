package com.market.watch_api.mapper;

import com.market.watch_api.dto.WatchRequestDto;
import com.market.watch_api.dto.WatchResponseDto;
import com.market.watch_api.entity.Watch;
import com.market.watch_api.entity.enums.CaseMaterial;
import com.market.watch_api.entity.enums.CrystalType;
import com.market.watch_api.entity.enums.MovementType;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WatchMapper {

    public Watch toEntity(WatchRequestDto dto, UUID id) {
        if (dto == null) {
            return null;
        }

        return Watch.builder()
                .id(id != null ? id : UUID.randomUUID())
                .brand(dto.brand())
                .model(dto.model())
                .reference(dto.reference())
                .movementType(dto.movementType())
                .caseMaterial(dto.caseMaterial())
                .crystalType(dto.crystalType())
                .waterResistanceMeters(dto.waterResistanceMeters())
                .caseDiameterMm(dto.caseDiameterMm())
                .lugToLugMm(dto.lugToLugMm())
                .thicknessMm(dto.thicknessMm())
                .lugWidthMm(dto.lugWidthMm())
                .priceInCents(dto.priceInCents())
                .imageUrl(dto.imageUrl())
                .build();
    }

    public WatchResponseDto toResponseDto(Watch watch) {
        if (watch == null) {
            return null;
        }

        return WatchResponseDto.builder()
                .id(watch.getId())
                .brand(watch.getBrand())
                .model(watch.getModel())
                .reference(watch.getReference())
                .movementType(watch.getMovementType())
                .caseMaterial(watch.getCaseMaterial())
                .crystalType(watch.getCrystalType())
                .waterResistanceMeters(watch.getWaterResistanceMeters())
                .caseDiameterMm(watch.getCaseDiameterMm())
                .lugToLugMm(watch.getLugToLugMm())
                .thicknessMm(watch.getThicknessMm())
                .lugWidthMm(watch.getLugWidthMm())
                .priceInCents(watch.getPriceInCents())
                .imageUrl(watch.getImageUrl())
                .waterResistanceLabel(calculateWaterResistanceLabel(watch.getWaterResistanceMeters()))
                .collectorScore(calculateCollectorScore(watch))
                .build();
    }

    private String calculateWaterResistanceLabel(Integer meters) {
        if (meters == null) return "desconhecido";
        if (meters < 50) return "respingos";
        if (meters < 100) return "uso_diario";
        if (meters < 200) return "natacao";
        return "mergulho";
    }

    private Integer calculateCollectorScore(Watch watch) {
        int score = 0;

        if (watch.getCrystalType() == CrystalType.SAPPHIRE) {
            score += 25;
        }
        if (watch.getWaterResistanceMeters() != null && watch.getWaterResistanceMeters() >= 100) {
            score += 15;
        }
        if (watch.getWaterResistanceMeters() != null && watch.getWaterResistanceMeters() >= 200) {
            score += 10;
        }
        if (watch.getMovementType() == MovementType.AUTOMATIC) {
            score += 20;
        }
        if (watch.getCaseMaterial() == CaseMaterial.STEEL) {
            score += 10;
        } else if (watch.getCaseMaterial() == CaseMaterial.TITANIUM) {
            score += 12;
        }
        if (watch.getCaseDiameterMm() != null && watch.getCaseDiameterMm() >= 38 && watch.getCaseDiameterMm() <= 42) {
            score += 8;
        }

        return score;
    }
}