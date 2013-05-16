CREATE TABLE cadastro.profissao (
  cdProfissao INTEGER NOT NULL,
  nmProfissao VARCHAR(70) NOT NULL,
  icUso SMALLINT NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdProfissao)
);

CREATE SEQUENCE cadastro.seq_profissao
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_profissao
  OWNER TO sgcont;

CREATE TABLE cadastro.grupo_acesso (
  cdGrupoAcesso INTEGER  NOT NULL ,
  nnGrupoAcesso VARCHAR(40) NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdGrupoAcesso)
);

CREATE SEQUENCE cadastro.seq_grupo_acesso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_grupo_acesso
  OWNER TO sgcont;


CREATE TABLE cadastro.setor (
  cdSetor INTEGER  NOT NULL ,
  dsSetor VARCHAR(50) NOT NULL,
  icUso INTEGER  NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdSetor)
);
CREATE SEQUENCE cadastro.seq_setor
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_setor
  OWNER TO sgcont;

CREATE TABLE cadastro.usuario (
  cdUsuario INTEGER  NOT NULL,
  nmUsuario VARCHAR(50) NOT NULL,
  login VARCHAR(50) NOT NULL,
  senha VARCHAR(10) NOT NULL,
  nnCPF VARCHAR(20) NOT NULL,
  nnTelefone VARCHAR(20) NULL,
  email VARCHAR(30) NULL,
  icUso SMALLINT  NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdUsuario)
);

CREATE SEQUENCE cadastro.seq_usuario
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_usuario
  OWNER TO sgcont;

CREATE TABLE operacional.tipo_receita (
  cdTipoReceita INTEGER NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  icUso SMALLINT NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdTipoReceita)
);

CREATE SEQUENCE operacional.seq_tipo_receita
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_tipo_receita
  OWNER TO sgcont;

CREATE TABLE operacional.tipo_despesa (
  cdTipoDespesa INTEGER  NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  icUso SMALLINT NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdTipoDespesa)
);

CREATE SEQUENCE operacional.seq_tipo_despesa
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_tipo_despesa
  OWNER TO sgcont;

CREATE TABLE operacional.compromisso (
  cdCompromisso INTEGER  NOT NULL ,
  dtCompromisso TIMESTAMP NOT NULL,
  dsCompromisso VARCHAR(50) NOT NULL,
  observacao VARCHAR(300) NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdCompromisso)
);

CREATE SEQUENCE operacional.seq_compromisso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_compromisso
  OWNER TO sgcont;

  CREATE TABLE operacional.lembrete (
  cdLembrete INTEGER NOT NULL,
  cdCompromisso INTEGER NOT NULL,
  dsLembrete VARCHAR(255) NULL,
  tmLembrete TIMESTAMP NULL,
  icFrequencia SMALLINT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdLembrete),
  FOREIGN KEY (cdCompromisso) REFERENCES operacional.compromisso(cdCompromisso)
);


CREATE SEQUENCE operacional.seq_lembrete
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_lembrete
  OWNER TO sgcont;


CREATE TABLE cadastro.funcionalidade (
  cdfuncionalidade INTEGER  NOT NULL ,
  cdSetor INTEGER  NOT NULL,
  nnFuncionalidade VARCHAR(50) NOT NULL,
  nnCaminhoAcesso VARCHAR(50) NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdfuncionalidade),
  FOREIGN KEY (cdSetor) REFERENCES cadastro.setor(cdSetor)
);

CREATE SEQUENCE cadastro.seq_funcionalidade
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_funcionalidade
  OWNER TO sgcont;

CREATE TABLE cadastro.endereco (
  cdEndereco INTEGER  NOT NULL,
  cdCep INTEGER NOT NULL,
  dsLogradouro VARCHAR(50) NOT NULL,
  dsComplemento VARCHAR(20) NULL,
  nnBairro VARCHAR(30) NULL,
  dsSiglaUF VARCHAR(2) NOT NULL,
  nmCidade VARCHAR(50) NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  nnEndereco INTEGER NOT NULL,
 PRIMARY KEY(cdEndereco)
);

CREATE SEQUENCE cadastro.seq_endereco
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_endereco
  OWNER TO sgcont;

