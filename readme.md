# Checkpoint 2

Código do 2º checkpoint da disciplina de *Microservice and Web Engineering.*

## Informações 

**Nome:** Giovanna Vasques Alexandre

**Turma:** 3SIR

## Descrição do Projeto - Parte 2

Criação de API para responder requisições HTTP ``(POST, GET, DELETE e PUT)`` de Paciente e Profissional.

Os ``endpoints`` presentes na API são:

**PACIENTES**
- ``POST/pacientes`` - Criar Paciente;
- ``PUT/pacientes/{id}`` - Atualizar Paciente; 
- ``DELETE/pacientes/{id}`` - Deletar Paciente;
- ``GET/pacientes/{id}`` - Buscar Paciente por Id;
- ``GET/pacientes`` - Buscar todos os Pacientes;

**PROFISSIONAIS**
- ``POST/profissionais`` - Criar Profissional;
- ``PUT/profissionais/{id}`` - Atualizar Profissional; 
- ``DELETE/profissionais/{id}`` - Deletar Profissional;
- ``GET/profissionais/{id}`` - Buscar Profissional por Id;
- ``GET/profissionais`` - Buscar todos os Profissionais;

**CONSULTAS**
- ``POST/consultas`` - Criar Consultas;
- ``PUT/consultas/{id}`` - Atualizar Consultas; 
- ``DELETE/consultas/{id}`` - Deletar Consultas;
- ``GET/consultas/{id}`` - Buscar Consultas por Id;
- ``GET/consultas`` - Buscar todos os Consultas;
- ``GET/consultas/query`` - Buscar as consultas por status;

## Classes Criadas

### Model

Para mapeamento de entidades do banco de dados.

### Controller

Gerencia as requisições HTTP direcionando-as para os serviços adequados.

### DTO

Transporta dados entre camadas de aplicação.

### Service

Contém a lógica de negócio.

### Repository

Acessa o banco de dados e executa operações como salvar, buscar e deletar dados.

## Instalação

- Configuração do Swagger
    - https://springdoc.org/properties.html

- application.properties
    
    ```
    spring.application.name=checkpoint1
    springdoc.swagger-ui.path=/
    ```

## Docker 

### Conexões com BD - Criação de Container

- My SQL

	```
	docker run -d \
		--name mysql \
		--rm \
		-e MYSQL_ROOT_PASSWORD=root_pwd \
		-e MYSQL_USER=new_user \
		-e MYSQL_PASSWORD=my_pwd \
		-p 3306:3306 \
		mysql
	```

## Dependências Utilizadas

### *MySQL*
Banco de dados usado para armazenar as informações da aplicação.

### *JPA*
Facilita o uso de objetos Java para acessar e manipular dados no banco.

### *Spring Web*
Permite criar APIs REST e aplicações web com o Spring.

### *Spring DevTools*
Recarrega a aplicação automaticamente após alterações no código.

### *Swagger*
Gera uma documentação interativa da API para facilitar testes e uso.


## Navegação

### Executar a API
- *Executando* **Maven**

    ```
    mvn spring-boot:run
    ```