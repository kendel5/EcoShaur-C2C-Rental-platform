<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="net.utility.*"%>
<!-- registerForm.jsp -->
<style>
.table{
	width:800px;
	height:600px;
	background-color:white;
	margin:auto;
	font-size:14pt;
	font-family: 'Noto Sans KR';
	
}

</style>

<form method="post"
        action="./create.do"
        enctype="multipart/form-data" >
  <table class="table">
  <tr>
  	<th colspan='2' style="text-align:center; font-size:18pt;">제품 등록</th>
  </tr>
    <tr>
      <th>제품명</th>
      <td style="font-family: 'Noto Sans KR'; font-size: 12pt;"><input type='text' name='rg_name' size='50'></td>
    </tr>
    <tr>
      <th>제품 카테고리</th>
      <td style="font-family: 'Noto Sans KR'; font-size: 12pt;">
      	<select name='rg_code' id='rg_code'>
			<option value='DESK'>책상
			<option value='CHAIR' selected>의자
			<option value='SOFA'>소파
			<option value='CABBINET'>수납장
  		</select>
      </td>
     </tr>
     <tr>
       <th>대표 이미지 파일</th>
       <td style="font-size:12pt;"><input type='file' name='rg_filename1MF' size='25'></td> 
     </tr>
     <tr>
       <th>측면 이미지 파일</th>
       <td style="font-size:12pt;"><input type='file' name='rg_filename2MF' size='25'></td> 
     </tr>
     <tr>
       <th>제품 상세설명</th>
       <td style="font-size:11pt;"><textarea name='rg_explain' size='500'></textarea></td>
     </tr>
     <tr>
       <th>제품 정보</th>
       <td style="font-size:11pt;">
       <textarea name='rg_info' id='rg_info' rows='5' cols='60' ></textarea>
        <script>
   		 $(function(){
         
        	CKEDITOR.replace( 'rg_info', {//해당 이름으로 된 textarea에 에디터를 적용
           	 	filebrowserImageUploadUrl: '../register/storage/imageUpload.do' //여기 경로로 파일을 전달하여 업로드 시킨다.
        	});
        	
        	CKEDITOR.on('dialogDefinition', function( ev ){
                var dialogName = ev.data.name;
                var dialogDefinition = ev.data.definition;
              
                switch (dialogName) {
                    case 'image': //Image Properties dialog
                    //dialogDefinition.removeContents('info');
                    dialogDefinition.removeContents('Link');
                    dialogDefinition.removeContents('advanced');
                    break;
                }
        	});
   		 });
        </script>
	   </td>
     </tr>

     <tr>
       <th>제품 사이즈</th>
       <td style="font-family:sans-serif;">
       	<input type='checkbox' name='rg_size' value='S' checked>&nbsp;S
  		<input type='checkbox' name='rg_size' value='M'>&nbsp;M
  		<input type='checkbox' name='rg_size' value='L'>&nbsp;L
  		<input type='checkbox' name='rg_size' value='Free'>&nbsp;Free
       </td>
     </tr>
     <tr>
       <th>이니셜</th>
       <td>
       	<input type='checkbox' name='rg_init' value='Y' checked>&nbsp;이니셜 가능
  		<input type='checkbox' name='rg_init' value='N'>&nbsp;이니셜 불가능
       </td>
     </tr>
     <tr>
    	<td colspan="2" style="font-family:'Noto Sans KR'; font-weight:700; text-align:center;">
    	  <input type="button" class="btn btn-secondary" value="제품목록" onclick="location.href='list.do'">
    	  <input type="submit" class="btn btn-success" value="제품등록">
    	  <br><br>
    	</td>
	</tr>
  </table>
</form>


<!-- 본문 끝 -->
<%@ include file="e_footer.jsp"%>