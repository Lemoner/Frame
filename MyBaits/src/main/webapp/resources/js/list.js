/**
 * 调用后台批量删除message方法
 */
//function deleteMessageList(basePath) {
//	
//	$("#mainForm").attr("action",basePath + "/deleteMessageList.action");
//	$("#mainForm").submit();
//	
//}

/**
 * 调用后台删除单条message
 * 
 * @param basePath
 * @param deleteid	要删除的message的id
 */
function deleteMessage(basePath, deleteid) {
	$.ajax({
		url : basePath + "/deleteMessage.action",
		type : "POST",
		dataType : "text",
		timeout : 10000,
		success : function () {
			alert("删除成功！");
			window.location.reload();
		},
		data : {"deleteid":deleteid}
	});
}

