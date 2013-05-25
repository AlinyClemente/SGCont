
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
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997001, 'ADVOGADO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997003, 'AGRIMENSOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997002, 'AGRONOMO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997053, 'ANALISTA DE SISTEMAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997004, 'ARQUITETO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997028, 'ASSISTENTE SOCIAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997005, 'ATUARIO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997006, 'AUDITOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997019, 'AVALIADOR (COM CURSO SUPERIOR)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997029, 'BIBLIOTECARIO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997030, 'BIOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997044, 'BIOMEDICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997007, 'BOTANICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997046, 'CIENTISTA POLÍTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997042, 'CONSULTOR TECNICO (COM CURSO S', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997008, 'CONTADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997068, 'DESIGNER', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997010, 'ECONOMISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997055, 'EMPREGADOR (A)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997031, 'ENFERMEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997011, 'ENGENHEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997057, 'ENGENHEIRO CIVIL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997069, 'ENGENHEIRO E TECNOLOGO EM MECA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997012, 'ESTATISTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997032, 'FARMACEUTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997063, 'FILOSOFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997033, 'FISICO EM GERAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997048, 'FISIOTERAPEUTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997013, 'FONOAUDIOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997015, 'GEOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997014, 'GEOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997064, 'HISTORIADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997016, 'JORNALISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997065, 'MATEMATICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997017, 'MEDICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997066, 'MEDICO PSIQUIATRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997034, 'MUSEOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997035, 'MUSICO (COM CURSO SUPERIOR)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997054, 'MUSICO TERAPEUTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997018, 'NUTRICIONISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997009, 'ODONTOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997047, 'OUTROS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997036, 'PAISAGISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997043, 'PEDAGOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997062, 'PROFESSOR DE EDUCAÇÃO FÍSICA (', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997037, 'PROFESSOR DE EDUCAÇÃO MEDIA (C', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997022, 'PROFESSOR DE ENSINO SUPERIOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997050, 'PROGRAMADOR VISUAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997021, 'PROJETISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997059, 'PSICANALISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997020, 'PSICOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997067, 'PUBLICITARIO (COM CURSO SUPERI', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997038, 'QUIMICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997070, 'RELACOES INTERNACIONAIS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997045, 'RELACOES PUBLICAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9977070, 'RELACOES PUBLICAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997058, 'SECRETARIO (COM CURSO SUPERIOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997039, 'SOCIOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997023, 'TECNICO DE ADMINISTRACAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997040, 'TECNICO EDUCACIONAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997041, 'TECNICO EM COMUNICACAO SOCIAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997049, 'TEOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997071, 'TERAPEUTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997061, 'TERAPEUTA HOLISTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997052, 'TERAPEUTA OCUPACIONAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997024, 'TRADUTOR INTERPRETE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997056, 'TURISMOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997025, 'URBANISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997026, 'VETERINARIO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997027, 'ZOOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997060, 'ZOOTECNISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998069, 'ACUPUNTURISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998067, 'ADERECISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998008, 'ADMINISTRADOR DE BENS OU NEGOC', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998043, 'AFINADOR DE PIANO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998093, 'AGENTE COMUNITARIO DE SAUDE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998036, 'AGENTE DE EMPREGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998001, 'AGENTE DE INVESTIMENTO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998009, 'AGENTE DE PROPRIEDADE ARTISTIC', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998002, 'AGENTE DE PROPRIEDADE INDUSTRI', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998101, 'AGENTE DE VIAGEM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998010, 'AGRIMENSOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998011, 'ALFAIATE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998097, 'ALMOXARIFE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998012, 'ARBITRO DESPORTIVO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998003, 'ARMADOR DE ESTRUTURAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998058, 'ARQUEADOR, FISCAL DE CARGA DE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998004, 'ARTISTA EM GERAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998045, 'ASSESSOR TECNICO DE OPERACOES', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998102, 'ATOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998103, 'AUXILIAR DE ESCRITORIO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998095, 'AUXILIAR DE LABORATÓRIO (ANÁLI', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998091, 'AUXILIAR DE SERVICOS GERAIS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998030, 'AVALIADOR (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998104, 'BAILARINO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998013, 'CALCULISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998105, 'CARTOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998107, 'CENOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998092, 'CINEASTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998014, 'CINEGRAFISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998083, 'CONFERENTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998062, 'CONGELEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998046, 'CONSULTOR TECNICO (NÍVEL MÉDIO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998108, 'CONTACTOLOGO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998106, 'COREOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998048, 'CORRETOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998075, 'CORRETOR DE IMOVEIS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998088, 'CROMOTERAPEUTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998015, 'DECORADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998016, 'DESENHISTA TECNICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998017, 'DESPACHANTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998051, 'DETETIVE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998071, 'DIGITADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998089, 'DRAGADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998084, 'EMPRESARIO ARTISTICO/PROMOTOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998109, 'ESCRITOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (998122, 'ESOTERICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998098, 'ESPECIALISTA EM BANHO E TOSA D', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998019, 'ESTENOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998066, 'ESTETICISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998082, 'ESTILISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998110, 'ESTOQUISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998113, 'FERRAMENTEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998054, 'FIGURINISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998111, 'FORNEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998072, 'FUNDIDOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998112, 'GALVANIZADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999074, 'GRAFICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998021, 'GUIA DE TURISMO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998400, 'INSPETOR DE SINISTRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998050, 'INSTRUMENTADOR CIRURGICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998090, 'INSTRUTOR DE TREINAMENTOS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998022, 'LEILOEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998057, 'MAITRE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998005, 'MAQUINISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998006, 'MECANOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998042, 'MESTRE DE OBRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998023, 'MODELO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998024, 'MODISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998077, 'MONITOR DE RECREACAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998025, 'MUSICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998087, 'OPERADOR DE APARELHO DE SOM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998007, 'OPERADOR DE APARELHOS CINEMATO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998115, 'OPERADOR DE MAQUINA COPIADORA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998060, 'OPERADOR DE MAQUINAS INDUSTRIA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998094, 'OPERADOR DE TELEMENSAGEM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998065, 'OPERADOR DE TERMINAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998114, 'OPTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998026, 'ORTOPTISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998027, 'OURIVES', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998047, 'OUTROS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998053, 'PASTOR, SEMINARISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998052, 'PESQUISADOR (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998059, 'PILOTO DE AERONAVE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998117, 'PIROTECNICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998041, 'PROFESSOR (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998037, 'PROGRAMADOR (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998063, 'PROGRAMADOR VISUAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998029, 'PROJETISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998116, 'PROMOTOR DE VENDAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998127, 'PROPAGANDISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998038, 'PROPAGANDISTA DE PRODUTOS DE L', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998028, 'PROTETICO (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998031, 'PUBLICITARIO (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998056, 'RADIALISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998081, 'RECEPCIONISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998032, 'REPRESENTANTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998118, 'RESTAURADOR DE PINTURAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998033, 'SECRETARIO (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998079, 'SERIGRAFIA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998055, 'SONDADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998076, 'SUPERVISOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998099, 'TECNICO ADMINISTRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998061, 'TECNICO AGRICOLA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998040, 'TECNICO APAR. DENTARIOS,RAIO X', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998018, 'TECNICO DE ENFERMAGEM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998085, 'TECNICO DE SEGURANCA DO TRABAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998120, 'TECNICO DE TELECOMUNICACOES', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998119, 'TECNICO EM COMPUTACAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998020, 'TECNICO EM CONTABILIDADE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998044, 'TECNICO EM EDIFICACOES', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998074, 'TECNICO EM ELETRONICA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998086, 'TECNICO EM EXTINTOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998100, 'TECNICO EM MECANICA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998096, 'TECNICO EM PERFUSAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998073, 'TECNICO EM SANEAMENTO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998068, 'TECNICO EM TELEFONIA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998064, 'TECNICO INDUSTRIAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998121, 'TECNICO QUIMICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998070, 'TECNICO TEXTIL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998078, 'TELEFONISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998034, 'TERAPEUTA (NÍVEL MÉDIO)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998039, 'TÉCNICO EM ELETROTÉCNICA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998122, 'TÉCNICO EM IMOBILIZAÇÃO ORTOPÉ', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998126, 'TÉCNICO EM OPTOMETRIA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998123, 'TÉCNICO EM REFRIGERAÇÃO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998080, 'TOPOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998035, 'TRADUTOR E INTERPRETE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998049, 'VENDEDOR COMISSIONADO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999001, 'AMOLADOR DE FERRAMENTAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999020, 'ANALISTA TECNICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999094, 'ARRUMADEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999091, 'ARRUMADOR DE CAMINHAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999061, 'ARTESAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999096, 'ARTISTA CIRCENSE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999038, 'ARTISTA PLASTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999103, 'ASCENSORISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999095, 'ASSISTENTE A MENORES DE RUA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999098, 'ATENDENTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999021, 'ATENDENTE DE ENFERMAGEM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999097, 'AUXILIAR DE DESPACHANTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999022, 'AUXILIAR DE ENFERMAGEM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999023, 'AUXILIAR DE TERAPEUTICA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999024, 'BARBEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999104, 'BARMAN', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999025, 'BOMBEIRO HIDRAULICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999026, 'BORDADEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999002, 'BORRACHEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999027, 'CABELEIREIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999003, 'CALAFATE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999099, 'CALISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999083, 'CAMAREIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999004, 'CAPOTEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999028, 'CARPINTEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999029, 'CARREGADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999089, 'CARTAZEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999030, 'CENOTECNICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999031, 'CERZIDEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999005, 'CHAVEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999032, 'COBRADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999006, 'COLCHOEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999033, 'CONDUTOR AUTÔNOMO DE VEICULOS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999105, 'COPEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999034, 'COSTUREIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999106, 'COZINHEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999007, 'CUTELEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999035, 'DATILOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999087, 'DEPILADORA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999084, 'DOCEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999036, 'ELETRICISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999088, 'ENCADERNADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999008, 'ENGRAXATE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999037, 'ENTALHADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999072, 'ENTELADOR DE MAPAS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999076, 'ENTREGADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999039, 'ESTUCADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999009, 'ESTUFADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999010, 'FEIRANTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999011, 'FERRADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999012, 'FERREIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999040, 'FOTOGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999107, 'FRENTISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999013, 'FUNILEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999115, 'GARCON', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999041, 'GARCON  E COZINHEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999077, 'GRAVADOR CALIGRAFO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999110, 'GUARDA DE SEGURANÇA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999109, 'GUARDADOR DE VEICULOS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999014, 'GUARDADOR DE VOLUMES', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999015, 'HIGIENIZACAO E DESINFECCAO DE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999059, 'INSTRUTOR DE ANIMAIS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999042, 'INSTRUTOR DE AUTO-ESCOLA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999043, 'JARDINEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999044, 'JOQUEI', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999102, 'JORNALEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999079, 'LAMINADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999075, 'LANTERNEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999016, 'LATOEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999071, 'LAVADEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999017, 'LAVADOR E LUBRIFICADOR DE VEIC', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999018, 'LIMPADOR DE IMOVEIS / FAXINEIR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999019, 'LUSTRADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999045, 'MANEQUIM', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999046, 'MANICURE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999108, 'MANOBRISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999111, 'MAQUILADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999047, 'MARCENEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998124, 'MARMORISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999048, 'MASSAGISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999049, 'MECANICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999093, 'MONTADOR EM GERAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999050, 'MOTORISTA DE TAXI', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999101, 'MOTORISTA DE TAXI (AUXILIAR)', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999100, 'MOTORISTA DE TAXI (PERMISSIONA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999062, 'OUTROS AGENTES INTERMEDIARIOS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999078, 'PADEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999073, 'PASSADEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999092, 'PASTELEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999063, 'PASTILHEIRO,AZULEJISTA,LADRILH', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999051, 'PEDICURE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999052, 'PEDREIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999053, 'PELETEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999085, 'PESCADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999054, 'PINTOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999055, 'PINTOR (DE OBJETIVOS ARTISTICO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999086, 'PIPOQUEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999112, 'PORTEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999082, 'RELIGIOSO SEM REMUNERACAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999064, 'RELOJOEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999116, 'RESTAURADOR DE LIVROS E OUTROS', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999056, 'SAPATEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999065, 'SELEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999113, 'SERRADOR DE MADEIRA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999066, 'SERRALHEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999080, 'SERVENTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999067, 'SOLDADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999081, 'TALHADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999068, 'TAPECEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9998125, 'TATUADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999057, 'TAXIDERMISTA', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999114, 'TECELAO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999058, 'TINTUREIRO INDIVIDUAL', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999069, 'TORNEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999070, 'VIDRACEIRO', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999060, 'VIGILANTE', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999090, 'ZELADOR', 1, '2007-01-12 10:21:32');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9997051, 'ADMINISTRADOR DE EMPRESA', 1, '2006-10-08 07:36:14');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999117, 'MILITAR', 1, '2007-05-09 16:45:00.247985');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999118, 'DO LAR', 1, '2007-05-09 16:45:13.465618');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999119, 'FUNC PUBLICO', 1, '2007-05-09 16:45:33.069');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999120, 'AUX ADMINISTRAÇÃO', 1, '2007-05-09 16:45:54.682003');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999121, 'CINEASTA', 1, '2007-06-09 12:41:30.311682');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999122, 'MOTORISTA', 1, '2007-06-14 17:45:44.598476');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999123, 'MOTOBOY', 1, '2007-06-14 17:46:21.801004');
INSERT INTO cadastro.profissao (cdprofissao, nmprofissao, icuso, tmultimaalteracao) VALUES (9999999, 'COMERCIARIO', 1, '2007-07-18 11:18:23.889373');




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

