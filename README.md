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