class Controller {
	
	testaBotaoExecutar(){
		if (this.pedidoEncontrado()){
			this.habilitaBotao("executar");
		}else{
			this.desabilitaBotao("executar");
		} 
	}
	
	pedidoEncontrado(){
		return $("#pedidoEncontrado").val() == "";
	}

	habilitaBotao(idBotao){
		$("#" + idBotao).attr("disabled", false);
	}

	desabilitaBotao(idBotao){
		$("#" + idBotao).attr("disabled", true);
	}
	
	
}