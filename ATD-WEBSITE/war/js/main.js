// javascript voor de voorraad beheer!
// dit vuld de velden met de waarde uit de tabel
// scheeld een hoop werk
(function() {
	if (window.addEventListener) {
		window.addEventListener('load', run, false);
	} else if (window.attachEvent) {
		window.attachEvent('onload', run);
	}
	// zetten
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
				f1.value = cells[0].innerHTML;
				f2.value = cells[1].innerHTML;
				f3.value = cells[2].innerHTML;
			};
		}
	}

})();

// extra
// als je op een table row klikt highligh hij groen
$("td").click(function() {
	$(this).closest("tr").siblings().removeClass("highlight-table");
	$(this).parents("tr").toggleClass("highlight-table", this.clicked);
});