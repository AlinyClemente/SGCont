
-- Inserir Usuário
INSERT INTO cadastro.usuario(
            cdusuario, nmusuario, login, senha, nncpf, nntelefone, email, 
            icuso, tmultimaalteracao)
    VALUES (1,'Admin','admin','123','04979584497','33333333','marianavictor.s@gmail.com',1,'2013-04-03 13:24:40.907192');

-- Inserir Setor
INSERT INTO cadastro.setor(
            cdsetor, cdsetorsuperior, dssetor, icuso, tmultimaalteracao)
    VALUES (1, null,'CADASTRO', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.setor(
            cdsetor, cdsetorsuperior, dssetor, icuso, tmultimaalteracao)
    VALUES (3, 1, 'CLIENTE', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.setor(
            cdsetor, cdsetorsuperior, dssetor, icuso, tmultimaalteracao)
    VALUES (2, null, 'OPERACIONAL', 2, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.setor(
            cdsetor, cdsetorsuperior, dssetor, icuso, tmultimaalteracao)
    VALUES (4, 2, 'RECEITA', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.setor(
            cdsetor, cdsetorsuperior, dssetor, icuso, tmultimaalteracao)
    VALUES (5, 2, 'DESPESA', 1, '2013-04-03 13:24:40.907192');

-- Inserir Funcionalidade
INSERT INTO cadastro.funcionalidade(
            cdfuncionalidade, cdsetor, nnfuncionalidade, nncaminhoacesso, 
            tmultimaalteracao)
    VALUES (1, 3, 'Inserir Cliente', '#{InserirClienteBean.exibirInserirCliente}', 
            '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.funcionalidade(
            cdfuncionalidade, cdsetor, nnfuncionalidade, nncaminhoacesso, 
            tmultimaalteracao)
    VALUES (2, 4, 'Inserir Receita', '#{InserirReceitaBean.exibirInserirReceita}', 
            '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.funcionalidade(
            cdfuncionalidade, cdsetor, nnfuncionalidade, nncaminhoacesso, 
            tmultimaalteracao)
    VALUES (3, 5, 'Inserir Despesa', '#{InserirDespesaBean.exibirInserirDespesa}', 
            '2013-04-03 13:24:40.907192');

-- Inserir Grupo de Acesso
INSERT INTO cadastro.grupo_acesso(
            cdgrupoacesso, nngrupoacesso, tmultimaalteracao)
    VALUES (1, 'Administrador', '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.grupo_acesso(
            cdgrupoacesso, nngrupoacesso, tmultimaalteracao)
    VALUES (2, 'Cadastro', '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.grupo_acesso(
            cdgrupoacesso, nngrupoacesso, tmultimaalteracao)
    VALUES (3, 'Operacional', '2013-04-03 13:24:40.907192');

-- Profissão 
INSERT INTO cadastro.profissao(
            cdprofissao, nmprofissao, icuso, tmultimaalteracao)
    VALUES (1, 'Analista de Sistemas', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.profissao(
            cdprofissao, nmprofissao, icuso, tmultimaalteracao)
    VALUES (2, 'Bancário', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.profissao(
            cdprofissao, nmprofissao, icuso, tmultimaalteracao)
    VALUES (3, 'Engenheiro', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.profissao(
            cdprofissao, nmprofissao, icuso, tmultimaalteracao)
    VALUES (4, 'Jornalista', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.profissao(
            cdprofissao, nmprofissao, icuso, tmultimaalteracao)
    VALUES (5, 'Autonomo', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.profissao(
            cdprofissao, nmprofissao, icuso, tmultimaalteracao)
    VALUES (6, 'Contador', 1, '2013-04-03 13:24:40.907192');


--Tipo de Despesa
INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (1, 'Luz', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (2, 'Água', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (3, 'Telefone', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (4, 'Honorário', 1, '2013-04-03 13:24:40.907192');


-- Tipo de Receita
INSERT INTO operacional.tipo_receita(
            cdtiporeceita, descricao, icuso, tmultimaalteracao)
    VALUES (1, 'Declaração IR', 1, '2013-04-03 13:24:40.907192');