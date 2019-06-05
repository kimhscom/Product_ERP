// Modal 품목 등록
$(document).ready(function(){
	$("#modalSubmit").click(function() {
//		alert("작동");
		var data = {
				"item_name" : $("#item_name").val(),
				"item_price" : $("#item_price").val()
		};
		
//		alert(data);
		
		$.ajax({
			url : "./insertItem.do",
			type: "post",
			data : data,
			async : true,
			success : function(data) {
				alert("품목이 등록되었습니다.");
				location.reload();
			},
			error : function(error) {
				aleart("오류발생"+error);
			}
		
		})
			
		
		
	});
});

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