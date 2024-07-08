-- Inserção de dados na tabela Beneficiario
INSERT INTO Beneficiario (nome, telefone, data_nascimento, data_inclusao, data_atualizacao) VALUES
    ('Maria Souza', '+5511999999999', '1985-07-15', CURRENT_DATE, CURRENT_DATE);

-- Obtém o ID do beneficiário inserido no H2
SELECT MAX(id) AS beneficiario_id FROM Beneficiario;

-- Inserção de dados na tabela Documento usando o ID obtido
INSERT INTO Documento (tipo_documento, descricao, data_inclusao, data_atualizacao, beneficiario_id)
VALUES
    ('CPF', '123.456.789-00', CURRENT_DATE, CURRENT_DATE, (SELECT MAX(id) FROM Beneficiario));
