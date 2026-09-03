CREATE TABLE watches
(
    id                      VARCHAR(36) PRIMARY KEY,
    brand                   VARCHAR(100) NOT NULL,
    model                   VARCHAR(100) NOT NULL,
    reference               VARCHAR(100) NOT NULL,
    movement_type           VARCHAR(50)  NOT NULL,
    case_material           VARCHAR(50)  NOT NULL,
    crystal_type            VARCHAR(50)  NOT NULL,
    water_resistance_meters INT          NOT NULL,
    case_diameter_mm        INT          NOT NULL,
    lug_to_lug_mm           INT          NOT NULL,
    thickness_mm            INT          NOT NULL,
    lug_width_mm            INT          NOT NULL,
    price_in_cents          BIGINT       NOT NULL,
    image_url               VARCHAR(500) NOT NULL
);