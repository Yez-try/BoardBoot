/**
 * 
 */
 
 console.log("qnaAdd.js")
 
 let cntFiles = 0
 
 $("#fileAddBtn").click(function(){
	 if(cntFiles<5){
	 	$("#divFiles").append('<div class="col my-1"><label for="file">파일</label><input type="file" name="file" id="file"><button type="button" class="delFile">지우기</button></div>')		 
	 	cntFiles++
	 }else{
		alert("파일은 5개까지 추가 가능합니다") 
	 }
 console.log($(".note-editable").text()	)
	 
 })
 
 //파일 삭제
 $("#divFiles").click(function(event){
	 if($(event.target).attr("class")=='delFile'){
		 $(event.target).parent().remove()
		 cntFiles--
	 }
 })
 
 
 //검증 notnull
 let vTitle = false;
 let vContents = false;
 let vWriter = false;
 
 //타이틀 확인
 $("#title").blur(function(){
	 if($("#title").val().length>0){
		 vTitle=true;
		 $("#titleChk").text("")
	 }else{
		 $("#titleChk").text("제목은 필수 입력 입니다.")
	 }
 })
 
 //작성자 확인
 $("#writer").blur(function(){
	 if($("#writer").val().length>0){
		 vWriter = true;
		 $("#writerChk").text("")
	 }else{
		 $("#writerChk").text("작성자는 필수 입력 입니다.")
	 }
 })
 
 
 //콘텐츠 확인
 $(".note-editable").blur(function(){
	 
	 if($(".note-editable").text().length>10){
		 vContents = true;
		 $("#contentsChk").text("")
	 }else{
		 $("#contentsChk").text("10자 이상 작성해주세요")
	 }
 })
 
 $("#writeBtn").click(function(){
	console.log(vTitle&vContents&vWriter)
	 if(vTitle&vContents&vWriter){
		 $("#writeForm").submit();
	 }
	 
	 console.log("안서브밋")
 })
 