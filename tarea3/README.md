# Práctica 3
## 1.Pantallazo de todas las excepciones manejadas por el paquete java.sql

![](img/img1.png)

## 2.Pantallazo de la relación de herencia entre las excepciones lanzadas por el método getConnection
Primero observamos que lanza la excepción SQLException: 

![](img/img3.png)

Aquí vemos la herencia de excepciones:

![](img/img2.png)

## 3. DriverManager puede lanzar la SecurityException. Indica cuándo sucede

Es una excepción usada cuando se detecta un error de seguridad. Se produce cuando un llamador no posee permisos necesarios para acceder a un recurso.

## 4. Averigua qué clases de java.sql son Autocloseables y qué implica que lo sean a la hora de trabajar con ellas

![](img/img4.png)
Con la interfaz evitamos que los recursos sean más simples de eliminar y tener que escribir menos código y más limpio.

## 5. Indica:
1. Cursor: indica la posición actual en la lista y apunta a un objeto.
2. Posición inicial del cursor: antes de la primera fila.
3. Getters: existen de diversos tipos como enteros,cadenas,dobles,booleanos...
4. Identificación de las columnas: con un identificador formado por caracteres de enteros y letras

## 6. Ejecuta: 

```
Statement statement = connection.createStatement();
	String query = "SELECT * FROM usuario;";
	ResultSet resultSet = statement.executeQuery(query);

	while (resultSet.next()) {
	    System.out.println(resultSet.getInt("id") + " "+ resultSet.getString("nombre") + " "+
        resultSet.getString("apellidos"));
	}
```
En consola se muestra los registros(solo hay dos) ordenados: 
![](img/img5.png)
## 7. Fuentes consultadas
* [Enlace 1](https://docs.oracle.com/javase/7/docs/api/)
* [Enlace 2](https://docs.microsoft.com/es-es/dotnet/api/system.security.securityexception?view=net-5.0)
* [Enlace 3](https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html)
* [Enlace 4](https://www.arquitecturajava.com/jdbc-java-try-with-resources/)
* [Enlace 5](https://www.ibm.com/docs/es/i/7.1?topic=resultsets-cursor-movement)
