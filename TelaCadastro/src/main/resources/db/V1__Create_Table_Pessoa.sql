-- Adicionar a extensão uuid-ossp se ela não existir
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Criar a tabela Pessoa
CREATE TABLE IF NOT EXISTS person_tb  (
                                      id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                      name VARCHAR(255) NOT NULL,
                                      phone VARCHAR(255) NOT NULL,
                                      cpf VARCHAR(255) NOT NULL UNIQUE,
                                      address VARCHAR(255) NOT NULL,
                                      number VARCHAR(255) NOT NULL,
                                      complements VARCHAR(255) NULL,
                                      zipCode VARCHAR(255) NOT NULL,
                                      district VARCHAR(255) NOT NULL,
                                      city VARCHAR(255) NOT NULL,
                                      state VARCHAR(255) NOT NULL
);