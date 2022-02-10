CREATE TABLE IF NOT EXISTS vehicle
(
    id            uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    type          text NOT NULL,
    manufacturer  text NOT NULL,
    model         text NOT NULL,
    model_year    text NOT NULL,
    licence_plate text,
    colour        text NOT NULL,
    status        text NOT NULL
);


