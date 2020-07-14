<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 Qna.jsp-->
<body>
<div class="container">
	<H3>자주하는 질문</H3>
<br><br>

<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          ECOSHAUR의 이용방법이 궁금합니다.
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
        ECOSHAUR는 사용자 간 대여가 가능한 사이트이며 회원가입 후 이용이 가능합니다.
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                   대여 사용기간 중 일시정지가 가능한가요?
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
               대여 사용기간 중 일시정지는 불가능 합니다.
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                   포인트는 어떻게 사용하나요?
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body">
               포인트는 결제를 통해 얻을 수 있으며 포인트를 사용해 결제금액을 할인받을 수 있습니다.
    </div>
  </div>
</div>
<br><br>
<div align="right">
<a href="QCreate.do" class="btn btn-success">문의하기</a>
<a href="QList.do?nowpage=1" class="btn btn-success">문의목록 보기</a>
</div>
</body>
<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>