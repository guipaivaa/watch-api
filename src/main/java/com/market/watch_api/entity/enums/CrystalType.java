package com.market.watch_api.entity.enums;

public enum CrystalType {
    //tipoVidro (mineral | sapphire | acrylic)
    MINERAL("mineral"),
    SAPPHIRE("sapphire"),
    ACRYLIC("acrylic");

    private final String apiValue;

    CrystalType(String value) {
        this.apiValue = value;
    }

    public String toApi() {
        return this.apiValue;
    }

    public static CrystalType fromApi(String incomingValue) {
        if (incomingValue == null) {
            throw new IllegalArgumentException("CrystalType cannot be null");
        }

        for (CrystalType type : values()) {
            if (type.apiValue.equalsIgnoreCase(incomingValue.trim())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type of CrystalType not found: " + incomingValue);
    }
}
