$(function() {
	
	const PESQUISAR 			= "#btnPesquisar";	
	const ATUALIZAR 			= "#atualizar";
	const CARREGAR 				= "#carregar";
	const EXECUTAR 				= "#executar";
	const ATUALIZAR_CONTRATO 	= "#atualizarContrato";

	var controller 	= new Controller();
	var acao 		= new Acoes();

	controller.testaBotaoExecutar();
	
	$(PESQUISAR).click(function(event) {
		acao.pesquisar();
	});
	
	$(ATUALIZAR).click(function() {
		acao.atualizarPedidos();
	});
	
	$(CARREGAR).click(function() {
		$("#form").attr("action", "/bibnet");
		$("#form").submit();
	});

	$(EXECUTAR).click(function() {
		acao.executarConciliacao();
	});

	$(ATUALIZAR_CONTRATO).click(function() {
		$("#form").attr("action", "/bibnet");
		$("#form").submit();
	});
	
	$("input[name='confirmado']").change(function() {
		controller.habilitaBotao("atualizar");
	});
	
	$('#datepickerInicio').datetimepicker({
		locale : 'pt-br',
		format : 'DD/MM/YYYY'
	});

	$('#datepickerFim').datetimepicker({
		locale : 'pt-br',
		format : 'DD/MM/YYYY'
	});
	
	$('input[id="dataInicio"]').unmask().mask('99/99/9999');
	$('input[id="dataFim"]').unmask().mask('99/99/9999');
	$('input[id="codigo"]').replaceAll(/^(\d{2})(\d{2})(\d)/g, "$1/$2/$3");

});

function abrePopupContrato() {
	window.open("/bibnet/consultarContrato/contratoPopup", "blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=0,left=0,width=1550,height=750");
}

function exibirErro() {
	if ($('#msgErro').is(':visible')) {
		$("#msgErro").hide();
	} else {
		$("#msgErro").show();
	}
}