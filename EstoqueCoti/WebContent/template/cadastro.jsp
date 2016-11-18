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
				<li class="active"><a data-toggle="tab" href="#home">Materiais</a></li>
				<li class=""><a data-toggle="tab" href="#categoria">Categoria</a></li>
				<li class=""><a data-toggle="tab" href="#profile">Profile</a></li>
				<li class=""><a data-toggle="tab" href="#contact">Contact</a></li>
			</ul>
		</header>
		<div class="panel-body">
			<div class="tab-content">
				<div id="home" class="tab-pane active">
					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info" href="#DialogIncluirMaterial"
								data-toggle="modal"> Novo Material </a>
							<div id="DialogIncluirMaterial" class="modal fade"
								aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
								tabindex="-1" style="display: none;">
								<div class="modal-dialog" style="width: 800px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title">Cadastro de Materiais</h4>
										</div>
										<div class="modal-body" style="min-height: 500px;">

											<form action="cadastrar.html" method="post">

												<div class="form-group"
													style="width: 80px; float: left; margin-top: 0%">
													<label for="codigo">Código</label> <input name="codigo"
														class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 300px; float: left; margin-top: 9%; margin-left: -10.5%">
													<label for="nome">Nome</label> <input name="nome"
														class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 430px; float: left; margin-left: 2%; margin-top: 9%;">
													<label for="descricao">Descrição</label>
													<textarea name="descricao" class="form-control" type="text"></textarea>
												</div>
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 0%; margin-top: 0%">
													<label for="unimed">Unidade de Medida</label> <input
														name="unimed" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 155px; float: left; margin-left: 2%; margin-top: 0%">
													<label for="preco">Preço</label> <input name="preco"
														class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 430px; float: left; margin-left: 2%; margin-top: 0%">
													<label for="fornecedor">Fornecedor</label> <input
														name="fornecedor" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 85px; float: left; margin-left: 0%;">
													<label for="qtdMin">Qtd. Mínima</label> <input
														name="qtd_Min" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 85px; float: left; margin-left: 2%;">
													<label for="qtdMax">Qtd. Máxima</label> <input
														name="qtd_Max" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 85px; float: left; margin-left: 2%;">
													<label for="estoque">Estoque</label> <input name="estoque"
														class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 130px; float: left; margin-left: -38%; margin-top: 10%;">
													<label for="categoria">Categoria</label> <select
														name="categoria" class="form-control" type="text"
														onchange='CheckCatCadMat(this.value);'>
														<option selected disabled hidden>Categoria</option>
														<c:forEach items="${cBean.listarCategoria}" var="cat">
															<option value="${cat.categoria }">${cat.categoria }</option>



														</c:forEach>
													</select>
												</div>
												<div class="form-group"
													style="width: 130px; float: left; margin-left: -19%; display: none; margin-top: 10%"
													id="outrosCadMat">
													<label for="catOutros">Outros</label> <input
														name="catOutrosNome" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 300px; float: left; margin-left: 0%; display: none; margin-top: 10%"
													id="outrosCadDescMat">
													<label for="descricao">Descrição da Categoria</label>
													<textarea name="descricao" class="form-control" type="text"
														name="catOutrosDescricao"></textarea>

												</div>

												<div
													style="width: 30px; margin-top: 25%; float: right; margin-right: 8%">
													<button class="btn btn-primary" type="submit">Cadastar</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
					<form action="buscar.html" method="post">


						<div class="col-lg-2">
							<select name="selectPesquisaMat" class="form-control">
								<option value="codigo">Código</option>
								<option value="nome">Nome</option>
								<option value="medida">Medida</option>
								<option value="fornecedor">Fornecedor</option>
								<option value="categoria">Categoria</option>

							</select>
						</div>
						<div class="col-lg-2">
							<input type="text" class="form-control" name="campoPesquisaMat">
						</div>
						<span class="input-group-btn ">
							<button class="btn btn-default" type="submit"
								style="margin-right: 100px">
								<i class="fa fa-search"></i>
							</button>
						</span>

					</form>




					<c:if test="${fn:length(lista) > 0 }">
						<br>
						<table class="table table-hover">
							<tr>

								<th>Código</th>
								<th>Nome</th>
								<th>Descrição</th>
								<th>Medida</th>
								<th>Fornecedor</th>
								<th>Quantidade Mínima</th>
								<th>Quantidade Máxima</th>
								<th>Estoque</th>
								<th>Categoria</th>
								<th>Preço</th>
								<th></th>
							</tr>
							<c:forEach items="${lista }" var="mat">
								<tr>

									<td id="codigo${mat.id_material}">${mat.codigo }</td>
									<td id="nome${mat.id_material}">${mat.nome }</td>
									<td id="descricao${mat.id_material}">${mat.descricao }</td>
									<td id="medida${mat.id_material}">${mat.medida }</td>
									<td id="fornecedor${mat.id_material}">${mat.fornecedor }</td>
									<td id="qtd_Min${mat.id_material}">${mat.qtd_Min }</td>
									<td id="qtd_Max${mat.id_material}">${mat.qtd_Max }</td>
									<td id="estoque${mat.id_material}">${mat.estoque }</td>
									<td id="categoria${mat.id_material}">${mat.categoria.categoria }</td>
									<td id="preco${mat.id_material}">${mat.preco }</td>
									<td><a href="#DialogAlterarMaterial"
										class="btn btn-xs btn-info alterar" data-toggle="modal"
										data-id="${mat.id_material}">Alterar</a> <a
										href="remover.html?id_material=${mat.id_material }"
										class="btn btn-xs btn-danger"
										onclick="return confirm('Tem certeza que deseja remover este item? Após a remoção não terá como recupera-lo')">Remover</a>
									</td>
								</tr>
							</c:forEach>
						</table>

					</c:if>



					<!--  ----------------------------------------------Painel para Alteração---------------------------------------------------------------------------- -->

					<div id="DialogAlterarMaterial" class="modal fade"
						aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
						tabindex="-1" style="display: none;">

						<div class="modal-dialog" style="width: 800px;">
							<div class="modal-content">

								<div class="modal-header">
									<button class="close" aria-hidden="true" data-dismiss="modal"
										type="button">×</button>
									<h4 class="modal-title">Cadastro de Materiais</h4>
								</div>
								<div class="modal-body" style="min-height: 500px;">

									<form action="alterar.html" method="post">
										<div class="form-group"
											style="width: 80px; float: left; margin-top: 0%">
											<label for="codigo">Código</label> <input name="codigo"
												class="form-control" type="text" id="mcodigo"> <input
												name="id" type="hidden" id="mid">
										</div>
										<div class="form-group"
											style="width: 300px; float: left; margin-top: 9%; margin-left: -10.5%">
											<label for="nome">Nome</label> <input name="nome"
												class="form-control" type="text" id="mnome">
										</div>
										<div class="form-group"
											style="width: 430px; float: left; margin-left: 2%; margin-top: 9%;">
											<label for="descricao">Descrição</label>
											<textarea name="descricao" class="form-control" type="text"
												id="mdescricao"></textarea>
										</div>
										<div class="form-group"
											style="width: 130px; float: left; margin-left: 0%; margin-top: 0%">
											<label for="unimed">Unidade de Medida</label> <input
												name="unimed" class="form-control" type="text" id="mmedida">
										</div>
										<div class="form-group"
											style="width: 155px; float: left; margin-left: 2%; margin-top: 0%">
											<label for="preco">Preço</label> <input name="preco"
												class="form-control" type="text" id="mpreco">
										</div>
										<div class="form-group"
											style="width: 430px; float: left; margin-left: 2%; margin-top: 0%">
											<label for="fornecedor">Fornecedor</label> <input
												name="fornecedor" class="form-control" type="text"
												id="mfornecedor">
										</div>
										<div class="form-group"
											style="width: 85px; float: left; margin-left: 0%;">
											<label for="qtdMin">Qtd. Mínima</label> <input name="qtd_Min"
												class="form-control" type="text" id="mqtd_Min">
										</div>
										<div class="form-group"
											style="width: 85px; float: left; margin-left: 2%;">
											<label for="qtdMax">Qtd. Máxima</label> <input name="qtd_Max"
												class="form-control" type="text" id="mqtd_Max">
										</div>
										<div class="form-group"
											style="width: 85px; float: left; margin-left: 2%;">
											<label for="estoque">Estoque</label> <input name="estoque"
												class="form-control" type="text" id="mestoque">
										</div>
										<div class="form-group"
											style="width: 130px; float: left; margin-left: -38%; margin-top: 10%;">
											<label for="categoria">Categoria</label> <select
												name="categoria" class="form-control" type="text"
												onchange='CheckCatAltMat(this.value);'>

												<c:forEach items="${cBean.listarCategoria}" var="cat">
													<option selected disabled hidden id="mcategoria"
														value="mcategoria">${cat.categoria }</option>
													<option value="${cat.categoria }">${cat.categoria }</option>



												</c:forEach>
											</select>
										</div>
										<div class="form-group"
											style="width: 130px; float: left; margin-left: -19%; display: none; margin-top: 10%"
											id="outrosAltMat">
											<label for="catOutros">Outros</label> <input
												name="catOutrosNomeAlt" class="form-control" type="text">
										</div>
										<div class="form-group"
											style="width: 300px; float: left; margin-left: 0%; display: none; margin-top: 10%"
											id="outrosAlrDescMat">
											<label for="descricao">Descrição da Categoria</label>
											<textarea name="descricao" class="form-control" type="text"
												name="catOutrosDescricaoAlt"></textarea>

										</div>

										<div
											style="width: 30px; margin-top: 25%; float: right; margin-right: 8%">
											<button class="btn btn-primary" type="submit">Alterar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>




					<!--  --------------------------------------------Fim do Painel para Alteração---------------------------------------------------------------------------- -->

				</div>
				
