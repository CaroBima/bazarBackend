# Bazar
Backend de manejo de stock de productos de un bazar. Trabajo final de curso de SpringBoot de Todo Code

## Escenario 
Un bazar ha incrementado en gran medida sus ventas. Dado esto y que le está siendo casi imposible registrar las mismas y manejar el stock de sus productos de forma manual, necesita del desarrollo de una aplicación que le permita realizar esta tarea. 
La dueña del bazar manifiesta que todas las operaciones que tenga la aplicación se deben poder realizar mediante dos tipos de clientes http distintos: <br> 
•	Una aplicación web, cuyo frontend desarrollará un programador amigo (no será parte de nuestra tarea como desarrolladores backend). <br>
•	Una aplicación Mobile que será implementada a futuro. <br>
<br>
Cada una de estas app representa a los dispositivos que ella y sus empleados manejan actualmente. En síntesis: una computadora y varios celulares. 
Dada esta situación particular y de que necesita utilizar el <strong>mismo backend</strong> para ambas opciones, <strong>solicita el desarrollo de una API</strong>. 
<br>
<br>

## Modelado 
A partir del relevamiento que ha llevado a cabo un analista funcional, se detectaron que serán necesarias las siguientes clases: <br>
•	Producto <br>
•	Venta <br>
•	Cliente <br><br>
En donde cada venta posee una lista de productos y uno y solo un cliente asociado. Además de eso, cada clase debe tener los siguientes atributos: <br>
