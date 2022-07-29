<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>

	<h3>회원등록</h3>
	<form name = "addFrm" action="addMemberAjax.do" method="post">
		아이디 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="mail"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		<input type="submit" value="저장">
	</form>

	<table border="1">
		<thead>
			<tr><th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th></tr>
		</thead>
		<tbody id="list"></tbody>
	</table>

	<!-- Ajax(비동기방식처리) -->
	<script>
	
	let i =0;
	
	let xhtp = new XMLHttpRequest();	//비동기방식 처리
	xhtp.open('get', 'memberJason.do');
	xhtp.send();
	xhtp.onreadystatechange= callBackThree;
	
	//출력할 필드를 배열에 지정
	let fields = ['id', 'name', 'mail', 'passwd'];
	function callBackThree(){
		if(this.readyState == 4 && this.status == 200){
			let data = JSON.parse(this.responseText); //json->object			
			console.log(data);
	
			let tbody = document.getElementById('list');

				//필드 갯수 반복
				for(let obj of data){
					tr=makeTr(obj);
					tbody.append(tr);
				}
			}
		}
	//end of callBackThree
	
	
	function makeTr(obj){
		//tr td,td,td,td
		let tr = document.createElement('tr');
		
		//필드 갯수 반복
		for(let field of fields){
			let td1 = document.createElement('td');
			td1.innerText = obj[field];
			tr.append(td1);
		}
		
		//삭제버튼 
		let td1 = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerText = '삭제';
		//클릭이벤트
		btn.addEventListener('click', deleteCallBack);
		td1.append(btn);
		tr.append(td1);
		
		return tr;
	}
	
	
	function deleteCallBack(e){
		console.log(this);	//callback의 this는 '이벤트를 받는 대상'
			//ex. user4의 삭제버튼 누르면 , 이때 this는 user4의 버튼 태그 
		
		let delId=this.parentElement.parentElement.firstElementChild.innerText;
		//버튼태그의 부모(td).td의 부모(tr).tr의 첫번째 td .의 안에 있는 문자 
		
/* 			//화면에서 지울때 -> db에선 안지워짐 => 그래서 새로고침하면 다시 복구되어 있음 
		let delId = this.parentElement.parentElement.remove();
 */			
		let delAjx = new XMLHttpRequest();
		delAjx.open('post','removeMemberAjax.do');
		delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		delAjx.send('id='+delId);
		delAjx.onload = function(){
			let result = JSON.parse(delAjx.responseText);
			if(result.retCode == 'Success'){
				//여기서는 this를 쓰면 안되고, '이벤트를 받는 대상인' function 매개값 e.target을 사용
				e.target.parentElement.parentElement.remove();
			} else{
				alert('처리 중 에러 발생');
			}
				
		}
			
	}
	
	
	function callBackTwo(){
		if(this.readyState == 4 && this.status == 200){
			let data = JSON.parse(this.responseText); //json->object			
			console.log(data);
			
			let ul = document.createElement('ul'); //<ul></ul>같이 만들기
			for(let obj of data){
				let li = document.createElement('li');	//<li></li>같이 만들기
				li.innerHTML = obj.name + ', ' +obj.age; //<li>hong, 15</li>
				ul.append(li);//ul의 아이 요소로 어펜드하겠다
			}
			console.log(ul);
			document.querySelector('body').append(ul);
	}
	}
	
	function callBackOne(){
		if(this.readyState == 4 && this.status == 200){
			//json을 자바 형태의 object타입으로 파싱해주는 역할
		let data = JSON.parse(this.responseText);			
		console.log(data);
		
		let name = document.createElement('p');
		name.innerText = data.name;
		
		let age = document.createElement('p');
		age.innerText = data.age;
		document.querySelector('body').append(name, age);
		
	}
	}
	
	//form 전송이벤트 실행
	document.forms.addFrm.onsubmit = function(e){
		//기본기능 차단
		e.preventDefault();
		
		let url = document.forms.addFrm.getAttribute('action');
		let id = document.forms.addFrm.id.value;
		let name = document.forms.addFrm.name.value;
		let pass = document.forms.addFrm.passwd.value;
		let mail = document.forms.addFrm.mail.value;
		let param = 'id='+id+'&name='+name+'&passwd='+passwd+'&mail='+mail;
		
		let addAjx = new XMLHttpRequest();
		addAjx.open('post',url);
		addAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		addAjx.send(param); //key:value 형식으로 값 넘김 => id=user1&passwd=1234&name=Hong
		addAjx.onload = function(){
			console.log(addAjx.responseText);
			
			let data = JSON.parse(addAjx.responseText); //json -> object로 바꿔주는 역할 
			//tbody태그의 id(list)
			document.getElementById('list').append(makeTr(data));
		}
	}
	
	
	</script>
</body>
</html>