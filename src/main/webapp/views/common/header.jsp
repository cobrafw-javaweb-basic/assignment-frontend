<header>
	<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="<c:url value="/" />">Cobra Framework</a>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class='nav-item <c:if test="${empty categoryId}">active</c:if>'>
					<a class="nav-link" href="<c:url value="/" />">Home</a>
				</li>
				<c:forEach var="category" items="${listCategories}">
					<li class='nav-item <c:if test="${categoryId == category.id}">active</c:if>'>
						<a class="nav-link" href="<c:url value="/list?cid=${category.id}" />">${category.name}</a>
					</li>
				</c:forEach>
			</ul>
			<div class="my-2 my-lg-0">
				<c:if test="${not empty sessionScope.account}">
					<p>${sessionScope.account.username} | <a href="<c:url value="/cart" />">Cart</a> | <a href="<c:url value="/logout" />">Logout</a></p>
				</c:if>
				<c:if test="${empty sessionScope.account}">
					<p><a href="<c:url value="/login" />">Login</a></p>
				</c:if>
			</div>
		</div>
	</nav>
</header>