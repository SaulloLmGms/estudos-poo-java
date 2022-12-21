
## Maven

- [Maven documentantion](https://maven.apache.org/install.html)
- [Setup to windows](https://phoenixnap.com/kb/install-maven-windows)


## Install dependencies

``` 
mvn install
```

### Questions

1 - ✅ Crie	a	classe	ClientePJ,	que	herda	da	classe	Cliente,	sabendo	que	seu	
método	getId()	deve	retornar	o	CNPJ do	cliente pessoa	jurídica.

2 - ✅ Implemente	os	métodos	`existeCliente`,	`pesquisaCliente` e
`pesquisaProdutosDaCategoria` da	classe	`SistemaComercialMap` sabendo	
que	a	chave	do	Map	de	clients	é	o	identificador	do	cliente,	obtido	por	getId(). O	
método	pesquisaCliente lança	a	exceção	`ClienteNaoExisteException` caso	
não	exista	cliente	com	o	Id	indicado.


3 - ✅ Complemente o teste abaixo para a classe `SistemaComercialMap` que
cadastre um produto da categoria` CategoriaProduto.ALIMENTO` e depois verifique
que esse produto cadastrado existe e também deve verificar que a quantidade de
produtos da categoria alimento é 1.

4 - ✅  Você identifica algum método polimórfico no sistema comercial apresentado? Se
sim, qual? Justifique sua resposta.
  - `SistemaComercialMap`, porque todos as outras classes concretas usam herança com a chamada do `extends`, enquanto essa classe usa o  `implements` para se apropriar e sobrescrever os metodos da interface `Sistema`