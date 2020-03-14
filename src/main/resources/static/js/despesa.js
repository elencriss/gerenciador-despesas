/**
 * 
 */
$('#confirmaRemocaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigo = button.data('whatever');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.att('action');
	
	action = '/despesas/';
	form.att('action', action + codigo);
	
	modal.find('.modal-body span').html('Tem certeza que desela excluir a despesa <strong>' + codigo + '</strong>?');
	
});