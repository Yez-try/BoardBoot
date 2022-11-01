/**
 * 
 */
 
 console.log("qnaAdd.js")
 
 let cntFiles = 0
 
 $("#fileAddBtn").click(function(){
	 if(cntFiles<5){
	 	$("#divFiles").append('<div class="col my-1"><label for="file">파일</label><input type="file" name="file" id="file"></div>')		 
	 	cntFiles++
	 }else{
		alert("파일은 5개까지 추가 가능합니다") 
	 }
 console.log($(".note-editable").text()	)
	 
 })
 
 
 //검증 notnull
 let vTitle = false;
 let vContents = false;
 let vWriter = true;
 
 //타이틀 확인
 $("#title").blur(function(){
	 if($("#title").val().length>0){
		 vTitle=true;
		 $("#titleChk").text("")
	 }else{
		 $("#titleChk").text("제목은 필수 입력 입니다.")
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
 