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
							<f:select path="login">
								<c:forEach var="option" items="${ users }">
									<f:option value="${ option.login }"><c:out value="${ option.login }" /></f:option>
								</c:forEach>
							</f:select>
						<input type="submit" value="voir le profil" />
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
    <div class="container">
		<div class="col-md-5">
		    <div class="form-area">  
		        <f:form modelAttribute="profilForm" method="POST" action="editProfil" role="form">
		        <br style="clear:both">
		                    <h3 style="margin-bottom: 25px; text-align: center;">Profil Form</h3>
							<input type="hidden" class="form-control" id="login" name="login"  value="${user.login}" >
		    				<div class="form-group">
								<input type="text" class="form-control" id="nom" name="nom"  value="${user.nom}" required>
							</div>
		    				<div class="form-group">
								<input type="text" class="form-control" id="prenom" name="prenom"  value="${user.prenom}" required>
							</div>							
							<div class="form-group">
								<input type="text" class="form-control" id="email" name="email"  value="${user.email}">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="mobile" name="mobile"  value="${user.phoneNumber}">
							</div>
						<input type="submit" value="mettre à jour le profil" class="btn btn-primary pull-right"/>
		        <!--  <button type="button" id="submit" name="submit" class="btn btn-primary pull-right">Submit Form</button>-->
		        </f:form>
		    </div>
		</div>
		</div>
 

                    <a href="/social/index">
	                        Retour à l'accueil
	                    </a>
    
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