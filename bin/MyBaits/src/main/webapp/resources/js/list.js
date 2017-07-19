/**
 * 调用后台处理进入添加页面
 * 
 * @param basePath
 * @returns
 */
function initInsertMessage(basePath) {
	
	$("#mainForm").attr("action",basePath + "/initInsertMessage.action");
	$("#mainForm").submit();
}


/**
 * 调用后台批量删除message方法
 */
function deleteMessageList(basePath) {
	
	$("#mainForm").attr("action",basePath + "/deleteMessageList.action");
	$("#mainForm").submit();
	
}

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

/**
 * 调用后台跳转到第几页
 * 
 * @param basePath
 * @param currentPage	当前指定的页数
 */
function changeCurrentPage(basePath, currentPage){
	
	
	
//	$.ajax({
//		url : basePath + "/listMessageByPage.action",
//		type : "POST",
//		dataType : "text",
//		timeout : 10000,
//		success : function () {
////			alert("翻页成功！");
////			window.location.reload();
//		},
//		data : {"currentPage":currentPage}
//	});
//	
//	alert(currentPage+"+-+"+currentPage);
	
//	var oTextbox2=document.getElementById("txt2");
//	oTextbox1.value="fitst textbox";
	
	$("#currentPage").val(currentPage);
	
	
	$("#mainForm").attr("action",basePath + "/listMessageByPage.action");
	$("#mainForm").submit();
	
}


