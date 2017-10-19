<%@ include file="/views/common/common.jsp"%>
<c:set var="pageTitle" value="Assignment Demo - Home Page" />
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/views/common/head.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/views/common/header.jsp"%>
		
		<div class="homepage-slidebox">
			<img alt="Home page slide" src="<c:url value="/images/slide/slide.jpg" />">
		</div>

		<div class="content">
			<div class="row">
				<c:forEach var="product" items="${listProducts}">
					<div class="col-3">
						<div class="product-box">
							<img alt="${product.code}" src="${product.image}">
							<p>${product.code}</p>
							<p><strong>${product.name}</strong></p>
							<p>${product.unitPrice}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="homepage-slidebox row">
			<div class="col"><img alt="Home page slide" src="<c:url value="/images/footer/footer1.jpg" />"></div>
			<div class="col"><img alt="Home page slide" src="<c:url value="/images/footer/footer2.jpg" />"></div>
		</div>

		<%@ include file="/views/common/footer.jsp"%>
	</div>
</body>
</html>