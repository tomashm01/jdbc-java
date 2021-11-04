# Actualización mediante INSERT,UPDATE o DELETE

## 1.Indicar verdadero o falso
1. Un objeto ResultSet predeterminado no es actualizable y tiene un cursor que sólo se mueve hacia adelante. Es verdadero.
2. Todos los objetos ResultSet pueden actualizarse y/o moverse (moverse del final al principio con el cursor). Es falso.
3. En un objeto ResultSet scrollable, el cursor puede moverse delante y atrás. Es verdadero.
4. Los métodos update de ResultSet sólo permiten identificar la columna por su nombre y por su número (0..totalColumnas-1). Es verdadero.
5. Los métodos update devuelven un booleano para indicar o no que la actualización se ha realizado. Es falso.
6. Los métodos de actualización "update*"se utilizan para actualizar los valores de columna en la fila actual o la fila de inserción. Es verdadero.
7. Los métodos de actualización "update*" no actualizan la base de datos subyacente; en su lugar, se llama a los métodos updateRow o insertRow para actualizar la base de datos. Es verdadero.
8. El método updateRow actualiza la tabla de origen de datos de la que se derivó el ResultSet. Es verdadero.

## Indica los campos del ResultSet y su significado



## Indica el tipo de los objetos ResultSet obtenidos a raíz de createStatement() sin parámetros. 

- TYPE_FORWARD_ONLY
- TYPE_SCROLL_INSENSITIVE
- TYPE_SCROLL_SENSITIVE

## Además del método next, existen otros métodos para mover el cursor. Indícalos.

- previous
- first
- last
- beforeFirst
- afterLast
- relative
- absolute

## Indica si al igual que los métodos getxxx, los métodos updatexxx están sobrecargados

Si, por ejemplo:
- updateBigDecimal(int column,BigDecimal x) está sobrecargado porque existe también updateBigDecimal(String colum,BigDecimal x)

