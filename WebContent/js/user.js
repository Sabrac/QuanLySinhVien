function getInputForm() {
	var frm = document.inputform;
	if(frm == undefined) frm = document.mainform;
	return frm;
}
function paging(url, pageId) {
	frm = getInputForm();
	frm.page.value = pageId;
	frm.submit();
}
function test(url) {
	var frm = document.addParam;
	frm.action = url;
	frm.submit();
}