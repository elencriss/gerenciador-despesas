<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">

<title>Listagem de Despesas</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top"></nav>
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="clearfix">
				<h1 class="panel-title impacta-titulo-panel">Despesas</h1>
				<a href="/despesas/nova" class="btn btn-link impacta-link-panel">Nova Despesa</a>
			</div>
		</div>
	</div>

	<div class="panel-body">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th class="text-center col-md-1">#</th>
					<th class="text-center col-md-3">Descrição</th>
					<th class="text-center col-md-2">Categoria</th>
					<th class="text-center col-md-1">Data</th>
					<th class="text-center col-md-2">Valor</th>
					<th class="text-center col-md-4">Observações</th>
					<th class="col-md-1"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${despesas}" var="despesa">
					<tr>
						<td class="text-center">${despesa.codigo}</td>
						<td class="text-left">${despesa.descricao}</td>
						<td class="text-center">${despesa.categoria.nome}</td>
						<td class="text-center"><fmt:formatDate value="${despesa.data}" type="date" pattern="dd/MM/yyyy"/></td>
						<td class="text-right"><fmt:formatNumber value="${despesa.valor}" type="currency"/></td>
						<td class="text-left">${despesa.observacoes}</td>
						<td class="text-center">
							<a class="btn btn-link btn-xs" data-toggle="modal" data-target="#confirmaRemocaoModal" data-whatever="${despesas.codigo}">
								<span class="glyphicon glyphicon-remove"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${despesas.isEmpty()}">
					<tr>
						<td class="text-center" colspan="7"><i>NENHUMA DESPESA FOI ENCONTRADA.</i></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	<div class="modal fade" id="confirmaRemocaoModal" tabindex="-1" data-keybord="false" data-backdrop="static">
		<div class="modal-dialog">
			<form action="/despesas" method="POST">
				<input type="hidden" name="_method" value="DELETE">

				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Confirmação</h4>
					</div>

					<div class="modal-body">
						<span>Deseja realmente remover esta despesa?</span>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-link" data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Confirmar</button>
					</div>
				</div>
			</form>
		</div>

	</div>
	<script src="/js/jquery-3.1.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/despesa.js"></script>
</body>
</html>