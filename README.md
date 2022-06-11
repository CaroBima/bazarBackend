# Bazar
Backend de manejo de stock de productos de un bazar. Trabajo final de curso de SpringBoot de Todo Code

## Resolución de los ejercicios de Hackerrank / Solutions to Hackerrank practice problems 


* [Escenario](#escenario)
* [Modelado](#modelado)
* [Requerimientos](#requerimientos)


# Escenario 
Un bazar ha incrementado en gran medida sus ventas. Dado esto y que le está siendo casi imposible registrar las mismas y manejar el stock de sus productos de forma manual, necesita del desarrollo de una aplicación que le permita realizar esta tarea. 
La dueña del bazar manifiesta que todas las operaciones que tenga la aplicación se deben poder realizar mediante dos tipos de clientes http distintos: <br> 
•	Una aplicación web, cuyo frontend desarrollará un programador amigo (no será parte de nuestra tarea como desarrolladores backend). <br>
•	Una aplicación Mobile que será implementada a futuro. <br>
<br>
Cada una de estas app representa a los dispositivos que ella y sus empleados manejan actualmente. En síntesis: una computadora y varios celulares. 
Dada esta situación particular y de que necesita utilizar el <strong>mismo backend</strong> para ambas opciones, <strong>solicita el desarrollo de una API</strong>. 
<br>
<br>

# Modelado 
A partir del relevamiento que ha llevado a cabo un analista funcional, se detectaron que serán necesarias las siguientes clases: <br>
•	Producto <br>
•	Venta <br>
•	Cliente <br><br>
En donde cada venta posee una lista de productos y uno y solo un cliente asociado. Además de eso, cada clase debe tener los siguientes atributos: <br> <br>
<strong>Producto </strong> <br>
•	Long codigo_producto  <br>
•	String nombre  <br>
•	String marca  <br>
•	Double costo  <br>
•	Double cantidad_disponible  <br> <br>
<strong>Venta </strong> <br> 
•	Long codigo_venta  <br>
•	LocalDate fecha_venta  <br>
•	Double total  <br>
•	List<Producto> listaProductos  <br>
•	Cliente unCliente  <br> <br>
<strong>Cliente </strong> <br> 
•	Long id_cliente  <br>
•	String nombre  <br>
•	String apellido  <br>
•	String dni  <br>

# Requerimientos 

  A partir del relevamiento realizado respecto al modelado, la dueña del bazar especificó que tiene los siguientes requerimientos: <br> <br>
 
1.	<strong>Poder realizar un CRUD completo de productos </strong> <br>
  a.	<strong>Métodos HTTP:</strong> GET, POST, DELETE, PUT  <br>
  b.	<strong>Endpoints:</strong>  <br>
    <strong>Creación:</strong> localhost:8080/productos/crear <br>
    <strong>Lista completa de productos:</strong> localhost:8080/productos <br>
    <strong>Traer un producto en particular: </strong> localhost:8080/productos/{codigo_producto} <br>
    <strong>Eliminación:</strong> localhost:8080/productos/eliminar/{codigo_producto} <br>
    <strong>Edición:</strong> localhost:8080/productos/editar/{codigo_producto} <br>
<br>

2.	<strong>Poder realizar un CRUD completo de clientes </strong><br>
  a.	<strong>Métodos HTTP:</strong> GET, POST, DELETE, PUT <br>
  b.	<strong>Endpoints:</strong>  <br>
<strong>Creación:</strong> localhost:8080/clientes/crear <br>
<strong>Lista completa de clientes:</strong> localhost:8080/clientes <br>
<strong>Traer un cliente en particular::</strong> localhost:8080/clientes/{id_cliente} <br>
<strong>Eliminación::</strong> localhost:8080/clientes/eliminar/{id_cliente} <br>
<strong>Edición::</strong> localhost:8080/clientes/editar/{id_cliente} <br>
 <br>
  
3.	<strong>Poder realizar un CRUD completo de ventas </strong><br>
a.	<strong>Métodos HTTP:</strong> GET, POST, DELETE, PUT <br>
b.<strong>	Endpoints:  </strong><br>
<strong>Creación:</strong> localhost:8080/ventas/crear <br>
<strong>Lista completa de ventas realizadas:</strong> localhost:8080/ventas <br>
<strong>Traer una venta en particular:</strong> localhost:8080/ventas/{codigo_venta} <br>
<strong>Eliminación:</strong> localhost:8080/clientes/eliminar/{codigo_venta} <br>
<strong>Edición:</strong> localhost:8080/clientes/editar/{codigo_venta} <br>
 <br>
 
Nota: No es necesario para este requerimiento actualizar el stock de un producto (descontar) al realizar una venta, ni tampoco controlar si cuenta con la cantidad disponible para vender; sin embargo, se considerará como “plus” o extra (para el bonus del punto 8) si se desea implementar la funcionalidad. 
 
4.	Obtener todos los productos cuya cantidad_disponible sea menor a 5 
a.	Métodos HTTP: GET 
b.	Endpoint:  
localhost:8080/productos/falta_stock 
 
5.	Obtener la lista de productos de una determinada venta 
a.	Métodos HTTP: GET 
b.	Endpoint:  
localhost:8080/ventas/productos/{codigo_venta} 
 	 
 
6.	Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día 
a.	Métodos HTTP: GET 
b.	Endpoint:  
localhost:8080/ventas/{fecha_venta} 
 
7.	Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el apellido del cliente de la venta con el monto más alto de todas.  
a.	Métodos HTTP: GET 
b.	Endpoint:  
localhost:8080/ventas/mayor_venta 
Tener en cuenta patrón DTO para este escenario  
8.	BONUS (OPCIONAL) 
a.	Se considera bonus cualquier propuesta de end-point, mejora, agregado de clase, etc que se proponga e implemente. 
b.	Este apartado es opcional y pretende dejar volar la creatividad a la hora de proponer qué otras necesidades/requerimientos podrían existir en este escenario. 
c.	En caso de llevar a cabo este punto, especificar en un documento el/los nuevo/s requerimientos planteados y sus correspondientes especificaciones técnicas (método HTTP, endpoint, etc). Tomar como ejemplo de plantilla para la especificación a las consignas de este enunciado. 
