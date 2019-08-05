# fuzzy-service

API Rest con las operaciones:
1) GET http://localhost:8080/list
2) POST http://localhost:8080/add  {\"name\":\"Manuela Torres\"}
3) POST http://localhost:8080/fuzzy-search

Para la búsqueda se utilizó el algoritmo de Levenshtein debido a que se utiliza amplimente en programas de edición y correción de textos
para determinar que tan similares son dos cadenas de caracteres. El algoritmo cuenta el número de operaciones requeridas para transformar
una cadena de caracteres en otra. En nuestro programa, se utilizó para medir el nombre con el menor número de operaciones requeridas para 
transformarse en el parámetro de búsqueda.

Para ejecutar las operaciones desde línea de comandos, se agrega el programa application.bat:
1) application list
2) application add {\"name\":\"Manuela Torres\"}
3) application fuzzy-search {\"search\":\"Manuela\"}