
-- Inserir Usuário
INSERT INTO cadastro.usuario(
            cdusuario, nmusuario, login, senha, nncpf, nntelefone, email, 
            icuso, tmultimaalteracao)
    VALUES (1,'Admin','admin','123','04979584497','33333333','marianavictor.s@gmail.com',1,'2013-04-03 13:24:40.907192');

INSERT INTO cadastro.usuario(
            cdusuario, nmusuario, login, senha, nncpf, nntelefone, email, 
            icuso, tmultimaalteracao)
    VALUES (2,'Sávio','savio','savio05','04295505455','32274164','savioluizac@gmail.com',1,'2013-04-03 13:24:40.907192');

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
    VALUES (1, 'I.S.S.', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (2, 'SIMPLES NACIONAL', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (3, 'COFINS', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (4, 'PIS', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (5, 'CIM-Prefeitura', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (6, 'IRPJ', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (7, 'CONTRIBUIÇÃO SOCIAL', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (8, 'Salários', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (9, 'INSS', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (10, 'FGTS', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (11, 'Vale Transportes', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (12, 'Vale Refeição', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (13, 'Assistência Médica', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (14, 'Férias', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (15, 'Rescisão Trabalhista', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (16, '13º. Salário', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (17, 'INSS - 13º. Salário', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (18, 'FGTS - 13º. Salário', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (19, 'Cursos / Treinamento', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (20, 'Publicidade', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (21, 'Anúncios', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (22, 'Congressos', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (23, 'Congressos', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (24, 'Pró-Labore', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (25, 'INSS - Pró-Labore', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (26, 'Taxa Condominial', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (27, 'Impressos, Mat. de Escritório', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (28, 'Associações de Classe', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (29, 'Água', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (30, 'Energia Elétrica', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (31, 'Correios', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (32, 'Sistemas / Softwares', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (33, 'Telefones / Internet', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (34, 'Seguros', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (35, 'Juros Bancários', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
    cdtipodespesa, descricao, icuso, tmultimaalteracao)
VALUES (36, 'Despesas Bancárias', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_despesa(
            cdtipodespesa, descricao, icuso, tmultimaalteracao)
    VALUES (37, 'Aluguel', 1, '2013-04-03 13:24:40.907192');

-- Tipo de Receita
INSERT INTO operacional.tipo_receita(
            cdtiporeceita, descricao, icuso, tmultimaalteracao)
    VALUES (1, 'Honorários de IRPF', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_receita(
            cdtiporeceita, descricao, icuso, tmultimaalteracao)
    VALUES (2, 'Honorários de Processos de Legalizações', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_receita(
            cdtiporeceita, descricao, icuso, tmultimaalteracao)
    VALUES (3, 'Honorários de Prestação de Serviços Contábeis', 1, '2013-04-03 13:24:40.907192');

INSERT INTO operacional.tipo_receita(
            cdtiporeceita, descricao, icuso, tmultimaalteracao)
    VALUES (4, 'Honorários de Consultas Técnicas e Pesquisas', 1, '2013-04-03 13:24:40.907192');
    

-- Inserir Banco
INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (1, 'BANCO DO BRASIL', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (399, 'HSBC BANK BRASIL S/A', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (24, 'BANCO DO ESTADO DE PERNAMBUCO', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (104, 'CAIXA ECONÔMICA FEDERAL', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (237, 'BRADESCO', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (275, 'BANCO REAL', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (33, 'SANTANDER', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (745, 'CITIBANK', 1, '2013-04-03 13:24:40.907192');

INSERT INTO cadastro.banco(
            cdbanco, dsbanco, icuso, tmultimaalteracao)
    VALUES (341, 'BANCO ITAU', 1, '2013-04-03 13:24:40.907192');

