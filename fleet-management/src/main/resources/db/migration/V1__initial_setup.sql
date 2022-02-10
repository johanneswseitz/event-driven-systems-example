CREATE TABLE IF NOT EXISTS vehicle
(
    id           uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    type         text NOT NULL,
    manufacturer text NOT NULL
);