CREATE TABLE cadastro.empresa_contabil (
  cdEmpresaContabil INTEGER NOT NULL,
  cdEndereco INTEGER  NOT NULL,
  razaoSocial VARCHAR(120) NOT NULL,
  nomeFantasia VARCHAR(120) NULL,
  cnpj VARCHAR(14) NOT NULL,
  logomarca bytea NOT NULL,
  nnTelefone VARCHAR(20) NOT NULL,
  email VARCHAR(30) NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdEmpresaContabil),
  FOREIGN KEY (cdEndereco) REFERENCES cadastro.endereco(cdEndereco)
);

CREATE SEQUENCE cadastro.seq_empresa_contabil
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_empresa_contabil
  OWNER TO sgcont;

CREATE TABLE operacional.compromisso_responsaveis (
  cdCompResponsaveis INTEGER  NOT NULL ,
  cdUsuario INTEGER  NOT NULL,
  cdCompromisso INTEGER  NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdCompResponsaveis),
  FOREIGN KEY (cdUsuario) REFERENCES cadastro.usuario(cdUsuario)
);


CREATE SEQUENCE operacional.seq_compromisso_responsaveis
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_compromisso_responsaveis
  OWNER TO sgcont;

CREATE TABLE cadastro.contador (
  cdContador INTEGER  NOT NULL ,
  cdEmpresaContabil INTEGER NULL,
  cdEndereco INTEGER  NOT NULL,
  cdIdentificacao VARCHAR(20) NOT NULL,
  nmRazaoSocial VARCHAR(70) NOT NULL,
  nnCRC INTEGER  NOT NULL,
  nnTelefone VARCHAR(20) NOT NULL,
  nnFax VARCHAR(20) NULL,
  email VARCHAR(30) NULL,
  icResponsavel SMALLINT  NOT NULL,
  icUso SMALLINT  NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdContador),
  FOREIGN KEY (cdEmpresaContabil) REFERENCES cadastro.empresa_contabil(cdEmpresaContabil),
  FOREIGN KEY (cdEndereco) REFERENCES cadastro.endereco(cdEndereco)
);

CREATE SEQUENCE cadastro.seq_contador
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_contador
  OWNER TO sgcont;

CREATE TABLE cadastro.grupo_acesso_funcionalidade (
  cdGrAcessoFunc INTEGER  NOT NULL,
  cdGrupoAcesso INTEGER  NOT NULL,
  cdfuncionalidade INTEGER  NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdGrAcessoFunc),
  FOREIGN KEY (cdGrupoAcesso) REFERENCES cadastro.grupo_acesso(cdGrupoAcesso),
  FOREIGN KEY (cdfuncionalidade) REFERENCES cadastro.funcionalidade(cdfuncionalidade)
);

CREATE SEQUENCE cadastro.seq_grupo_acesso_funcionalidade
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_grupo_acesso_funcionalidade
  OWNER TO sgcont;

CREATE TABLE cadastro.usuario_grupo_acesso (
  cdUsuGrupoAcesso INTEGER  NOT NULL ,
  cdGrupoAcesso INTEGER  NOT NULL,
  cdUsuario INTEGER  NOT NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdUsuGrupoAcesso),
  FOREIGN KEY (cdGrupoAcesso) REFERENCES cadastro.grupo_acesso(cdGrupoAcesso),
  FOREIGN KEY (cdUsuario) REFERENCES cadastro.usuario(cdUsuario)
);

CREATE SEQUENCE cadastro.seq_usuario_grupo_acesso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_usuario_grupo_acesso
  OWNER TO sgcont;

CREATE TABLE cadastro.cliente (
  cdCliente INTEGER  NOT NULL ,
  cdEndereco INTEGER  NOT NULL,
  nmCliente VARCHAR(100) NOT NULL,
  nnTelefone VARCHAR(20) NOT NULL,
  nnFax VARCHAR(20) NULL,
  email VARCHAR(30) NULL,
  icpessoaFisica SMALLINT  NOT NULL,
  icUso SMALLINT  NOT NULL,
  inscricaoMunicipal VARCHAR(14) NOT NULL,
  observacao VARCHAR(500) NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  PRIMARY KEY(cdCliente),
  FOREIGN KEY(cdEndereco) REFERENCES cadastro.endereco(cdEndereco)
);

