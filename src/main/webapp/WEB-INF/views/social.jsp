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
	                   
	                    <p>A far far away software</p>
	                    <!-- <input type="button" class="btn btn-default" value="Login" /> -->
				<!--  </div>-->
			</div>
        </div>
        <!-- /#sidebar-wrapper -->
        
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<div>
						<f:form modelAttribute="NewMessageForm" method="post" action="posterMessage">
							<table>
								<tr>
									<td> Votre pseudo :</td>
									<td><f:input path="loginUser" /></td>
									<td><f:errors path="loginUser"></f:errors></td>
								</tr>
								<tr>
									<td> Votre message :</td>
									<td><f:input path="content" /></td>
									<td><f:errors path="content"></f:errors></td>
								</tr>
								<tr>
									<td><input type="submit" value="poster" /></td>
								</tr>
							</table>
						</f:form>
					</div>
                
                    <div class="col-lg-12">
                        <h1 class="content-subhead">Last tweets</h1>
                        <hr />
                    </div>
                    
                    <c:forEach var="message" items="${messages}">
						<h4 class="media-heading"></h4>
						<span><c:out value="${message.content}"/></span>
						<h4><small><c:out value="${message.user.login}"/>, le <c:out value="${message.dateCreation}"/></small></h4>
					</c:forEach>
                    
                    
                


        
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