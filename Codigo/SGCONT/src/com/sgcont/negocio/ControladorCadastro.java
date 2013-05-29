package com.sgcont.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.service.spi.ServiceException;

import com.sgcont.dados.cadastro.Cliente;
import com.sgcont.dados.cadastro.ClientePessoaFisica;
import com.sgcont.dados.cadastro.ClientePessoaJuridica;
import com.sgcont.dados.cadastro.Contador;
import com.sgcont.dados.cadastro.EmpresaContabil;
import com.sgcont.dados.cadastro.Usuario;
import com.sgcont.fachada.Fachada;
import com.sgcont.repositorio.IRepositorioCadastro;
import com.sgcont.repositorio.IRepositorioUtil;
import com.sgcont.repositorio.RepositorioCadastro;
import com.sgcont.repositorio.RepositorioUtil;
import com.sgcont.transferobject.ClientePessoaFisicaTO;
import com.sgcont.transferobject.ClientePessoaJuridicaTO;
import com.sgcont.transferobject.ClienteTO;
import com.sgcont.transferobject.ContadorTO;
import com.sgcont.transferobject.EmpresaContabilTO;
import com.sgcont.transferobject.UsuarioTO;
import com.sgcont.util.Util;

/**
 * Controlador responsável pelas regras de negócio do módulo de cadastro
 * */
public class ControladorCadastro implements IControladorCadastro {

	private static ControladorCadastro instance;

	protected IRepositorioCadastro repositorioCadastro = null;
	protected IRepositorioUtil repositorioUtil = null;

	public static synchronized IControladorCadastro getInstance() {
		if (instance == null) {
			instance = new ControladorCadastro();
		}
		return instance;
	}

	private ControladorCadastro() {

		repositorioCadastro = RepositorioCadastro.getInstancia();
		repositorioUtil = RepositorioUtil.getInstancia();

	}

	/**
	 * [UC010] Efetuar Login
	 * 
	 * Método responsável pesquisar um usuário a partir do login e da senha
	 * 
	 * @author Mariana Victor
	 * @since 21/03/2013
	 * */
	public Usuario pesquisarUsuario(String login, String senha) {

		return this.repositorioCadastro.pesquisarUsuario(login, senha);

	}

	/**
	 * [UC001] Inserir Cliente 2.1.1. Caso o usuário escolha Pessoa Física
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa física
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePF(ClienteTO clienteTO,
			ClientePessoaFisicaTO clientePessoaFisicaTO) {

		Cliente cliente = clienteTO.getCliente();
		ClientePessoaFisica clientePessoaFisica = clientePessoaFisicaTO
				.getClientePessoaFisica();

		this.inserirCliente(cliente);

		clientePessoaFisica.setCliente(cliente);
		this.repositorioUtil.inserirOuAtualizar(clientePessoaFisica);

	}

	/**
	 * [UC001] Inserir Cliente 2.1.2. Caso o usuário escolha Pessoa Jurídica
	 * 
	 * Método responsável cadastrar um cliente do tipo pessoa jurídica
	 * 
	 * @author Mariana Victor
	 * @since 19/04/2013
	 * */
	public void inserirClientePJ(ClienteTO clienteTO,
			ClientePessoaJuridicaTO clientePessoaJuridicaTO) {

		Cliente cliente = clienteTO.getCliente();
		ClientePessoaJuridica clientePessoaJuridica = clientePessoaJuridicaTO
				.getClientePessoaJuridica();

		this.inserirCliente(cliente);

		clientePessoaJuridica.setCliente(cliente);
		this.repositorioUtil.inserirOuAtualizar(clientePessoaJuridica);

	}

