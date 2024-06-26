CREATE TABLE tb_user(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    username VARCHAR(20) UNIQUE,
    email VARCHAR(100) UNIQUE ,
    senha VARCHAR(100),
    created_at DATE NOT NULL DEFAULT (curdate()),
    user_role enum ('ESTUDANTE', 'INSTRUTOR', 'ADMIN') DEFAULT 'ESTUDANTE',
    CONSTRAINT check_lower_case_username CHECK (username = LOWER(username)),
    CONSTRAINT check_no_space_username CHECK (username NOT LIKE '% %'),
    CONSTRAINT check_no_number_username CHECK (username REGEXP '^[^0-9]*$')
);