TextUtil.autosuggest = function(oTextbox, arrValues, sListboxId) {
	var oListbox = document.getElementById(sListboxId);
	ListUtil.clear(oListbox);
	var arrMatches = TextUtil.autosuggestMatch(oTextbox.value, arrValues);
	for ( var i = 0; i < arrMatches.length; i++) {
		ListUtil.add(oListbox, arrMatches[i]);
	}
};