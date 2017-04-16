<jsp:include page="template/superiorContent.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="cBean" class="control.ControleMateriais"></jsp:useBean>
<!-- Main content -->

<!--tab nav start-->
<div class="col-lg-12" style="margin-top: 50px">
	<section class="panel general">
		<header class="panel-heading tab-bg-dark-navy-blue">
			<ul class="nav nav-tabs">

				<li class="active"><a data-toggle="tab" href="#categoria">Categoria</a></li>
				<li class=""><a data-toggle="tab" href="#profile">Profile</a></li>
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
								data-toggle="modal"> Nova Categoria </a>
							<div id="incluirCategoria" class="modal fade" aria-hidden="true"
								aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
								style="display: none;">
								<div class="modal-dialog" style="width: 600px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title">Cadastro de Categorias</h4>
										</div>
										<div class="modal-body" style="min-height: 350px;">

											<form action="cadastroCat.html" method="post">
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 0%; display: block; margin-top: 0%">
													<label for="catOutros">Nome da Categoria</label> <input
														name="nomeCatCadastro" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 300px; float: left; margin-left: -23%; display: block; margin-top: 13%">
													<label for="descricao">Descrição da Categoria</label>
													<textarea class="form-control" type="text"
														name="descCatCadastro"
														style="width: 523px; height: 167px;"></textarea>

												</div>

												<div
													style="width: 30px; margin-top: 50%; float: right; margin-right: 8%">
													<button class="btn btn-primary" type="submit">Cadastar</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>

					<form action="buscaCat.html" method="post">


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

					<div id="alterarCategoria" class="modal fade" aria-hidden="true"
						aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
						style="display: none;">
						<div class="modal-dialog" style="width: 600px;">
							<div class="modal-content">

								<div class="modal-header">
									<button class="close" aria-hidden="true" data-dismiss="modal"
										type="button">×</button>
									<h4 class="modal-title">Alterar Categorias</h4>
								</div>
								<div class="modal-body" style="min-height: 350px;">

									<form action="alterarCat.html" method="post">
										<div class="form-group"
											style="width: 130px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="catOutros">Nome da Categoria</label> <input
												name="nomeCategoria" class="form-control" type="text"
												id="mnome"> <input name="id" type="hidden" id="mid">

										</div>

										<div class="form-group"
											style="width: 300px; float: left; margin-left: -23%; display: block; margin-top: 13%">
											<label for="descricao">Descrição da Categoria</label>
											<textarea class="form-control" type="text"
												name="descricaoCategoria" style="width: 523px; height: 167px;"
												id="mdescricao"></textarea>

										</div>

										<div
											style="width: 30px; margin-top: 50%; float: right; margin-right: 8%">
											<button class="btn btn-primary" type="submit">Cadastar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>



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
