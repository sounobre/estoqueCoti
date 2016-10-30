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
					<form action="">
					
							<div class="col-lg-2">
							<select class="form-control">
					<option>Teste</option>
					</select>
					</div>
					<div class="col-lg-2">
							<input type="text" class="form-control"> 
							</div>
							<span class="input-group-btn " >
									<button class="btn btn-default" type="submit"
										style="margin-right: 100px">
										<i class="fa fa-search"></i>
									</button>
							</span>
							
					</form>
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