<!-- -------------------------------------------Início da Tab Categoria ---------------------------------------------------- -->				
				<div id="categoria" class="tab-pane">

					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info" href="#incluirCategoria"
								data-toggle="modal"> Nova Categoria </a>
							<div id="incluirCategoria" class="modal fade"
								aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
								tabindex="-1" style="display: none;">
								<div class="modal-dialog" style="width: 600px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title">Cadastro de Categorias</h4>
										</div>
										<div class="modal-body" style="min-height: 350px;">

											<form action="cadastrocat.html" method="post">
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 0%; display: block; margin-top: 0%"
													id="outrosCadMat">
													<label for="catOutros">Nome da Categoria</label> <input
														name="cadNomeCat" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 300px; float: left; margin-left: -23%; display: block; margin-top: 13%"
													id="outrosCadDescMat">
													<label for="descricao">Descrição da Categoria</label>
													<textarea class="form-control" type="text"
														name="cadDescCat" style="width: 523px; height: 167px;"></textarea>

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

<!-- -------------------------------------------------Final da Tab Categoria------------------------------------------------ -->




				</div>
				<div id="profile" class="tab-pane">Fornecedor</div>
				<div id="contact" class="tab-pane">Contact</div>
			</div>
		</div>
	</section>

</div>
<!--tab nav start-->
<!-- /.content -->
${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
