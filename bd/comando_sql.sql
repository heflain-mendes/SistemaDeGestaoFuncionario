CREATE TABLE IF NOT EXISTS funcionairos(
    id INTEGER NOT NULL AUTOINCREMENT UNIQUE,
    nome TEXT NOT NULL,
    cargo TEXT NOT NULL,
    data_inicio TEXT NOT NULL,
    salario_base REAL NOT NULL,
    distancia_trabalho REAL NOT NULL,
    funcionario_mes INTEGER NOT NULL,
    PRIMARY KEY(id)
);

//insert
INSERT INTO funcionairos (nome, cargo, data_inicio, salario_base, distancia_trabalho, funcionario_mes) VALUE (?, ?, ?, ?, ?, ?)

//getAll
SELECT * FROM funcionairos

//update
UPDATE funcionairos SET nome = ? , cargo = ? , data_inicio = ? , salario_base = ? , distancia_trabalho = ? , funcionario_mes = ? WHERE id = ?

//delete
DELETE FROM funcionairos WHERE id = ?

//------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS salarios(
    id INTEGER NOT NULL AUTOINCREMENT UNIQUE,
    id_funcionario INTEGER NOT NULL,
    salario_base REAL NOT NULL,
    salario_total REAL NOT NULL,
    data_salario TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES funcionairos (id)
);

//insert
INSERT INTO salarios (id_funcionario, salario_base, salario_total, data_salario) VALUE ( ?, ?, ?, ?)

//getByIdFuncionario
SELECT * FROM salarios WHERE id_funcionario = ?

//update
UPDATE salarios SET salario_base = ? , salario_total = ? , data_salario = ? WHERE id = ?

//delete
DELETE FROM salarios WHERE id = ?

//------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS bonus(
    id INTEGER NOT NULL AUTOINCREMENT UNIQUE,
    id_funcionario INTEGER NOT NULL,
    tipo TEXT NOT NULL,
    data_bonus TEXT NOT NULL,
    valor REAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES funcionairos (id)
);

//insert
INSERT INTO bonus (id_funcionario, tipo, data_bonus, valor) VALUE ( ?, ?, ?, ?)

//getByIdFuncionario
SELECT * FROM bonus WHERE id_funcionario = ?

//delete
DELETE FROM bonus WHERE id_funcionario = ? AND data_bonus = ?

//------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS faltas(
    id INTEGER NOT NULL AUTOINCREMENT UNIQUE,
    id_funcionario INTEGER NOT NULL,
    qtd INTEGER NOT NULL,
    data_falta TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES funcionairos (id)  
);

//insert
INSERT INTO faltas (id_funcionario, qtd, data_falta) VALUE ( ?, ?, ?)

//getByIdFuncionario
SELECT * FROM faltas WHERE id_funcionario = ?

//update
UPDATE faltas SET qtd = ? , data_falta = ? WHERE id = ?

//deleteByIDFuncionario
DELETE FROM faltas WHERE id_funcionario = ?

//------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS calculos_estatisticos(
    id INTEGER NOT NULL AUTOINCREMENT UNIQUE,
    id_funcionario INTEGER NOT NULL,
    data_calculo TEXT NOT NULL,
    somatorio REAL NOT NULL,
    media REAL NOT NULL,
    desvio_padrao REAL NOT NULL,
    maior_salario REAL NOT NULL,
    qtd_salario INTEGER NOT NULL,
    coeficiente_variacao REAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_funcionario) REFERENCES funcionairos (id)
);

//insert
INSERT INTO calculos_estatisticos (id_funcionario, data_calculo, somatorio, media, desvio_padrao, maior_salario, qtd_salario, coeficiente_variacao) VALUE ( ?, ?, ?, ?, ?, ?, ?, ?)

//getAll
SELECT * FROM calculos_estatisticos

//update
UPDATE calculos_estatisticos SET data_calculo = ? , somatorio = ? , media = ? , desvio_padrao = ? , maior_salario = ? , qtd_salario = ? , coeficiente_variacao = ? WHERE id = ?