	private void inserirCliente(Cliente cliente) {
		cliente.getEndereco().setUltimaAlteracao(new Date());
		this.repositorioUtil.inserirOuAtualizar(cliente.getEndereco());

		cliente.setUltimaAlteracao(new Date());
		cliente.setIndicadorUso(new Short("1"));
		this.repositorioUtil.inserirOuAtualizar(cliente);
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar CPF inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCPFValidoExistente(String cpf) {
		String mensagem = null;

		if (!Util.validacaoCPF(cpf)) {
			mensagem = "Dígito verificador do CPF não confere.";
		} else {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) Fachada
					.getInstance().pesquisar(ClientePessoaFisica.class,
							parametros);

			if (clientePessoaFisica != null) {
				mensagem = "CPF já cadastrado para o Cliente "
						+ clientePessoaFisica.getCliente().getNome() + ".";
			}
		}

		return mensagem;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CNPJ
	 * inválido
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarCNPJValidoExistente(String cnpj) {
		String mensagem = null;

		if (!Util.validacaoCNPJ(cnpj)) {
			mensagem = "Dígito verificador do CNPJ não confere.";
		} else {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCnpj", cnpj);
			ClientePessoaJuridica clientePessoaJuridica = (ClientePessoaJuridica) this.repositorioUtil
					.pesquisar(ClientePessoaJuridica.class, parametros);

			if (clientePessoaJuridica != null) {
				mensagem = "CNPJ já cadastrado para o Cliente "
						+ clientePessoaJuridica.getCliente().getNome() + ".";
			}
		}

		return mensagem;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarRGExistente(String rg) {
		String mensagem = null;

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numeroRg", rg);
		ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) this.repositorioUtil
				.pesquisar(ClientePessoaFisica.class, parametros);

		if (clientePessoaFisica != null) {
			mensagem = "RG já cadastrado para o Cliente "
					+ clientePessoaFisica.getCliente().getNome() + ".";
		}

		return mensagem;
	}

	/**
	 * [UC001] Inserir Cliente
	 * 
	 * [FS0002] - Verificar existência de dados
	 * 
	 * @author Mariana Victor
	 * @since 13/05/2013
	 */
	public String verificarTituloEleitorExistente(String tituloEleitor) {
		String mensagem = null;

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numeroTituloEleitor", tituloEleitor);
		ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) this.repositorioUtil
				.pesquisar(ClientePessoaFisica.class, parametros);

		if (clientePessoaFisica != null) {
			mensagem = "Título de Eleitor já cadastrado para o Cliente "
					+ clientePessoaFisica.getCliente().getNome() + ".";
		}

		return mensagem;
	}

