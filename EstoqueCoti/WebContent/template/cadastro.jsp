<jsp:include page="template/superiorContent.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:useBean id="mBean" class="control.PopularSelect"></jsp:useBean>
<!-- Main content -->

<!--tab nav start-->
<div class="col-lg-12" style="margin-top: 50px">
	<section class="panel general">
		<header class="panel-heading tab-bg-dark-navy-blue">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
				<li class=""><a data-toggle="tab" href="#about">About</a></li>
				<li class=""><a data-toggle="tab" href="#profile">Profile</a></li>
				<li class=""><a data-toggle="tab" href="#contact">Contact</a></li>
			</ul>
		</header>
		<div class="panel-body">
			<div class="tab-content">
				<div id="home" class="tab-pane active">
					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info"
								href="#DialogIncluirAlterarMaterial" data-toggle="modal">
								Novo Material </a>
							<div id="DialogIncluirAlterarMaterial" class="modal fade"
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

												<div class="form-group" style="width: 80px; float: left;margin-top: 0%">
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
													<label for="descricao">Descrição</label> <input
														name="descricao" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 0%; margin-top: 0%">
													<label for="unimed">Unidade de Medida</label> <input
														name="unimed" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 155px; float: left; margin-left: 2%;margin-top: 0%">
													<label for="preco">Preço</label> <input name="preco"
														class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 430px; float: left; margin-left: 2%;margin-top: 0%">
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
													<label for="estoque">Estoque</label> <input
														name="estoque" class="form-control" type="text">
												</div>
												<div class="form-group"
													style="width: 130px; float: left; margin-left: -38%;margin-top: 10%;">
													<label for="categoria">Categoria</label> <select
														name="categoria" class="form-control" type="text" onchange='CheckColors(this.value);'>
														<c:forEach items="${mBean.listarCategoria}" var="cat">
														<option  value="${cat }">${cat }</option>
														
														
														
														</c:forEach>
													</select>
												</div>
												<div class="form-group"
													style="width: 130px; float: left; margin-left: -19%;display: none; margin-top: 10%" id="outros">
													<label for="catOutros">Outros</label> <input name="catOutros"
														class="form-control" type="text" >
												</div>

												<div style="width: 30px; margin-top: 25%;float: right;margin-right: 8%">
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
							<select class="form-control">
								<option>Código</option>
								<option>Nome</option>
								<option>Medida</option>
								<option>Fornecedor</option>
								<option>Categoria</option>

							</select>
						</div>
						<div class="col-lg-2">
							<input type="text" class="form-control" name="pesquisarMateriais">
						</div>
						<span class="input-group-btn ">
							<button class="btn btn-default" type="submit"
								style="margin-right: 100px">
								<i class="fa fa-search"></i>
							</button>
						</span>

					</form>




					<c:if test="${fn:length(lista) > 0 }">
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
							</tr>
							<c:forEach items="${lista }" var="mat">
								<tr>
									<td>${mat.codigo }</td>
									<td>${mat.nome }</td>
									<td>${mat.descricao }</td>
									<td>${mat.medida }</td>
									<td>${mat.fornecedor }</td>
									<td>${mat.qtd_Min }</td>
									<td>${mat.qtd_Max }</td>
									<td>${mat.estoque }</td>
									<td>${mat.categoria }</td>
									<td>${mat.preco }</td>
								</tr>
							</c:forEach>
						</table>

					</c:if>
				</div>
				<div id="about" class="tab-pane">About</div>
				<div id="profile" class="tab-pane">Profile</div>
				<div id="contact" class="tab-pane">Contact</div>
			</div>
		</div>
	</section>
	
</div>
<!--tab nav start-->
<!-- /.content -->
${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
