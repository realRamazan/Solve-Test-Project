create table limits (
    id INTEGER PRIMARY KEY,
    account_id INTEGER,
    currency_shortname VARCHAR(255),
    limit_balance DOUBLE PRECISION,
    limit_date TIMESTAMP WITH TIME ZONE
);


create table transactions (
                        id INTEGER PRIMARY KEY,
                        account_id INTEGER,
                        limit_balance DOUBLE PRECISION,
                        transaction_amount DOUBLE PRECISION,
                        limit_exceeded BOOLEAN,
                        transaction_date TIMESTAMP WITH TIME ZONE,
                        transaction_type VARCHAR(255)
);


