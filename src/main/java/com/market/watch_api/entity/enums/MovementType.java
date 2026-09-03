package com.market.watch_api.entity.enums;

public enum MovementType {
    QUARTZ("quartz"),
    AUTOMATIC("automatic"),
    MANUAL("manual");

    private final String apiValue;

    MovementType(String value) {
        this.apiValue = value;
    }

    public String toApi() {
        return this.apiValue;
    }

    public static MovementType fromApi(String incomingValue) {
        if (incomingValue == null) {
            throw new IllegalArgumentException("MovementType cannot be null");
        }

        for (MovementType type : values()) {
            if (type.apiValue.equalsIgnoreCase(incomingValue.trim())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type of MovementType not found: " + incomingValue);
    }


}
