<jsp:include page="template/superiorContent.jsp"></jsp:include>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
					<form action="buscar.html" method="post">
					
							<div class="col-lg-2">
							<select class="form-control">
					<option>Teste</option>
					</select>
					</div>
					<div class="col-lg-2">
							<input type="text" class="form-control" name="pesquisarMateriais"> 
							</div>
							<span class="input-group-btn " >
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
								<td>${mat.qtdMin }</td>
								<td>${mat.qtdMax }</td>
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

<jsp:include page="template/inferiorContent"></jsp:include>
