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



				<!-- -------------------------------------------In�cio da Tab Locais ---------------------------------------------------- -->
				<div id="fornecedor" class="tab-pane active">

					<section class="panel">
						<div class="panel-body">
							<a class="btn btn-xs btn-info" href="#incluirFornecedor"
								data-toggle="modal"> Nova Localiza��o </a>
							<div id="incluirFornecedor" class="modal fade" aria-hidden="true"
								aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
								style="display: none;">
								<div class="modal-dialog" style="width: 800px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">�</button>
											<h4 class="modal-title">Cadastro de Localiza��o</h4>
										</div>
										<div class="modal-body" style="min-height: 650px;">

											<form action="cadastroLocal.html" method="post">
												<div class="form-group"
													style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%"
													id="nomeNovoLocal">
													<label for="nomeDoNovoLocal">Nome do Local </label> <input
														name="nomeDoNovoLocal" class="form-control" type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="hidden" id="checkLocal" /> Local Existente

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
													<label for="codDoLocal">C�digo</label> <input
														name="codDoLocal" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="descDoLocal">Descri��o do Local</label>
													<textarea name="descDoLocal" class="form-control; "
														style="width: 345px; height: 146px; resize: none"></textarea>

												</div>

												<div class="form-group"
													style="width: 230px; float: left; margin-left: -69%; display: block; margin-top: 25%"
													id="nomeNovoCorredor">
													<label for="nomeDoNovoCorredor">Corredor</label> <input
														name="nomeDoNovoCorredor" class="form-control" type="text">
													<div class="checkbox">
														<label> <input name="localExistente"
															type="hidden" id="checkCorredor" /> Corredor Existente

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
													<label for="codDoCorredor">C�digo</label> <input
														name="codDoCorredor" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 150px; float: left; margin-left: -17%; display: block; margin-top: 25%">
													<label for="descDoCorredor">Descri��o do Corredor</label>
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
														<label> <input name="localExistente"
															type="hidden" id="checkPrateleira" /> Prateleira
															Existente

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
													<label for="codDaPrateleira">C�digo</label> <input
														name="codDaPrateleira" class="form-control" type="text">

												</div>

												<div class="form-group"
													style="width: 150px; float: left; margin-left: 2%; display: block; margin-top: 0%">
													<label for="descDaPrateleira">Descri��o da
														Prateleira</label>
													<textarea name="descDaPrateleira" class="form-control"
														style="width: 345px; height: 146px; resize: none"></textarea>

												</div>



												<div
													style="width: 30px; margin-top: 26%; float: right; margin-right: 18%">
													<button class="btn btn-primary" type="submit">Cadastar
														/ Alterar</button>
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
								id="pesqForn" >
								<option hidden="hidden" selected="selected">Pesquisar
									Por?</option>
								<option value="todos" id="todos">Todos</option>
								<option value="nome" id="nome">Local</option>
								<option value="codigo" id="codigo">Corredor</option>
								<option value="cnpj" id="cnpj">Prateleira</option>


							</select>
						</div>
						<div class="col-lg-2" >
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
								<th>C�digo</th>
								<th>Descri��o</th>
								<th>Prateleira</th>
								<th>C�digo</th>
								<th>Descri��o</th>
								<th>Prateleira</th>
								<th>C�digo</th>
								<th>Descri��o</th>
								
								<th></th>
							</tr>



							<c:forEach items="${listaLocal }" var="local">


								<tr>
									<td id="local${local.lId}">${local.nome }</td>
									<td id="lcodigo${local.lId}">${local.codigo }</td>
									<td id="ldescricao${local.lId}">${local.telefone }</td>
									<td id="corredor${local.lId}">${local.endereco }</td>
									<td id="ccodigo${local.lId}">${local.numeroDoEndereco }</td>
									<td id="cdescricao${local.lId}">${local.cep }</td>
									<td id="prateleira${local.lId}">${local.bairro }</td>
									<td id="pcodigo${local.lId}">${local.cidade }</td>
									<td id="pdescricao${local.lId}">${local.estado }</td>
									
									<td><a href="#alterarLocal"
										class="btn btn-xs btn-info alteraLocal"
										data-toggle="modal" data-id="${local.lId }">Alterar</a> <a
										href="excluirForn.html?id=${local.lId }"
										class="btn btn-xs btn-danger"
										onclick="return confirm('Tem certeza que deseja remover este item? Ap�s a remo��o n�o ter� como recupera-lo')">Remover</a></td>
								</tr>


							</c:forEach>
						</table>
					</c:if>

 


					<!-- -------------------------------------------------Final cadastro Fornecedor------------------------------------------------ -->







					<!-- -------------------------------------------------In�cio da altera fornecedor------------------------------------------------ -->

					<!--  	<div id="alterarFornecedor" class="modal fade" aria-hidden="true"
						aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
						style="display: none;">
						<div class="modal-dialog" style="width: 800px;">
							<div class="modal-content">

								<div class="modal-header">
									<button class="close" aria-hidden="true" data-dismiss="modal"
										type="button">�</button>
									<h4 class="modal-title">Alterar Fornecedor</h4>
								</div>
								<div class="modal-body" style="min-height: 400px;">

									<form action="alteraFornecedor.html" method="post">
										<div class="form-group"
											style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="nomeFornecedor">Nome do Fornecedor</label> <input
												name="nomeFornecedor" id="fnome" class="form-control"
												type="text"> <input name="id" type="hidden" id="fid">
										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="codFornecedor">C�digo</label> <input
												name="codFornecedor" id="fcodigo" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="telFornecedor">Telefone</label> <input
												name="telFornecedor" id="ftelefone" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 182px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="cepFornecedor">CEP</label> <input
												name="cepFornecedor" id="fcep" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 330px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="endFornecedor">Endere�o</label> <input
												name="endFornecedor" id="fendereco" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="numEndFornecedor">N�mero</label> <input
												name="numEndFornecedor" id="fnumero" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 230px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="bairroFornecedor">Bairro</label> <input
												name="bairroFornecedor" id="fbairro" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 230px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="cidadeFornecedor">Cidade</label> <input
												name="cidadeFornecedor" id="fcidade" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 80px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="estadoFornecedor">Estado</label> <input
												name="estadoFornecedor" id="festado" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 200px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for=emailFornecedor>E-mail</label> <input
												name="emailFornecedor" id="femail" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 162px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="nomeDoContatoFornecedor">Nome do Contato</label>
											<input name="nomeDoContatoFornecedor" id="fnomecontato"
												class="form-control" type="text">

										</div>

										<div class="form-group"
											style="width: 200px; float: left; margin-left: 0%; display: block; margin-top: 0%">
											<label for="cnpjFornecedor">CNPJ</label> <input
												name="cnpjFornecedor" id="fcnpj" class="form-control"
												type="text">

										</div>

										<div class="form-group"
											style="width: 130px; float: left; margin-left: 2%; display: block; margin-top: 0%">
											<label for="inicioAtividadesFornecedor">In�cio das
												Atividades</label> <input name="inicioAtividadesFornecedor"
												id="finicioAtividades" class="form-control" type="text">

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
-->


					<!-- -------------------------------------------------Final da Tab  Fornecedor------------------------------------------------ -->




				</div>
				<div id="profile" class="tab-pane">Fornecedor</div>
				<div id="contact" class="tab-pane">Contact</div>
			</div>
		</div>
	</section>

</div>

${msg }
<jsp:include page="template/inferiorContent"></jsp:include>
