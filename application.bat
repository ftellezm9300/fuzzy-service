@echo off 
if %1%==list (
	curl -X GET http://localhost:8080/list
	echo:
) else if %1%==add (
	curl -X POST -H "Content-type: application/json" http://localhost:8080/add -d  %2%
	echo Usuario agregado
	echo:
)else if %1%==fuzzy-search (
	curl -X POST -H "Content-type: application/json" http://localhost:8080/fuzzy-search -d  %2%
	echo:
)


