<jsp:include page="template/superiorContent.jsp"></jsp:include>

                <!-- Main content -->
                       
                
               <link rel='stylesheet prefetch' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>


<p>
  <label for="myInput">Seu nome aqui</label>
  <br />
  <input id="myInput" />
</p>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <h1 class="target-nome">NOME DO INPUT</h1>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>

  <script>
                $('#myModal').on('shown.bs.modal', function() {
  var nomeUsuario = $("#myInput").val();
  $(".target-nome").text(nomeUsuario);
});
                
   </script>  
				
                <!-- /.content -->
                
                
 <jsp:include page="template/inferiorContent"></jsp:include>               