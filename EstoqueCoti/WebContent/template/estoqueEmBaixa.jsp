<jsp:include page="template/superiorContent.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--  
<jsp:useBean id="cBean" class="control.ControleMateriais"></jsp:useBean>
<jsp:useBean id="locBean" class="persistence.LocalDao"></jsp:useBean>
<jsp:useBean id="cDaoBean" class="persistence.MateriaisDao"></jsp:useBean>
<jsp:useBean id="movBean" class="persistence.MovimentacaoDao"></jsp:useBean>
  -->
  <jsp:useBean id="movMinEst" class="control.ControleLogin"></jsp:useBean> 
  
<!-- Main content -->

<!--tab nav start-->
<div class="col-lg-12" style="margin-top: 50px">
	<section class="panel general">
		<header class="panel-heading tab-bg-dark-navy-blue">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">Entrada de Materiais</a></li>
				
			</ul>
		</header>
		<div class="panel-body">
			<div class="tab-content">
				<div id="home" class="tab-pane active">
					<section class="panel">
						<div class="panel-body">
						
				 	<form action="buscaMaterialExist.html" method="post">  

						<div class="col-lg-2">
							<select name="selectPesquisaForn" class="form-control" id="pesqForn">
								<option hidden="hidden" selected="selected">Pesquisar Por?</option>
								<option value="todos" id="todos">Todos</option>
								<option value="nome" id="nome">Nome</option>
								<option value="codigo" id="codigo">C�digo</option>
								<option value="categoria" id="categoria">Categoria</option>
								

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
					
					<c:if test="${fn:length(lista) > 0 }">

						<br>
						<table class="table table-hover">
							<tr>
								<th>Nome</th>
								<th>C�digo</th>
								<th>Categoria</th>
								
								<th></th>
							</tr>



							<c:forEach items="${lista }" var="list">


								<tr>
									<td id="nome${list.id}">${list.nome }</td>
									<td id="codigo${list.id}">${list.codigo }</td>
									<td id="categoria${list.id}">${list.categoria }</td>
									
									
									<td><a href="entradaMateriais2"
										class="btn btn-xs btn-info entradaMateriais"
										data-toggle="modal" name="codigoTeste" data-id="${list.id }" >Entrada</a>
										 
										<a href="entradaMateriais2"
										class="btn btn-xs btn-danger saidaMateriais"
										data-toggle="modal" name="codigoTeste" data-id="${list.id }" >Saida</a> 
										
										</td>
								</tr>


							</c:forEach>
						</table>
					</c:if>
						
						
						
						
						
							<div id="entradaMateriais2" class="modal fade"
								aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
								tabindex="-1" style="display: none;">
								<div class="modal-dialog" style="width: 550px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">�</button>
											<h4 class="modal-title">Entrada de Materiais</h4>
										</div>
										<div class="modal-body" style="min-height: 300px;">

										<form action="cadEntradaEstq.html" method="post"> 
					
									             <div class="form-group"
													style="width: 200px; float: left; margin-top: 0%; margin-left: 0%">
													<label for="nome">Nome</label> <input name="nome"
														class="form-control" type="text" id="fnome" disabled="disabled">
														<input name="id" type="hidden" id="fid">
														<input name="controller" type="hidden" id="controller">
												</div>			
					
												<div class="form-group"
													style="width: 80px; float: left; margin-top: 0%; margin-left: 2%">
													<label for="codigo">C�digo</label> <input name="codigo"
														class="form-control" type="text" id="fcodigo" disabled="disabled">
												</div>
																						
												<div class="form-group"
													style="width: 200px; float: left; margin-top: 0%; margin-left: 2%">
													<label for="categoria">categoria</label> <input name="categoria"
														class="form-control" type="text" id="fcategoria" disabled="disabled">
												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 0%; margin-top: 0%;">
													<label for="descricao">Qtd. de Entrada</label>
													<input name="qtdEntrada" 
														class="form-control" type="number" min="0" id="qtdEntrada">
												</div>
												
												<div class="form-group"
													style="width: 360px; float: left; margin-left: 2%; margin-top: 0%">
													<label for="local">Local</label> 
													<select name="local" class="form-control m-b-10">
												<option selected disabled hidden id="local" ></option>
												<c:forEach items="${locBean.todosOsLocais() }" var="loc">
												<option value="${loc.lNome }" > ${loc.lNome} - ${loc.cNome } - ${loc.pNome }</option>
												</c:forEach>
												</select>
												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 0%; margin-top: 0%">
													<label for="qtdEstoque">Qtd. em Estoque</label> <input name="qtdEstoque"
														class="form-control" type="number" min="0" id="qtdEstoque">
												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; margin-top: 0%">
													<label for="qtdMin">Qtd. M�nima</label> <input name="qtdMin"
														class="form-control" type="number" min="0" id="qtdMin">
												</div>
												
												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; margin-top: 0%">
													<label for="qtdMax">Qtd. M�xima</label> <input name="qtdMax"
														class="form-control" type="number" min="0" id="qtdMax">
												</div>
												
												
											
											  	<div
													style="width: 30px; margin-top: 0%; float: right; margin-right: 25%">
													<button class="btn btn-primary btnMoviment" type="submit" >Entrada de Material</button>
												</div> 
									 </form> 
											
										  	<div id="retorno" style="width: 300px; margin-top: 0%; float: right; margin-right: 0%; font-size: 20px; color: red; ">
											
											</div>
										</div>
									</div>
								</div>
							</div> 
						</div>
					</section>
					

				</div>

				
			</div>
		</div>
	</section>

</div>
<!--tab nav start-->
<!-- /.content -->
${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
