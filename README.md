# Api de cadastro de produtos documentada com swagger

Nessa api foi utilizado conhecimentos sobre Data Transfer Object, Rest, Validações e documentação com swagger, aplicado em um crud simples de cadastro de produtos.

## Endpoints

## BaseUrl: /produtos
	-Post: Create();
	
	-Get: findAll();
	
	-get/{id}: findById;
	
	-Put/{id}: update();
	
	-Delete/{id}: delete();

## Model
	{
	    "id": 1,
	    "nome": "iphone",
	    "descricao": "celular super pontente",
	    "valor": 5000
	 }
	 
Para iniciar o projeto e preciso clonar o projeto, e ter o java instalado também é preciso ter o lombook.


Para acessar a documentação pelo swagger é so acessar a url: http://localhost:8080/swagger-ui.html#