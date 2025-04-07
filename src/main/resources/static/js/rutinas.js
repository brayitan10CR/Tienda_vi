//esta funcion carga una imagen local en la pagina html 
//semana 6

function readURL (input) {
    if (input.files && input.files[0]){
        //nos pasaron un archivo de imagen
        var lector = new FileReader();
        lector.onload = function(e){
          $('#blah').attr('src',e.target.result)
                  .height(200);
        };
        
        lector.readAsDataURL(input.files[0]);
    }
}

//esta funcion carga en el carrito de compras un producto seleccionado por el usuario
//en caso de emergencia     window.alert("Estamos en la funcion...");
function addCart(formulario){
    var idProducto = formulario.elements[0].value;
    var existencias = formulario.elements[1].value;
    if (existencias>0){
        //se incluye el producto en el carrito
        var ruta = "/carrito/agregar/"+idProducto;
        $("#resultBlock").load(ruta); //esto ejecuta el url que está arriba
        
    } else {
        window.alert("No hay existencias...");
    }
}


