package com.market.watch_api.entity.enums;

public enum CaseMaterial {
    STEEL("steel"),
    TITANIUM("titanium"),
    RESIN("resin"),
    CERAMIC("ceramic"),
    BRONZE("bronze");

    private final String apiValue;

    CaseMaterial(String value) {
        this.apiValue = value;
    }

    public String toApi() {
        return this.apiValue;
    }

    public static CaseMaterial fromApi(String incomingValue) {
        if (incomingValue == null) {
            throw new IllegalArgumentException("CaseMaterial cannot be null");
        }

        for (CaseMaterial material : values()) {
            if (material.apiValue.equalsIgnoreCase(incomingValue.trim())) {
                return material;
            }
        }
        throw new IllegalArgumentException("Type of CaseMaterial not found: " + incomingValue);
    }
}
