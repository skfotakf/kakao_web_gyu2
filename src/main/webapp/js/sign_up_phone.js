const item_ip = document.querySelector('.item_ip');
const btn_g = document.querySelector('.btn_g');
const button_round = document.querySelcetor('.button_round');
const submit_flag = document.querySelector('#submit_flag');
const flag = document.querySelector('#flag');

if (flag == 0 ){
	const msg1 = document.querySelector('.msg1');
	const msg2 = document.querySelector('.msg2');
	const msg3 = document.querySelector('.msg3');
	msg1.style.display = "none";
	msg2.style.display = "none";
	msg3.style.display = "block";
} else if(flag == 1){
	
}

item_ip.onkeypress = () =>{
	if(window.event.keyCode == 13) {
		window.event.preventDefault();
		onSubmit();
	}
}
btn_g.onclick = () =>{
	submit_flag.value = 1;
	onSubmit();
}

button_round.onclick = () => {
	submit_flag.value = 2;
	onSubmit();
}

function onSubmit(){
	
	const msg1 = document.querySelector('.msg1');
	
	if(item_ip.value.length == 0){
		msg1.style.display = 'block';
		
	} else {
		
		const form = document.querySelector('form');
		form.submit();
		
	}
}
