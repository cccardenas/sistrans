--RFC1
---- MOSTRAR EL DINERO RECOLECTADO POR VENTAS EN CADA SUCURSAL DURANTE UN PERIODO DE TIEMPO Y EN EL AÃ‘O CORRIDO

SELECT COUNT (VALOR_TOTAL) FROM A_FACTURA WHERE FECHA_COMPRA >= 'FECHA_INICIAL' AND 'FECHA_FINAL' >= FECHA_COMPRA GROUP BY NOMBRE_SUCURSAL;

--RFC2
--- MOSTRAR LAS 20 PROMOCIONES MÃ?S POPULARES.

SELECT CODIGO_DE_BARRAS,COUNT(ID_PROMOCION) FROM
(
SELECT A.CODIGO_DE_BARRAS, A.CANTIDAD,B.ID_PROMOCION FROM (A_FACTURA_PRODCUTOS) A INNER JOIN (A_PRODUCTO) B WHERE A.CODIGO_DE_BARRAS = B.CODIGO_DE_BARRAS
)
GROUP BY CANTIDAD;

--RFC3
---MOSTRAR EL Ã?NDICE DE OCUPACIÃ“N DE CADA UNA DE BODEGAS Y ESTANTES DE UNA SUCURSAL

SELECT IDALMACENAMIENTO,NIVEL_ABASTECIMIENTO FROM A_ESTANTE;

--RFC4
---MOSTRAR LOS PRODUCTOS QUE CUMPLEN CON CIERTA CARACTERÃ?STICA

SELECT * FROM A_PRODUCTO WHERE <CONDICION> = <CONDICION>;

--RFC5
--- MOSTRAR LAS COMPRAS HECHAS POR SUPERANDES A LOS PROVEEDORES
SELECT * FROM A_PEDIDO;

--RFC6
--- MOSTRAR LAS VENTAS DE SUPERANDES A UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO.
SELECT * FROM A_FACTURA WHERE CORREO_CLIENTE = <CORREO_USUARIO> AND FECHA_COMPRA >= <FECHA_INICIAL> AND FECHA_COMPRA <= <FECHA_FINAL>;

--ITERACION 2 --

--SQL CARRITO COMPRAS--
UPDATE A_ALMACENAMIENTO  SET CANTIDADPRODUCTOS=6 WHERE ID_ALMACENAMIENTO = 5;"

--RFC7
--- Indicar cuáles fueron las fechas de mayor demanda (mayor cantidad de productos), las de mayores ingresos (mayor cantidad de dinero recibido) y las de menor demanda.
SELECT SUM(CANTIDAD),FECHA_COMPRA FROM
(
SELECT * FROM A_FACTURA_PRODUCTO A
INNER JOIN (A_FACTURA) B
ON A.NUMERO_FACTURA = B.NUMERO_FACTURA
) GROUP BY (EXTRACT(MONTH FROM FECHA_COMPRA)),FECHA_COMPRA ORDER BY FECHA_COMPRA;

--RFC7 (MAYORES INGRESOS)
SELECT SUM(VALOR_TOTAL) AS MAYORES_INGRESOS,FECHA_COMPRA FROM
(
SELECT * FROM A_FACTURA_PRODUCTO A
INNER JOIN (A_FACTURA) B
ON A.NUMERO_FACTURA = B.NUMERO_FACTURA
) GROUP BY (EXTRACT(MONTH FROM FECHA_COMPRA)),FECHA_COMPRA ORDER BY FECHA_COMPRA;

-----
SELECT SUM(VALOR_TOTAL),FECHA_COMPRA FROM
(
SELECT * FROM A_FACTURA_PRODUCTO A
INNER JOIN (A_FACTURA) B
ON A.NUMERO_FACTURA = B.NUMERO_FACTURA
) GROUP BY (EXTRACT(MONTH FROM FECHA_COMPRA)),FECHA_COMPRA ORDER BY FECHA_COMPRA;

--RFC8
--- Encontrar la información de sus clientes frecuentes.Se considera frecuente a un cliente que ha realizado por lo menos dos compras mensuales durante todo el periodo de operación de SuperAndes.
SELECT COUNT(FECHA_COMPRA)AS NUMERO_DE_COMPRAS,CORREO_CLIENTE,FECHA_COMPRA FROM A_FACTURA WHERE SUCURSAL_NOMBRE = 'Los Flores' GROUP BY (EXTRACT(MONTH FROM FECHA_COMPRA)),CORREO_CLIENTE,FECHA_COMPRA;

--RFC9
SELECT CODIGO_DE_BARRAS_PRODUCTO, FECHA_ENTREGA, FECHA_ESPERADA FROM A_PEDIDO WHERE (FECHA_ENTREGA - FECHA_ESPERADA) >= 60;