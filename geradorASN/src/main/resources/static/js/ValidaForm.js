class ValidaForm {
	
	constructor(){
		
	}
	
	mascaraCodigo(i) {
	    var v = i.value;
	    v = v.replace(/\D/g, "");
	    i.value = v.substring(0, v.length + 1);
	    i.setAttribute("maxlength", "10");
	}

	mascaraData(i) {
	    var v = i.value;
	    v = v.replace(/\D/g, "");
	    v = v.replace(/^(\d{2})(\d{2})(\d)/g, "$1/$2/$3"); 
	    i.value = v.substring(0, v.length + 1);
	    i.setAttribute("maxlength", "10");
	}
	
	validaConfirmacaoManual(){
		
		let lstItens = $("input[name='confirmado']").toArray().map(
			function(check) {
				return $(check).val();
			});

		let lstItensMarcados = $('input[name="confirmado"]:checked').toArray().map(function(check) {
				return $(check).val();
			});

		if (lstItens.length != lstItensMarcados.length) {
			return false;
		}else{
			return true;
		}
		
	}
	
	
}