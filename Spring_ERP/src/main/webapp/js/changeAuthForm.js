//submit
function frmPaging(){
	document.getElementById("frmPaging").submit();
}

//index 리스트 처리
function pageIndex(pageNum){
	document.getElementById("index").value = pageNum-1;
	frmPaging();
}

// 리스트 출력 갯수
function listNum(){
	document.getElementById("index").value = 0;
	document.getElementById("pageNum").value = 1;
	document.getElementById("listNum").value = document.getElementById("listCount").value;
	frmPaging();
}

// 이전 페이지
function pageStart(index, pageList){
	if ((index-pageList)>0) {
		index -= pageList;
		document.getElementById("pageNum").value = index;
		document.getElementById("index").value = index-1;
		frmPaging();
	}
}

// 마지막 페이지 이동
function pageLast(index, total, listNum, pageList){
	var totalPage = Math.ceil(total/listNum);
	var max = Math.ceil(totalPage/pageList);
	while(max*pageList > index+pageList) {
		index += pageList;		
	}
	document.getElementById("pageNum").value = index;
	document.getElementById("index").value = totalPage-1;
	
	frmPaging();
}

// 권한변경 처리
$(document).ready(function(){
	$(".btn-success").click(function(){
		alert("권한변경 되었습니다.");
		document.frmPaging.action = "./changeAuth.do";
		document.frmPaging.submit();			
	});
});