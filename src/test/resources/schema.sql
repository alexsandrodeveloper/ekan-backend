-- Criação da tabela Beneficiario
CREATE TABLE IF NOT EXISTS Beneficiario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    data_inclusao DATE NOT NULL,
    data_atualizacao DATE NOT NULL
);

-- Criação da tabela Documento
CREATE TABLE IF NOT EXISTS Documento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(50) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_inclusao DATE NOT NULL,
    data_atualizacao DATE,
    beneficiario_id BIGINT,
    FOREIGN KEY (beneficiario_id) REFERENCES Beneficiario(id)
);
