/**
 * 
 */

console.log("Reply module....");

var replyService = (function(){
	
	function add(reply, callback, error){
		// reply : 댓글 객체
		// callback : 함수를 실행시키고 난 후에 결과를 받을 수 있는 함수 또는 그 다음에 실행할 함수
		console.log("add reply");
		
		$.ajax({
			type : 'post',
			url : 'replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset = utf-8",
			success : function(result, status, xhr){
				// 성공했으면 실행할 함수
				if(callback){ // 콜백함수가 있으면
					callback(result); // 콜백함수 실행
					
				}
			},
			error : function(xhr, status, er){
				// 에러가 발생하면 실행할 함수
				if(error){ // 에러를 처리하는 함수가 있으면
					error(er); // 에러 함수 실행
				}
			}
		})
	}
	return {
		add : add
	};
	// replyservice() 함수를 부르고 나서 그 결과값에 객체가 들어오는데
	// 그 안에 add를 가져오면 댓글 등록 기능 함수를 사용할 수 있다.
	// var service = replyservice();
	// service.add();
	// service.getList();
})();
