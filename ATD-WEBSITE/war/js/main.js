var picker = new Pikaday({
	field : document.getElementById('datepicker_aankomst'),
	firstDay : 1,
	minDate : new Date('2000-01-01'),
	maxDate : new Date('2020-12-31'),
	yearRange : [ 2000, 2020 ],
	onSelect : function() {
		var date = document.createTextNode(this.getMoment().format(
				'Do MMMM YYYY')
				+ ' ');
		document.getElementById('selected').appendChild(date);
	}
});

var picker = new Pikaday({
	field : document.getElementById('datepicker_vertrek'),
	firstDay : 1,
	minDate : new Date('2000-01-01'),
	maxDate : new Date('2020-12-31'),
	yearRange : [ 2000, 2020 ],
	onSelect : function() {
		var date = document.createTextNode(this.getMoment().format(
				'Do MMMM YYYY')
				+ ' ');
		document.getElementById('selected').appendChild(date);
	}
});

$("td").click(function() {
	$(this).closest("tr").siblings().removeClass("highlight-table");
	$(this).parents("tr").toggleClass("highlight-table", this.clicked);

});

$('#checkbox').change(function() {
	if (this.checked) {
		document.getElementById('block1').disabled = true;
		document.getElementById('block2').disabled = true;
		document.getElementById('block3').disabled = true;
		document.getElementById('postcode').disabled = true;
		document.getElementById('email').disabled = true;
	} else {

		document.getElementById('block1').disabled = false;
		document.getElementById('block2').disabled = false;
		document.getElementById('block3').disabled = false;
		document.getElementById('postcode').disabled = false;
		document.getElementById('email').disabled = false;
	}
});

(function() {
	if (window.addEventListener) {
		window.addEventListener('load', run, false);
	} else if (window.attachEvent) {
		window.attachEvent('onload', run);
	}

	function run() {
		var t = document.getElementById('voorraad-table');
		var rows = t.rows;
		for (var i = 0; i < rows.length; i++) {
			rows[i].onclick = function(event) {
				if (this.parentNode.nodeName == 'THEAD') {
					return;
				}
				var cells = this.cells; // cells collection
				var f1 = document.getElementById('naam');
				var f2 = document.getElementById('aantal');
				var f3 = document.getElementById('prijs');
				var f4 = document.getElementById('ID');
				f1.value = cells[1].innerHTML;
				f2.value = cells[2].innerHTML;
				f3.value = cells[3].innerHTML;
				f4.value = cells[0].innerHTML;
			};
		}
	}

})();

$(document).ready(
		function() {
			$('#voorraad-table tr').each(
					function() {
						$(this).find('#prijs').each(
								function() {
									var a = $(this).text();
									$(this).replaceWith(
											"<td>"
													+ accounting.formatMoney(a,
															"€", 2, ".", ",")
													+ "</td>");
								})
					})
		});

$(document).ready(
		function() {
			$('#onderdelen-table tr').each(
					function() {
						$(this).find('#prijs').each(
								function() {
									var a = $(this).text();
									alert(a);
									$(this).replaceWith(
											"<td>"
													+ accounting.formatMoney(a,
															"€", 2, ".", ",")
													+ "</td>");
								})
					})
		});