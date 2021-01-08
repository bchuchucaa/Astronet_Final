		function acceso(){
			var dep=document.getElementById("dep");
			var dir='Radio';
			var boton=document.getElementById("boton");
			var boton1=document.getElementById("boton12");
			if(dep.innerText != 'Radio'){
				alert("Bloqueado no tienes los permisos establecidos contacte con tu administrador")
					boton.disabled=true;
				boton1.disabled=true;
					
				}
			else{
				alert("Bievenido");
				boton.disabled =false;
				boton1.disabled=false;
				
				}
			}