<jsp:include page="template/superiorContent.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="FBean" class="control.ControleMateriais"></jsp:useBean>
<!-- Main content -->

<!--tab nav start-->
<div class="col-lg-12" style="margin-top: 50px">
	<section class="panel general">
		<header class="panel-heading tab-bg-dark-navy-blue">
			<ul class="nav nav-tabs">

				<li class="active"><a data-toggle="tab" href="#categoria">Fornecedor</a></li>
				<li class=""><a data-toggle="tab" href="#profile">texto</a></li>
				<li class=""><a data-toggle="tab" href="#contact">Contact</a></li>
			</ul>
		</header>
		<div class="panel-body">
			<div class="tab-content">



				<!-- -------------------------------------------Início da Tab Categoria ---------------------------------------------------- -->
				<div id="categoria" class="tab-pane active">

					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info" href="#incluirCategoria"
								data-toggle="modal"> Novo Fornecedor </a>
							<div id="incluirCategoria" class="modal fade" aria-hidden="true"
								aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
								style="display: none;">
								<div class="modal-dialog" style="width: 800px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title">Cadastro de Fornecedores</h4>
										</div>
										<div class="modal-body" style="min-height: 400px;">

											<form action="cadastroFornecedor.html" method="post">
												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="nomeFornecedor">Nome do Fornecedor</label> <input
														name="nomeFornecedor" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="codFornecedor">Código</label> <input
														name="codFornecedor" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="telFornecedor">Telefone</label> <input
														name="telFornecedor" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 182px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="cepFornecedor">CEP</label> <input
														name="cepFornecedor" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 330px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="endFornecedor">Endereço</label> <input
														name="endFornecedor" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="numEndFornecedor">Número</label> <input
														name="numEndFornecedor" class="form-control" type="text">

												</div>
																								
												<div class="form-group"
													style="width: 230px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="bairroFornecedor">Bairro</label> <input
														name="bairroFornecedor" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="catOutros">Cidade</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 80px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="catOutros">Estado</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 200px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="catOutros">E-mail</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

												</div>
																					
												<div class="form-group"
													style="width: 162px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="catOutros">Nome do Contato</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 200px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="catOutros">CNPJ</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="catOutros">Início das Atividades</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

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

					<form action="buscaFornecedor.html" method="post">


						<div class="col-lg-2">
							<select name="selectPesquisaMat" class="form-control">

								<option value="categoria">Categoria</option>

							</select>
						</div>
						<div class="col-lg-2">
							<input type="text" class="form-control" name="campoPesquisaCat">
						</div>
						<span class="input-group-btn ">
							<button class="btn btn-default" type="submit"
								style="margin-right: 100px">
								<i class="fa fa-search"></i>
							</button>
						</span>

					</form>




					<c:if test="${fn:length(listaCat) > 0 }">
						<br>
						<table class="table table-hover">
							<tr>
								<th>Nome</th>
								<th>Descrição</th>
								<th></th>
							</tr>
							<c:forEach items="${listaCat }" var="cat">
								<tr>
									<td id="nome${cat.id_categoria}">${cat.categoria }</td>
									<td id="descricao${cat.id_categoria}">${cat.descricao }</td>
									<td><a href="#alterarCategoria"
										class="btn btn-xs btn-info alterarCat" data-toggle="modal"
										data-id="${cat.id_categoria}">Alterar</a> <a
										href="excluirCat.html?idCategoria=${cat.id_categoria }"
										class="btn btn-xs btn-danger">Remover</a></td>
								</tr>
							</c:forEach>
						</table>

					</c:if>

					<!-- -------------------------------------------------Final cadastro Categoria------------------------------------------------ -->







					<!-- -------------------------------------------------Início da altera Categoria------------------------------------------------ -->

					



					<!-- -------------------------------------------------Final da Tab  Categoria------------------------------------------------ -->




				</div>
				<div id="profile" class="tab-pane">Fornecedor</div>
				<div id="contact" class="tab-pane">Contact</div>
			</div>
		</div>
	</section>

</div>

${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
