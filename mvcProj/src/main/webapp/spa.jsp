<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>

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
	
	
	let fields = ['id', 'name', 'mail', 'pass'];
	function callBackThree(){
		if(this.readyState == 4 && this.status == 200){
			let data = JSON.parse(this.responseText); //json->object			
			console.log(data);
	
			let tbody = document.getElementById('list');
			for(let obj of data){
				//tr td,td,td,td
				let tr = document.createElement('tr');
				
				//필드 갯수 반복
				for(let field of fields){
					let td1 = document.createElement('td');
					td1.innerText = obj[field];
					tr.append(td1);
				}
				tbody.append(tr);
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
	
	
	</script>
</body>
</html>