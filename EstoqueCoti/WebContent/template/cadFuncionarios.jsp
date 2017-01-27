<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:include page="template/superiorContent.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="FBean" class="control.ControleMateriais"></jsp:useBean>
<jsp:useBean id="Fcontrole" class="control.ControleFuncionario"></jsp:useBean>
<jsp:useBean id="Fclass" class="model.Funcionario"></jsp:useBean>
<%@ page import="model.Funcionario"%>
<%@ page import="persistence.FuncionarioDao"%>
<%@ page import="control.ControleFuncionario"%>
<!-- Main content -->

<!--tab nav start-->
<div class="col-lg-12" style="margin-top: 50px">
	<section class="panel general">
		<header class="panel-heading tab-bg-dark-navy-blue">
			<ul class="nav nav-tabs">

				<li class="active"><a data-toggle="tab" href="#Funcionario">Funcionario</a></li>
				<li class=""><a data-toggle="tab" href="#profile">texto</a></li>
				<li class=""><a data-toggle="tab" href="#contact">Contact</a></li>
			</ul>
		</header>
		<div class="panel-body">
			<div class="tab-content">



				<!-- -------------------------------------------Início da Tab Funcionario ---------------------------------------------------- -->
				<div id="Funcionario" class="tab-pane active">

					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info" href="#incluirFuncionario"
								data-toggle="modal"> Novo Funcionario </a>
							<div id="incluirFuncionario" class="modal fade" aria-hidden="true"
								aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
								style="display: none;">
								<div class="modal-dialog" style="width: 800px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title">Cadastro de Funcionario</h4>
										</div>
										<div class="modal-body" style="min-height: 400px;">

											<form action="cadastroFuncionario.html" method="post">
												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="nomeFuncionario">Nome do Funcionário</label> <input
														name="nomeFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="perfilDoFuncionario">Perfil</label> <input
														name="perfilDoFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="telFuncionario">Telefone</label> <input
														name="telFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 182px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="cepFuncionario">CEP</label> <input
														name="cepFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 330px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="endFuncionario">Endereço</label> <input
														name="endFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="numEndFuncionario">Número</label> <input
														name="numEndFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 230px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="bairroFuncionario">Bairro</label> <input
														name="bairroFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="cidadeFuncionario">Cidade</label> <input
														name="cidadeFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 80px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="estadoFuncionario">Estado</label> <input
														name="estadoFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 200px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="emailFuncionario">E-mail</label> <input
														name="emailFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 162px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="cargoDoFuncionario">Cargo</label> <input
														name="cargoDoFuncionario" class="form-control"
														type="text">

												</div>

												<div class="form-group"
													style="width: 200px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="salarioDoFuncionario">Salario</label> <input
														name="salarioDoFuncionario" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="setordoFuncionario">Setor</label> <input
														name="setordoFuncionario" class="form-control"
														type="text">

												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="identidadedoFuncionario">Identidade</label> <input
														name="identidadedoFuncionario" class="form-control"
														type="text">

												</div>


												<div
													style="width: 30px; margin-top: 12%; float: right; margin-right: 8%">
													<button class="btn btn-primary" type="submit">Cadastar</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>

					<form action="buscaFuncionario.html" method="post">


						<div class="col-lg-2">
							<select name="selectPesquisaForn" class="form-control" id="pesqForn">
								<option hidden="hidden" selected="selected">Pesquisar Por?</option>
								<option value="todos" id="todos">Todos</option>
								<option value="nome" id="nome">Nome</option>
								<option value="perfil" id="perfil">Perfil</option>
								<option value="identidade" id="identidade">Identidade</option>
								

							</select>
						</div>
						<div class="col-lg-2">
							<input type="text" class="form-control" name="campoPesquisaForn" id="inputPesqForn" disabled="disabled">
						</div>
						<span class="input-group-btn ">
							<button class="btn btn-default" type="submit"
								style="margin-right: 100px" id="btnPesquisarPagInicial" disabled="disabled">
								<i class="fa fa-search"></i>
							</button>
						</span>

					</form>

					<c:if test="${fn:length(listaFuncionarios) > 0 }">

						<br>
						<table class="table table-hover">
							<tr>
								<th>Nome</th>
								<th>Perfil</th>
								<th>Telefone</th>
								<th>Endereço</th>
								<th>Nº</th>
								<th>Cep</th>
								<th>Bairro</th>
								<th>Cidade</th>
								<th>Estado</th>
								<th>E-mail</th>
								<th>Salário</th>
								<th>Setor</th>
								<th>Cargo</th>
								<th>Identidade</th>
								<th></th>
							</tr>



							<c:forEach items="${listaFuncionarios }" var="func">


								<tr>
									<td id="nome${func.id}">${func.nome }</td>
									<td id="perfil${func.id}">${func.perfil }</td>
									<td id="telefone${func.id}">${func.telefone }</td>
									<td id="endereco${func.id}">${func.endereco }</td>
									<td id="numero${func.id}">${func.numeroDoEndereco }</td>
									<td id="cep${func.id}">${func.cep }</td>
									<td id="bairro${func.id}">${func.bairro }</td>
									<td id="cidade${func.id}">${func.cidade }</td>
									<td id="estado${func.id}">${func.estado }</td>
									<td id="email${func.id}">${func.email }</td>
									<td id="salario${func.id}">${func.salario }</td>
									<td id="setor${func.id}">${func.setor }</td>
									<td id="cargo${func.id}">${func.cargo}</td>
									<td id="identidade${func.id}">${func.identidade}</td>
									<td><a href="#alterarFuncionario"
										class="btn btn-xs btn-info alteraFuncionario"
										data-toggle="modal" data-id="${func.id }">Alterar</a> <a
										href="excluirFuncionario.html?id=${func.id }"
										class="btn btn-xs btn-danger"
										onclick="return confirm('Tem certeza que deseja remover este item? Após a remoção não terá como recupera-lo')">Remover</a></td>
								</tr>


							</c:forEach>
						</table>
					</c:if>




					<!-- -------------------------------------------------Final cadastro Funcionario------------------------------------------------ -->







					<!-- -------------------------------------------------Início da altera Funcionario------------------------------------------------ -->

					<div id="alterarFuncionario" class="modal fade" aria-hidden="true"
						aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
						style="display: none;">
						<div class="modal-dialog" style="width: 800px;">
							<div class="modal-content">

								<div class="modal-header">
									<button class="close" aria-hidden="true" data-dismiss="modal"
										type="button">×</button>
									<h4 class="modal-title">Alterar Funcionario</h4>
								</div>
								<div class="modal-body" style="min-height: 400px;">

									<form action="alteraFuncionario.html" method="post">
										<div class="form-group"
											style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="nomeFuncionario">Nome do Funcionario</label> <input
												name="nomeFuncionario" id="funome" class="form-control" type="text">
												<input name="id" type="hidden" id="fid">
										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="perfilDoFuncionario">Perfil</label> <input
												name="perfilDoFuncionario" id="fuperfil" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="telDoFuncionario">Telefone</label> <input
												name="telDoFuncionario" id="futelefone" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 182px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="cepDoFuncionario">CEP</label> <input
												name="cepDoFuncionario" id="fucep" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 330px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="endDoFuncionario">Endereço</label> <input
												name="endDoFuncionario" id="fuendereco" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="numEndDoFuncionario">Número</label> <input
												name="numEndDoFuncionario" id="funumero" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 230px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="bairroDoFuncionario">Bairro</label> <input
												name="bairroDoFuncionario" id="fubairro" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="cidadeDoFuncionario">Cidade</label> <input
												name="cidadeDoFuncionario" id="fucidade" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 80px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="estadoDoFuncionario">Estado</label> <input
												name="estadoDoFuncionario" id="fuestado" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 200px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for=emailDoFuncionario>E-mail</label> <input
												name="emailDoFuncionario" id="fuemail" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 162px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="cargoDoFuncionario">Cargo</label> <input
												name="cargoDoFuncionario" id="fucargo" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 200px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="salarioDoFuncionario">Salário</label> <input
												name="salarioDoFuncionario" id="fusalario" class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="setorDoFuncionário">Setor</label> <input
												name="setorDoFuncionário" id="fusetor" class="form-control"
												type="text">

										</div>
										
										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="identidadeDoFuncionário">Identidade</label> <input
												name="identidadeDoFuncionário" id="fuidentidade" class="form-control"
												type="text">

										</div>


										<div
											style="width: 30px; margin-top: 12%; float: right; margin-right: 8%">
											<button class="btn btn-primary" type="submit">Alterar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>



					<!-- -------------------------------------------------Final da Tab  Funcionario------------------------------------------------ -->




				</div>
				<div id="profile" class="tab-pane">Funcionario</div>
				<div id="contact" class="tab-pane">Contact</div>
			</div>
		</div>
	</section>

</div>

${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
