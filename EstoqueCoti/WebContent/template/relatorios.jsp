<jsp:include page="template/superiorContent.jsp"></jsp:include>

                <!-- Main content -->
                
            <div style="margin-top: 20px"> 
            	<section class="panel">
            	  <header class="panel-heading" style="font-size: 20px; text-align: center; font-weight: bold;" > Cadastros Disponíveis</header>
            	  	<div class="panel-body">
            	  	  <div class="row">	
             		     
            		    
            		    <a href="#RelEntradaSaida" class=" btn btn-primary btn-lg  " id="relEntrada" data-toggle="modal" style="height: 80px; padding-top: 25px; font-weight: bold; margin-left: 5px ">Relatório de Entradas </a>
            		    
            		    <a href="#RelEntradaSaida" class=" btn btn-primary btn-lg  " data-toggle="modal" style="height: 80px; padding-top: 25px; font-weight: bold; margin-left: 5px ">Relatório de Saídas </a>
            		    
            		    
            		    
            		    <a href="../ControleRelatorios" class=" btn btn-primary btn-lg " id="testes1" style="height: 80px; padding-top: 25px; font-weight: bold; margin-left: 5px ">Relatórios Materiais </a>
            		            		 
            		  </div> 
            		  
            		  <div class="row" style="margin-top: 20px">
            		  <a href="cadLocais.jsp" class=" btn btn-primary btn-lg col-md-offset-5 col-md-2 " style="height: 80px; padding-top: 25px; font-weight: bold; ">Locais </a> 
            		  </div> 
            		  
            		</div>
            	</section>
            </div>
            
              
                <!-- /.content -->
                
                <div id="RelEntradaSaida" class="modal fade"
								aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
								tabindex="-1" style="display: none;">
								<div class="modal-dialog" style="width: 550px;">
									<div class="modal-content">

										<div class="modal-header">
											<button class="close" aria-hidden="true" data-dismiss="modal"
												type="button">×</button>
											<h4 class="modal-title" id="nomeRel"></h4>
										</div>
										<div class="modal-body" style="min-height: 300px;">

									   	<form action="../relentrada" method="post"> 
					
												<div class="form-group"
													style="width: 200px; float: left; margin-top: 0%; margin-left: 2%">
													<label for="codigo">Data Inicial</label> <input name="dataini"
														class="form-control" type="date" id="dtini" >
												</div>	
					
												<div class="form-group"
													style="width: 200px; float: left; margin-top: 0%; margin-left: 2%">
													<label for="codigo">Data Final</label> <input name="datafim"
														class="form-control" type="date" id="dtfim" >
												</div>
																							
												<div
													style="width: 30px; margin-top: 0%; float: right; margin-right: 25%">
													<button class="btn btn-primary btnPesquisaRel" type="submit" >Pesquisar</button>
												</div>
										   </form> 
											
											<div id="retorno" style="width: 300px; margin-top: 0%; float: right; margin-right: 0%; font-size: 20px; color: red; ">
											
											</div>
										</div>
									</div>
								</div>
							</div>
               
                
                <!-- fim content -->
                
                
 <jsp:include page="template/inferiorContent"></jsp:include>               