	/**
	 * [UC003] Inserir Contador
	 * 
	 * Método responsável cadastrar um contador
	 * 
	 * @author Rômulo Aurélio
	 * @since 11/05/2013
	 * */
	public void inserirContador(ContadorTO contadorTO) {

		if (contadorTO != null) {

			Contador contador = contadorTO.getContador();

			contador.getEndereco().setUltimaAlteracao(new Date());
			this.repositorioUtil.inserirOuAtualizar(contador.getEndereco());

			contador.setUltimaAlteracao(new Date());
			contador.setIndicadorUso(new Integer(1).shortValue());
			repositorioUtil.inserirOuAtualizar(contador);

		}

	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar os cliente cadastrados concatenando CPF /
	 * CNPJ e nome
	 * 
	 * @author Rômulo Aurélio
	 * @since 07/05/2013
	 * 
	 * @return Usuario
	 * */
	public Collection pesquisarDadosClienteParaCombo() {

		Collection<ClienteTO> colecaoClientesCombo = new ArrayList();

		Collection<?> retornoConsulta = null;

		try {

			retornoConsulta = repositorioCadastro
					.pesquisarDadosClienteParaCombo();

			if (retornoConsulta != null && !retornoConsulta.isEmpty()) {

				Iterator<?> iterator = retornoConsulta.iterator();

				while (iterator.hasNext()) {

					ClienteTO clienteTO = new ClienteTO();

					Object[] objetoPesquisa = (Object[]) iterator.next();

					// Codigo
					if (objetoPesquisa[0] != null) {
						clienteTO.setCodigo(((Integer) objetoPesquisa[0])
								.toString());
					}

					// Nome
					if (objetoPesquisa[1] != null) {
						clienteTO.setNome((String) objetoPesquisa[1]);
					}

					// Cpf
					if (objetoPesquisa[2] != null) {
						clienteTO.setCpf((String) objetoPesquisa[2]);
					}

					// Cnpf
					if (objetoPesquisa[3] != null) {
						clienteTO.setCnpj(((String) objetoPesquisa[3]));
					}

					clienteTO.setardocumento();
					colecaoClientesCombo.add(clienteTO);
				}
			}

			return colecaoClientesCombo;

		} catch (Exception e) {
			throw new ServiceException("erro.sistema", e);
		}

	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar um tipo de receita a partir do nome
	 * 
	 * @author Rômulo Aurélio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return EmpresaContabil
	 * */
	public EmpresaContabil pesquisarEmpresaContabil(String nome) {

		return this.repositorioCadastro.pesquisarEmpresaContabil(nome);

	}

	/**
	 * [UC011] Inserir Receita
	 * 
	 * Método responsável pesquisar os cliente
	 * 
	 * @author Rômulo Aurélio
	 * @since 07/05/2013
	 * 
	 * @return ClienteTO
	 * */
	public ClienteTO pesquisarClienteTO(String nome) {

		return this.repositorioCadastro.pesquisarClienteTO(nome);
	}

	/**
	 * [UC015] Inserir Empresa Contábil
	 * 
	 * Método responsável cadastrar um contador
	 * 
	 * @author Vivianne Sousa
	 * @since 20/05/2013
	 * */
	public void inserirEmpresaContabil(EmpresaContabilTO empresaContabilTO) {

		EmpresaContabil empresaContabil = empresaContabilTO
				.getEmpresaContabil();

		empresaContabil.getEndereco().setUltimaAlteracao(new Date());
		this.repositorioUtil.inserirOuAtualizar(empresaContabil.getEndereco());

		empresaContabil.setUltimaAlteracao(new Date());
		this.repositorioUtil.inserirOuAtualizar(empresaContabil);
	}

	/**
	 * [UC005] Inserir Usuario
	 * 
	 * Método responsável cadastrar um usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 * */
	public void inserirUsuario(UsuarioTO usuarioTO) {

		if (usuarioTO != null) {

			Usuario usuario = usuarioTO.getUsuario();

			usuario.setUltimaAlteracao(new Date());
			usuario.setIndicadorUso(new Integer(1).shortValue());
			repositorioUtil.inserirOuAtualizar(usuario);

		}

	}

	/**
	 * [UC005] Inserir Usuário
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf) {
		String mensagem = null;

		if (!Util.validacaoCPF(cpf)) {
			mensagem = "Dígito verificador do CPF não confere.";
		} else {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			Usuario usuario = (Usuario) Fachada.getInstance().pesquisar(
					Usuario.class, parametros);

			if (usuario != null) {
				mensagem = "CPF já cadastrado para o Usuário "
						+ usuario.getNome() + ".";
			}
		}

		return mensagem;
	}

	/**
	 * [UC003] Inserir Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 21/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf) {
		String mensagem = null;

		if (!Util.validacaoCPF(cpf)) {
			mensagem = "Dígito verificador do CPF não confere.";
		} else {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			Contador contador = (Contador) Fachada.getInstance().pesquisar(
					Contador.class, parametros);

			if (contador != null) {
				mensagem = "CPF já cadastrado para o Contador "
						+ contador.getNomeRazaoSocial() + ".";
			}
		}

		return mensagem;
	}

	/**
	 * [UC014] Manter Despesa
	 * 
	 * Método responsável pesquisar o CPF / CNPJ do cliente
	 * 
	 * @author Vivianne Sousa
	 * @since 25/05/2013
	 * 
	 * @return Usuario
	 * */
	public ClienteTO pesquisarDocumentoCliente(ClienteTO clienteTO) {

		Object[] objetoPesquisa = this.repositorioCadastro
				.pesquisarCpfCnpjCliente(new Integer(clienteTO.getCodigo()));

		// CPF
		if (objetoPesquisa[0] != null) {
			clienteTO.setCpf((String) objetoPesquisa[0]);
		}

		// CNPJ
		if (objetoPesquisa[1] != null) {
			clienteTO.setCnpj((String) objetoPesquisa[1]);
		}

		clienteTO.setardocumento();
		return clienteTO;
	}

	/**
	 * [UC005] Inserir Usuário
	 * 
	 * [FS0002] - Verificar existência de dados [FS004] - Verificar USUARIO
	 * existente
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public Usuario verificarLoginUsuarioExistente(String login) {
		Usuario usuario = null;

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("login", login);
		usuario = (Usuario) Fachada.getInstance().pesquisar(Usuario.class,
				parametros);

		return usuario;
	}

	/**
	 * [UC004] ManterContador
	 * 
	 * Método responsável atualizar uma receita
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 * */
	public void atualizarContador(ContadorTO contadorTO) {

		if (contadorTO != null) {

			Contador contador = contadorTO.getContador();
			contador.getEndereco().setUltimaAlteracao(new Date());
			this.repositorioUtil.inserirOuAtualizar(contador.getEndereco());

			contador.setUltimaAlteracao(new Date());
			repositorioUtil.inserirOuAtualizar(contador);
		}

	}

	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String verificarCPFValidoExistenteContador(String cpf,
			String codigoContador) {
		String mensagem = null;

		if (!Util.validacaoCPF(cpf)) {
			mensagem = "Dígito verificador do CPF não confere.";
		} else {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			Contador contador = (Contador) Fachada.getInstance().pesquisar(
					Contador.class, parametros);

			if (contador != null
					&& !contador.getCodigo().toString().equals(codigoContador)) {
				mensagem = "CPF já cadastrado para o Contador "
						+ contador.getNomeRazaoSocial() + ".";
			}
		}

		return mensagem;
	}

	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS004] - Verificar numero CRC existente
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String verificarCRCExistenteContador(String crc,
			String codigoContador) {
		String mensagem = null;

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numeroCrc", crc);
		Contador contador = (Contador) Fachada.getInstance().pesquisar(
				Contador.class, parametros);

		if (contador != null
				&& !contador.getCodigo().toString().equals(codigoContador)) {
			mensagem = "CRC já cadastrado para o Contador "
					+ contador.getNomeRazaoSocial() + ".";
		}

		return mensagem;
	}

	/**
	 * [UC002] Manter Cliente
	 * 
	 * Método responsável pesquisar a colecao de cliente
	 * 
	 * @author Vivianne Sousa
	 * @since 26/05/2013
	 */
	public Collection<ClienteTO> pesquisarColecaoClienteTO() {

		Collection<ClienteTO> colecaoClienteTO = null;

		Collection<Cliente> colecaoCliente = (Collection<Cliente>) this.repositorioUtil
				.pesquisar(Cliente.class);

		if (colecaoCliente != null && !colecaoCliente.isEmpty()) {

			Iterator<Cliente> iterCliente = colecaoCliente.iterator();

			while (iterCliente.hasNext()) {
				Cliente cliente = (Cliente) iterCliente.next();

				ClienteTO clienteTO = new ClienteTO(cliente);

				if (cliente.getIndicadorPessoaFisica().equals(
						Cliente.INDICADOR_PESSOA_FISICA)) {

					ClientePessoaFisica clientePessoaFisica = (ClientePessoaFisica) this.repositorioUtil
							.pesquisar(ClientePessoaFisica.class,
									cliente.getCodigo());

					ClientePessoaFisicaTO clientePessoaFisicaTO = new ClientePessoaFisicaTO(
							clientePessoaFisica);

					clienteTO.setClientePessoaFisicaTO(clientePessoaFisicaTO);

				} else {

					ClientePessoaJuridica clientePessoaJuridica = (ClientePessoaJuridica) this.repositorioUtil
							.pesquisar(ClientePessoaJuridica.class,
									cliente.getCodigo());

					ClientePessoaJuridicaTO clientePessoaJuridicaTO = new ClientePessoaJuridicaTO(
							clientePessoaJuridica);

					clienteTO
							.setClientePessoaJuridicaTO(clientePessoaJuridicaTO);

				}
				clienteTO.setardocumento();
				colecaoClienteTO.add(clienteTO);
			}

		}

		return colecaoClienteTO;

	}

	/**
	 * [UC006] ManterUsuario
	 * 
	 * Método responsável atualizar uma usuario
	 * 
	 * @author Rômulo Aurélio
	 * @since 27/05/2013
	 * */
	public void atualizarUsuario(UsuarioTO usuarioTO) {

		if (usuarioTO != null) {

			Usuario usuario = usuarioTO.getUsuario();

			usuario.setUltimaAlteracao(new Date());
			repositorioUtil.inserirOuAtualizar(usuario);
		}

	}

	/**
	 * [UC006] Manter Usuario
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 27/05/2013
	 */
	public String verificarCPFValidoExistenteUsuario(String cpf,
			String codigoUsuario) {

		String mensagem = null;

		if (!Util.validacaoCPF(cpf)) {
			mensagem = "Dígito verificador do CPF não confere.";
		} else {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("numeroCpf", cpf);
			Usuario usuario = (Usuario) Fachada.getInstance().pesquisar(
					Usuario.class, parametros);

			if (usuario != null
					&& !usuario.getCodigo().toString().equals(codigoUsuario)) {
				mensagem = "CPF já cadastrado para o Usuário "
						+ usuario.getNome() + ".";
			}
		}

		return mensagem;
	}

	/**
	 * [UC004] Manter Contador
	 * 
	 * [FS0002] - Verificar existência de dados [FS003] - Verificar CPF inválido
	 * 
	 * @author Rômulo Aurélio
	 * @since 25/05/2013
	 */
	public String validaIndicadorResponsavel(String indicadorResponsavel,
			String codigoContador) {
		
		String mensagem = null;

		if (indicadorResponsavel.equals("1")) {

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("indicadorResponsavel", 1);
			Contador contador = (Contador) Fachada.getInstance().pesquisar(
					Contador.class, parametros);

			if (contador != null && codigoContador != null
					&& !contador.getCodigo().toString().equals(codigoContador)) {
				mensagem = "Contador " + contador.getNomeRazaoSocial()
						+ " já cadastrado como responsável.";
			} else if (contador != null) {
				mensagem = "Contador " + contador.getNomeRazaoSocial()
						+ " já cadastrado como responsável.";
			}

		}
		return mensagem;
	}
}
