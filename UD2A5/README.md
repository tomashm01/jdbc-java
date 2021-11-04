# UD2 A5 SQL Injection y sentencias parametrizadas

## Qué es una SQL Injection. Realiza el ataque en un ejemplo que elimine un alumno por su nombre. Impleméntalo en la clase AtaqueSQLInjection

Inyección SQL es un método de infiltración de código intruso que se vale de una vulnerabilidad informática presente en una aplicación en el nivel de validación de las entradas para realizar operaciones sobre una base de datos. 

## Indica cómo solucionar una SQL Injection
 La solución genérica sería evitar que se pudieran introducir caracteres especiales (como comillas) sin haberlas transformado antes. 

## PreparedStatement. Indica su utilidad
Es una sentencia sql precompilada y se usa para prevenir sql injection.

## Indica alguno de los métodos para asignar los parámetros de las sentencias parametrizadas. 

- setString(posicion,valor)
- setInt(posicion,valor)

## Indica el número del primer parámetro, ¿0 ó 1?

1