CREATE SEQUENCE cadastro.seq_cliente
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE cadastro.seq_cliente
  OWNER TO sgcont;


CREATE TABLE cadastro.cliente_pj (
  cdCliente INTEGER  NOT NULL,
  cdClienteMatriz INTEGER  NULL,
  cdContadorResponsavel INTEGER  NOT NULL,
  razaoSocial VARCHAR(120) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  inscricaoEstadual VARCHAR(20) NOT NULL,
  dtInicioAtividade DATE NULL,
  dtFimAtividade DATE NULL,
  cdSuframa VARCHAR(20) NULL,
  cdNIRE INTEGER  NULL,
  dsSite VARCHAR(40) NULL,
  PRIMARY KEY(cdCliente),
  FOREIGN KEY(cdClienteMatriz) REFERENCES cadastro.cliente_pj(cdCliente),
  FOREIGN KEY(cdContadorResponsavel) REFERENCES cadastro.contador(cdContador)
);


CREATE TABLE cadastro.cliente_pf (
  cdCliente INTEGER  NOT NULL,
  cdClienteTitular INTEGER  NULL,
  cdProfissao INTEGER  NOT NULL,
  nnRG VARCHAR(9) NOT NULL,
  nnCPF VARCHAR(20) NOT NULL,
  nnCEI VARCHAR(20) NULL,
  dtnascimento DATE NOT NULL,
  sexo CHAR NOT NULL,
  icDeclaracaoIR SMALLINT NOT NULL,
  nnTituloEleitor VARCHAR(20) NULL,
  cdBanco INTEGER  NULL,
  nnAgencia VARCHAR(10) NULL,
  nnConta VARCHAR(10) NULL,
  PRIMARY KEY(cdCliente),
  FOREIGN KEY(cdClienteTitular) REFERENCES cadastro.cliente_pf(cdCliente),
  FOREIGN KEY(cdProfissao) REFERENCES cadastro.profissao(cdProfissao)
);


CREATE TABLE operacional.despesa (
  cdDespesa INTEGER NOT NULL,
  cdCliente INTEGER  NULL,
  cdtipodespesa INTEGER  NOT NULL,
  cdEmpresaContabil INTEGER NULL,
  descricao VARCHAR(50) NOT NULL,
  valor numeric(13,2) NOT NULL,
  dtDespesa DATE NOT NULL,
  observacao VARCHAR(300) NULL,
  tmUltimaAlteracao TIMESTAMP NOT NULL,
  icUso SMALLINT  NOT NULL,
  PRIMARY KEY(cdDespesa),
  FOREIGN KEY(cdCliente) REFERENCES cadastro.cliente(cdCliente),
  FOREIGN KEY(cdtipodespesa) REFERENCES operacional.tipo_despesa(cdTipoDespesa),
  FOREIGN KEY(cdEmpresaContabil) REFERENCES cadastro.empresa_contabil(cdEmpresaContabil)
);

CREATE SEQUENCE operacional.seq_despesa
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_despesa
  OWNER TO sgcont;

CREATE TABLE operacional.receita (
  codigo INTEGER NOT NULL,
  cdCliente INTEGER  NULL,
  cdTipoReceita INTEGER NOT NULL,
  cdEmpresaContabil INTEGER NULL,
  descricao VARCHAR(50) NOT NULL,
  valor numeric(13,2) NOT NULL,
  observacao VARCHAR(300) NULL,
  dtreceita DATE NOT NULL,
  tmultimaalteracao TIMESTAMP NOT NULL,
  icUso SMALLINT  NOT NULL,
  PRIMARY KEY(codigo),
  FOREIGN KEY(cdCliente) REFERENCES cadastro.cliente(cdCliente),
  FOREIGN KEY(cdTipoReceita) REFERENCES operacional.tipo_receita(cdTipoReceita),
  FOREIGN KEY(cdEmpresaContabil) REFERENCES cadastro.empresa_contabil(cdEmpresaContabil)
);

CREATE SEQUENCE operacional.seq_receita
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE operacional.seq_receita
  OWNER TO sgcont;