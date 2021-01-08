var btn = document.getElementById('btn'),
    btn_no = document.getElementById('btn_no'),
    caja = document.getElementById('celda'),
    contador = 0;

    function cambio(){
        if(contador==0){
            caja.classList.add('azul');
            contador=1;
        }else {
            caja.classList.remove('azul');
            contador=0;
        }
    }

    function cambioRojo(){
        if(contador==0){
            caja.classList.add('rojo');
            contador=1;
        }else {
            caja.classList.remove('rojo');
            contador=0;
        }
    }

    btn.addEventListener('click',cambio,true)
    btn_no.addEventListener('click',cambioRojo,true)