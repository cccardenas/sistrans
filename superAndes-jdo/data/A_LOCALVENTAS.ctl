load data 
infile 'A_LOCALVENTAS.csv' "str '\r\n'"
append
into table A_LOCAL_VENTAS
fields terminated by ';'
OPTIONALLY ENCLOSED BY '"' AND '"'
trailing nullcols
           ( ID_ESTANTE CHAR(30),
             ID_LOCALVENTAS,
             INGRESOS
           )
