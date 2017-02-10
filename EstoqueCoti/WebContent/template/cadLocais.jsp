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

				<li class="active"><a data-toggle="tab" href="#fornecedor">Fornecedor</a></li>
				<li class=""><a data-toggle="tab" href="#profile">texto</a></li>
				<li class=""><a data-toggle="tab" href="#contact">Contact</a></li>
			</ul>
		</header>
		<div class="panel-body">
			<div class="tab-content">



				<!-- -------------------------------------------Início da Tab Locais ---------------------------------------------------- -->
				<div id="fornecedor" class="tab-pane active">

					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info" href="#incluirFornecedor"
								data-toggle="modal"> Nova Localização </a>
							<div id="incluirFornecedor" class="modal fade" aria-hidden="true"
								aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
								style="display: none;">
								<div class="modal-dialog" style="width: 800px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title">Cadastro de Localização</h4>
										</div>
										<div class="modal-body" style="min-height: 650px;">

											<form action="cadastroLocal.html" method="post">
												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%"
													id="nomeNovoLocal">
													<label for="nomeDoNovoLocal">Nome do Local </label> <input
														name="nomeDoNovoLocal" class="form-control" type="text">
													<div class="checkbox">
														<label> <input name="localExistente" type="hidden"
															id="checkLocal" /> <!-- Local Existente -->

														</label>
													</div>
												</div>



												<!--  	<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: none; margin-top: 0%"
													id="nomeLocalExistente">
													<label for="nomeDoLocalExistente">Nome do Local222
													</label> <input name="nomeDoLocalExistente" class="form-control"
														type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="checkbox" id="checkLocal1" /> Local Existente

														</label>
													</div>
												</div>
												-->





												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="codDoLocal">Código</label> <input
														name="codDoLocal" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="descDoLocal">Descrição do Local</label>
													<textarea name="descDoLocal" class="form-control; "
														style="width: 345px; height: 146px; resize: none"></textarea>

												</div>

												<div class="form-group"
													style="width: 230px; float: left; margin-left: -69%; display: block; margin-top: 25%"
													id="nomeNovoCorredor">
													<label for="nomeDoNovoCorredor">Corredor</label> <input
														name="nomeDoNovoCorredor" class="form-control" type="text">
													<div class="checkbox">
														<label> <input name="localExistente" type="hidden"
															id="checkCorredor" /> <!-- Corredor Existente -->

														</label>
													</div>

												</div>

												<!--  	<div class="form-group"
													style="width: 230px; float: left; margin-left: -69%; display: none; margin-top: 25%"
													id="nomeCorredorExistente">
													<label for="nomeDoCorredorExistente">Corredor222</label> <input
														name="nomeDoCorredorExistente" class="form-control"
														type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="checkbox" id="checkCorredor1" /> Corredor
															Existente

														</label>
													</div>

												</div> -->

												<div class="form-group"
													style="width: 130px; float: left; margin-left: -36%; display: block; margin-top: 25%">
													<label for="codDoCorredor">Código</label> <input
														name="codDoCorredor" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 150px; float: left; margin-left: -17%; display: block; margin-top: 25%">
													<label for="descDoCorredor">Descrição do Corredor</label>
													<textarea name="descDoCorredor" class="form-control"
														style="width: 345px; height: 146px; resize: none"></textarea>

												</div>

												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%"
													id="nomeNovaPrateleira">
													<label for="nomeDaNovaPrateleira">Prateleira</label> <input
														name="nomeDaNovaPrateleira" class="form-control"
														type="text">
													<div class="checkbox">
														<label> <input name="localExistente" type="hidden"
															id="checkPrateleira" /> <!--  Prateleira
															Existente -->

														</label>
													</div>

												</div>

												<!--  		<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: none; margin-top: 0%"
													id="nomePrateleiraExistente">
													<label for="nomeDaPrateleiraExistente">Prateleira222</label>
													<input name="nomeDaPrateleiraExistente"
														class="form-control" type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="checkbox" id="checkPrateleira1" /> Prateleira
															Existente

														</label>
													</div>

												</div> -->


												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="codDaPrateleira">Código</label> <input
														name="codDaPrateleira" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 150px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="descDaPrateleira">Descrição da
														Prateleira</label>
													<textarea name="descDaPrateleira" class="form-control"
														style="width: 345px; height: 146px; resize: none"></textarea>

												</div>



												<div
													style="width: 30px; margin-top: 26%; float: right; margin-right: 18%">
													<button class="btn btn-primary" type="submit">Cadastar</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>

					<form action="buscarLocal.html" method="post">


						<div class="col-lg-2">
							<select name="selectPesquisaForn" class="form-control"
								id="pesqForn">
								<option hidden="hidden" selected="selected">Pesquisar
									Por?</option>
								<option value="todos" id="todos">Todos</option>
								<option value="nome" id="nome">Local</option>
								<option value="codigo" id="codigo">Corredor</option>
								<option value="cnpj" id="cnpj">Prateleira</option>


							</select>
						</div>
						<div class="col-lg-2">
							<input type="text" class="form-control" name="campoPesquisaForn"
								id="inputPesqForn" disabled="disabled">
						</div>
						<span class="input-group-btn ">
							<button class="btn btn-default" type="submit"
								style="margin-right: 100px" id="btnPesquisarPagInicial"
								disabled="disabled">
								<i class="fa fa-search"></i>
							</button>
						</span>

					</form>

					<c:if test="${fn:length(listaLocal) > 0 }">

						<br>
						<table class="table table-hover">
							<tr>
								<th>Local</th>
								<th>Código</th>
								<th>Descrição</th>
								<th>Prateleira</th>
								<th>Código</th>
								<th>Descrição</th>
								<th>Prateleira</th>
								<th>Código</th>
								<th>Descrição</th>

								<th></th>
							</tr>



							<c:forEach items="${listaLocal }" var="local">


								<tr>
									<td id="local${local.lId}">${local.lNome }</td>
									<td id="lcodigo${local.lId}">${local.lCodigo }</td>
									<td id="ldescricao${local.lId}">${local.ldescricao }</td>
									<td id="corredor${local.lId}">${local.cNome }</td>
									<td id="ccodigo${local.lId}">${local.cCodigo }</td>
									<td id="cdescricao${local.lId}">${local.cDescricao }</td>
									<td id="prateleira${local.lId}">${local.pNome }</td>
									<td id="pcodigo${local.lId}">${local.pCodigo }</td>
									<td id="pdescricao${local.lId}">${local.pDescricao }</td>

									<td><a href="#alterarLocal"
										class="btn btn-xs btn-info alteraLocal" data-toggle="modal"
										data-id="${local.lId }">Alterar</a> <a
										href="excluirForn.html?id=${local.lId }"
										class="btn btn-xs btn-danger"
										onclick="return confirm('Tem certeza que deseja remover este item? Após a remoção não terá como recupera-lo')">Remover</a></td>
								</tr>


							</c:forEach>
						</table>
					</c:if>




					<!-- -------------------------------------------------Final cadastro Fornecedor------------------------------------------------ -->







					<!-- -------------------------------------------------Início da altera local------------------------------------------------ -->

					<div id="alterarLocal" class="modal fade" aria-hidden="true"
						aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
						style="display: none;">
						<div class="modal-dialog" style="width: 800px;">
							<div class="modal-content">

								<div class="modal-header">
									<button class="close" aria-hidden="true" data-dismiss="modal"
										type="button">×</button>
									<h4 class="modal-title">Alterar Fornecedor</h4>
								</div>
								<div class="modal-body" style="min-height: 650px;">

									<form action="alteraLocal.html" method="post">
										<div class="form-group"
											style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%"
											id="nomeNovoLocal">
											<label for="nomeDoNovoLocal">Nome do Local </label> <input
												name="nomeDoNovoLocal" class="form-control" type="text"
												id="flNome">
												<input name="Lid" type="hidden" id="flId">
											<div class="checkbox">
												<label> <input name="localExistente" type="hidden"
													id="checkLocal" /> <!-- Local Existente -->

												</label>
											</div>
										</div>



										<!--  	<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: none; margin-top: 0%"
													id="nomeLocalExistente">
													<label for="nomeDoLocalExistente">Nome do Local222
													</label> <input name="nomeDoLocalExistente" class="form-control"
														type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="checkbox" id="checkLocal1" /> Local Existente

														</label>
													</div>
												</div>
												-->





										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="codDoLocal">Código</label> <input
												name="codDoLocal" class="form-control" type="text"
												id="flCodigo">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="descDoLocal">Descrição do Local</label>
											<textarea name="descDoLocal" class="form-control; "
												style="width: 345px; height: 146px; resize: none"
												id="fldescricao"></textarea>

										</div>

										<div class="form-group"
											style="width: 230px; float: left; margin-left: -69%; display: block; margin-top: 25%"
											id="nomeNovoCorredor">
											<label for="nomeDoNovoCorredor">Corredor</label> <input
												name="nomeDoNovoCorredor" class="form-control" type="text"
												id="fcNome">
											<div class="checkbox">
												<label> <input name="localExistente" type="hidden"
													id="checkCorredor" /> <!-- Corredor Existente -->

												</label>
											</div>

										</div>

										<!--  	<div class="form-group"
													style="width: 230px; float: left; margin-left: -69%; display: none; margin-top: 25%"
													id="nomeCorredorExistente">
													<label for="nomeDoCorredorExistente">Corredor222</label> <input
														name="nomeDoCorredorExistente" class="form-control"
														type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="checkbox" id="checkCorredor1" /> Corredor
															Existente

														</label>
													</div>

												</div> -->

										<div class="form-group"
											style="width: 130px; float: left; margin-left: -36%; display: block; margin-top: 25%">
											<label for="codDoCorredor">Código</label> <input
												name="codDoCorredor" class="form-control" type="text"
												id="fcCodigo">

										</div>

										<div class="form-group"
											style="width: 150px; float: left; margin-left: -17%; display: block; margin-top: 25%">
											<label for="descDoCorredor">Descrição do Corredor</label>
											<textarea name="descDoCorredor" class="form-control"
												style="width: 345px; height: 146px; resize: none"
												id="fcDescricao"></textarea>

										</div>

										<div class="form-group"
											style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%"
											id="nomeNovaPrateleira">
											<label for="nomeDaNovaPrateleira">Prateleira</label> <input
												name="nomeDaNovaPrateleira" class="form-control" type="text"
												id="fpNome">
											<div class="checkbox">
												<label> <input name="localExistente" type="hidden"
													id="checkPrateleira" /> <!--  Prateleira
															Existente -->

												</label>
											</div>

										</div>

										<!--  		<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: none; margin-top: 0%"
													id="nomePrateleiraExistente">
													<label for="nomeDaPrateleiraExistente">Prateleira222</label>
													<input name="nomeDaPrateleiraExistente"
														class="form-control" type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="checkbox" id="checkPrateleira1" /> Prateleira
															Existente

														</label>
													</div>

												</div> -->


										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="codDaPrateleira">Código</label> <input
												name="codDaPrateleira" class="form-control" type="text"
												id="fpCodigo">

										</div>

										<div class="form-group"
											style="width: 150px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="descDaPrateleira">Descrição da Prateleira</label>
											<textarea name="descDaPrateleira" class="form-control"
												style="width: 345px; height: 146px; resize: none"
												id="fpDescricao"></textarea>

										</div>



										<div
											style="width: 30px; margin-top: 26%; float: right; margin-right: 14%">
											<button class="btn btn-primary" type="submit">Alterar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>


					<!-- -------------------------------------------------Final da Tab altera local------------------------------------------------ -->




				</div>
				<div id="profile" class="tab-pane">Fornecedor</div>
				<div id="contact" class="tab-pane">Contact</div>
			</div>
		</div>
	</section>

</div>

${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
