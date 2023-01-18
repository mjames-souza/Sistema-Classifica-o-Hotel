DROP TABLE IF EXISTS hoteis;
CREATE TABLE IF NOT EXISTS hoteis(
    id INT auto_increment PRIMARY KEY,
    nome VARCHAR(32),
    rua VARCHAR(32),
    numero VARCHAR(8),
    cidade VARCHAR(32),
    estado VARCHAR(32),
    estrelas VARCHAR(8)
);