CREATE TABLE beer (
                      id UUID NOT NULL,
                      version INTEGER,
                      beer_name VARCHAR(255),
                      beer_style SMALLINT CHECK (beer_style BETWEEN 0 AND 9),
                      upc VARCHAR(255),
                      quantity_on_hand INTEGER,
                      price NUMERIC(38,2),
                      created_date TIMESTAMP(6),
                      update_date TIMESTAMP(6),
                      PRIMARY KEY (id)
);

CREATE TABLE customer (
                          id UUID NOT NULL,
                          version INTEGER,
                          name VARCHAR(255),
                          created_date TIMESTAMP(6),
                          update_date TIMESTAMP(6),
                          PRIMARY KEY (id)
);