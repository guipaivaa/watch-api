CREATE INDEX idx_watches_brand ON watches (brand);
CREATE INDEX idx_watches_model ON watches (model);
CREATE INDEX idx_watches_reference ON watches (reference);

CREATE INDEX idx_watches_movement_type ON watches (movement_type);
CREATE INDEX idx_watches_case_material ON watches (case_material);
CREATE INDEX idx_watches_crystal_type ON watches (crystal_type);

CREATE INDEX idx_watches_price_in_cents ON watches (price_in_cents);
CREATE INDEX idx_watches_case_diameter_mm ON watches (case_diameter_mm);
CREATE INDEX idx_watches_water_resistance ON watches (water_resistance_meters);