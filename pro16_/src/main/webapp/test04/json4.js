$(function(){
	
	let name = "홍길동";
	let age = 20;
	let gender = "남자";
	
	let info = "이름 : " +name + "나이 : " + age + "성별 : " + gender;
	let info2 = `이름 : ${name}, 나이 : ${age}, 성별 : ${gender}`;
	console.log(info2)
	
	let test = "임의의값";
	$('#checkjson').on('click', function(){
		let jsonStr = `{
			"members" : [
				{"name" : "박지성", "age" : "25", "gender" : "남자", "nick" : "두개의 심장"},
				{"name" : "안정환", "age" : "27", "gender" : "남자", "nick" : "테리우스"}
			],
			"coach" : [
				{"name" : "히딩크", "age" : "50", "gender" : "남자", "nick" : "히동구"},
				{"name" : "박항서", "age" : "40", "gender" : "남자", "nick" : "베트남국민영웅"}
			]
		}`;
		
		let jsonInfo = JSON.parse(jsonStr);
		let members = "선수 정보<br>"
		members += "=========================<br>"
		for(let m of jsonInfo.members){
			members += `이름 : ${m.name}, 나이 : ${m.age}, 성별 : ${m.gender}, 별명 : ${m.nick} <br>`;
		}
		$('.members').html(members);
		
		let coach = "<br>코치 정보<br>"
		coach += "=========================<br>"
		for(let c of jsonInfo.coach){
			coach += `이름 : ${c.name}, 나이 : ${c.age}, 성별 : ${c.gender}, 별명 : ${c.nick} <br>`;
		}
		$('.coach').html(coach);
		
	}); // on end
}); // end