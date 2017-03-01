<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
table tr, th, td {
	font-size: 12px;
	padding: 5px;
}
</style>

<div class="container">

	<c:set var="count" value="1" scope="page" />
	<c:set var="totalFM" value="0" scope="page" />
	<c:set var="totalObt" value="0" scope="page" />
	<div class="row">
	<div id="heading">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
		<div style="text-align:center;">
			<br>
			 <h2><b>Shree Nirmal Seconday School</b></h2>
			 <br>
			 Vyas-1,Bhadgaun, Tanahun<br>
			 Tel-065-56039
		</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	</div>
	<br> <br>
	<br> <br>
	<br>
	<br> <b>Student Name: ${student.firstName} ${student.lastName}  <br>
	Class Name : ${studentClass.className} </b><br>
	<br>


	<table border="1" width="100%" align="center">
		<thead>
			<tr>
				<th rowspan="2" style="width: 5%; text-align: center;">S.N</th>
				<th rowspan="2" style="width: 20%; text-align: center;">
					Subjects</th>
				<th rowspan="2" style="width: 4%; text-align: center;">FULL
					MARKS</th>
				<th rowspan="2" style="width: 4%; text-align: center;">PASS
					MARKS</th>
				<th colspan="2" style="width: 6%; text-align: center;">OBTAINED
					MARKS</th>
				<th rowspan="2" style="width: 6%; text-align: center;">Total</th>
				<th rowspan="2" style="width: 6%; text-align: center;">Remarks</th>
			</tr>
			<tr>
				<th>TH</th>
				<th>PR</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="report" items="${reportList}">
				<tr>
					<td>${count}</td>
					<td>${report.subjectName }</td>
					<td>
						<fmt:parseNumber var="total" integerOnly="true" type="number"
							value="${report.fullThMarks+report.fullPrMarks }" />
					   ${total }
					</td>
					<td>
					<fmt:parseNumber var="pass" integerOnly="true" type="number"
							value="${report.passThMarks+report.passPrMarks }" />
					   ${pass}
					</td>
					<td>${report.obtThMarks}</td>
					<td><c:choose>
							<c:when test="${ report.hasPractical}">
							  ${report.obtPrMarks}
							</c:when>
							<c:when test="${not report.hasPractical}">
							-
							</c:when>
						</c:choose></td>
					<td>${report.obtThMarks+report.obtPrMarks}</td>
					<td></td>
				</tr>
				<c:set var="totalFM"
					value="${totalFM + report.fullThMarks+report.fullPrMarks}"
					scope="page" />
				<c:set var="totalObt"
					value="${totalObt + report.obtThMarks+report.obtPrMarks}"
					scope="page" />
				<c:set var="count" value="${count + 1}" scope="page" />
			</c:forEach>

		</tbody>
	</table>
	<b>
	<fmt:parseNumber var="percentage" integerOnly="true" type="number"
		value="${totalObt/totalFM*100}" />
		
	<br> Grand Total : ${totalObt} <br>
	Percentage  : 
	<fmt:formatNumber type="number" 
            maxFractionDigits="3" value="${percentage}" /> %
</b>
	
</div>

<script language=javascript>
window.onload = function () {
     window.print(); 
}
</script>