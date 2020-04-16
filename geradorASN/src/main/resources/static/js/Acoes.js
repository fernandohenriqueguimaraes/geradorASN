class Acoes {
	
	
	pesquisar(){
		let codigo 		= $("#codigo").val();
		let dtInicio 	= $("#dtInicio").val();
		let dtFim 		= $("#dtFim").val();

		if (codigo == '' && (dtInicio == '' || dtFim == '')) {
			this._atribuiModal("btnPesquisar");
			return;
		} 
		
		let padd = 50;

		this._loadingButton("btnPesquisar", 20);
		$("#target").submit();
		
	}
	
	atualizarPedidos(){
		if (!new ValidaForm().validaConfirmacaoManual()){
			this._atribuiModal("atualizar");
			return;
		}
		$("#atualizaPedidos").submit();
	}
	
	executarConciliacao(){
		
		this._loadingButton("executar", 50);
		
		$("#target").attr("action", "/bibnet/executarConciliacao");
		$("#target").submit();
	}
	
	_atribuiModal(divId){
		$("#" + divId).attr("data-toggle", "modal");
	}
	
	_loadingButton(divId, padd){
		$("#" + divId).attr("disabled", "disabled");
		$("#" + divId).html('<div style="padding-left:' + padd + 'px;padding-right:' + padd + 'px;"><span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span></div>');
	}
	
	
	
}