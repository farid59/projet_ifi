<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Star wars Network</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" href="../css/style.css" type = "text/css"/>
</head>
<body>

	<div id="wrappr">
		<!-- Sidebar -->
        <div id="sidebar-wrapper2">

			<div class="header">
				<!--  <div class="intro2">-->
	                    <a href="#">
	                        Star Wars Network
	                    </a>
	                   	<f:form modelAttribute="UserForm" method="POST" action="profil">
							<table>
								<tr>
									<td> Manipuler un profil :</td>
									<td>
										<f:select path="login">
											<c:forEach var="option" items="${ users }">
												<f:option value="${ option.login }"><c:out value="${ option.login }" /></f:option>
											</c:forEach>
										</f:select>
									</td>
									<td><f:errors path="login"></f:errors></td>
									<td><input type="submit" value="voir" /></td>
								</tr>
							</table>
						</f:form>
	                    <p>A far far away software</p>
	                    <!-- <input type="button" class="btn btn-default" value="Login" /> -->
				<!--  </div>-->
			</div>
        </div>
        <!-- /#sidebar-wrapper -->
        
        <div id="page-content-wrapper">
            <div class="container-fluid">
<div class="container">
  <div class="row">
  	<div class="col-md-6">
    
      <div class="panel panel-default">
			<div class="panel-body">
              		<div class="row">
                        <div class="col-xs-12 col-sm-8">
                            <h2><c:out value="${user.login}" /></h2>
                            <p><strong>Nom: </strong><c:out value="${user.nom}" />.</p>
                            <p><strong>Prenom: </strong><c:out value="${user.prenom}" />.</p>
                            <p><strong>Email: </strong> <c:out value="${user.email}" />. </p>
                            <p><strong>Numero: </strong><c:out value="${user.phoneNumber}" />. </p>
                            <p><strong>Abonnement: </strong>
                            	<c:forEach var="hashtag" items="${ user.suscribedHashtags }">
                            		<span class="label label-info tags"><c:out value="${ hashtag }" /></span>
								</c:forEach>
                                <span class="label label-info tags">html5</span> 
                                <span class="label label-info tags">css3</span>
                                <span class="label label-info tags">jquery</span>
                                <span class="label label-info tags">bootstrap3</span>
                            </p>
                        </div><!--/col-->          
                        <div class="col-xs-12 col-sm-4 text-center">
                                <img src="http://api.randomuser.me/portraits/men/49.jpg" alt="" class="center-block img-circle img-responsive">
                                <ul class="list-inline ratings text-center" title="Ratings">
                                  <li><a href="#"><span class="fa fa-star fa-lg"></span></a></li>
                                  <li><a href="#"><span class="fa fa-star fa-lg"></span></a></li>
                                  <li><a href="#"><span class="fa fa-star fa-lg"></span></a></li>
                                  <li><a href="#"><span class="fa fa-star fa-lg"></span></a></li>
                                  <li><a href="#"><span class="fa fa-star fa-lg"></span></a></li>
                                </ul>
                        </div><!--/col-->

                        <div class="col-xs-12 col-sm-4">
                            <h2><strong> 45 </strong></h2>                    
                            <p><small>Followers</small></p>
                            <button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Suivre </button>
                        </div><!--/col-->
                        <div class="col-xs-12 col-sm-4">
                            <h2><strong>245</strong></h2>                    
                            <p><small>tweets</small></p>
                            <button class="btn btn-info btn-block"><span class="fa fa-user"></span> Voir ses tweets </button>
                        </div><!--/col-->
                        <div class="col-xs-12 col-sm-4">
                            <h2><strong>43</strong></h2>                    
                            <p><small>Snippets</small></p>
                            <button type="button" class="btn btn-primary btn-block"><span class="fa fa-gear"></span> se d�sabonner </button>  
                        </div><!--/col-->
              		</div><!--/row-->
              </div><!--/panel-body-->
          </div><!--/panel-->

    
    
    </div>
  </div>
</div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
	</div>
	



<style type="text/css">

#sidebar-wrapper2 {
	position: fixed;
	top: 0px;
	bottom: 0px;
	background: #3D4F5D none repeat scroll 0% 0%;
	width:25%
	}

#wrapper.toggled #sidebar-wrapper {
    width: 250px;
}

#page-content-wrapper {
    width: 75%;
    margin-left:25%;
    position: absolute;
	padding: 2em 3em 0px;
}


	.intro {
	    display: inline-block;
	    line-height: 750px;
	    height: 500px;
	    margin-left: 130px;
		font-size: 3em;
		text-align: right;
		margin-right: 35px;
    }    
    .intro2 {
	   line-height:normal;
	   display:inline-block;
    }
    
    .header a {
	    text-transform: uppercase;
	    font-size: 40px;
	    color: rgb(61, 146, 201);
    }
    .header p {
    	font-size:25px;
    	margin-left:-30px;
    	color:aliceblue;
    }
    .header {
    	margin: 80% 2em 0px;
		text-align: right;
    }
    .content-subhead {
		font-size: 15px;
		letter-spacing: 0.1em;
		font-weight: 400;
		padding: 0.4em 0px;
		color: #AAA;
		text-transform: uppercase;
		margin-bottom: -20px;
}
</style>


</body>
</html>