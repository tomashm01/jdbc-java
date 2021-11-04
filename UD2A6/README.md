## UD2 A6 Transacciones

## Transacción. Indica qué es.
Una transacción es un conjunto de operaciones sobre una base de datos que se deben ejecutar como una unidad.

## Cuando una conexión se crea en JDBC trabaja en modo auto-commit (auto entrega). Indica qué significa.
Un objeto Connection por defecto realiza automáticamente cada operación sobre la base de datos. Esto significa que cada vez que se ejecuta una instrucción, se refleja en la base de datos y no puede ser deshecha. Por defecto está habilitado el modo auto-commit en la conexión.

Para iniciar una transacción deshabilitamos el modo auto-commit mediante el método setAutoCommit(false). 

## Indica los dos métodos necesarios para agrupar las sentencias SQL en una transacción

- conexion.setAutoCommit(false)
- conexion.commit()

