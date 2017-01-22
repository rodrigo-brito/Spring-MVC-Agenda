var telefoneSelector = document.querySelector(".input-telefone");
var imTelefone = new Inputmask("(99) 9{4}-9{4,5}");
imTelefone.mask(telefoneSelector);

var emailSelector = document.querySelector(".input-email");
var imEmail = new Inputmask({
	mask : "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[.*{2,6}][.*{1,2}]",
	greedy : false,
	onBeforePaste : function(pastedValue, opts) {
		pastedValue = pastedValue.toLowerCase();
		return pastedValue.replace("mailto:", "");
	},
	definitions : {
		'*' : {
			validator : "[0-9A-Za-z!#$%&'*+/=?^_`{|}~\-]",
			cardinality : 1,
			casing : "lower"
		}
	}
});
imEmail.mask(emailSelector);