xhr = new XMLHttpRequest();
xhr.open('get','servlet-test',true)
xhr.onreadystatechange = ()=>{
    if( xhr.readyState === 4 && xhr.status === 200 ){
        const students = JSON.parse( xhr.responseText)
        console.log( xhr.responseText)
       // students.forEach( student => alert(`${student.code} ${student.surname} ${student.name}`))
    }
}
xhr.send(null)


document.getElementById('Enviar').addEventListener('click',()=>{

    const code= document.getElementById('code').value;
    const sport= document.getElementById('deporte').value;
    const name= document.getElementById('nombre').value;
    const activity= document.getElementById('actividad').value;

    const xhr = new XMLHttpRequest();
    xhr.open('POST','servlet-test',true)
    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
          //  alert(xhr.responseText)

        }
    }
    const data = `code=${code}&sport=${sport}&name=${name}&activity=${activity}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send( data )
    alert("Elemento agregado")
    //alert(data)

})

document.getElementById('delete').addEventListener('click',()=>{
    const code= document.getElementById('codeSearch1').value;
    //alert(code)
    const xhr = new XMLHttpRequest();
    xhr.open('GET','servlet-test?code='+code,true)
    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            //alert(xhr.responseText)
        }
    }
    const data = `code=${code}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send( data )
    //alert(data)
    alert("Estudiante  Eliminado")

})

document.getElementById('Buscar').addEventListener('click',()=> {
    const code1= document.getElementById('codeSearch').value;
    const xhr = new XMLHttpRequest();
    xhr.open('GET','servlet-test?code1='+code1,true)
    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
           var xd= JSON.parse(xhr.responseText)
            var encuentra=false;
            xd.forEach(s=>{
                if (code1==s.code){
                    alert(s.name+ " " + s.code)
                    encuentra=true;
                }
            })
            if (encuentra==false){
                alert("No Existe en la lista")
            }

        }
    }
    const data = `code=${code1}`;
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send( data )
    //alert(data)




})

