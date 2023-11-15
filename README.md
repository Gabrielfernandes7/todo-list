# Todolist - Spring Boot

* Entity: Criar nossas entidades (tabelas)

* Respository: Interagir com o banco de dados (MySQL)

* Services: Nossas Regras de negócio

* Controller: rotas

## Configurar o application.properties para conectar o banco de dados com a aplicação (MySQL)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<nome_do_banco>
spring.datasource.username=root
spring.datasource.password=<sua_senha_do_banco_de_dados>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Criar o banco de dados no linux (MySQL)

### Ir no terminal e digitar o seguinte comando

```bash
mysql -u root -p
```

Posteriormente, digite a senha que você configurou seu MySQL

### Listar todos os bancos de dados cadastrados

```sql
show databases;
```

### Criar o banco de dados que iremos utilizar

```sql
create database <nome_do_banco>;
```

### Utilizar o banco de dados

```sql
use <nome_do_banco>;
```

## Descrever as propriedades da tabela

```sql
desc todos; -- <nome_da_tabela>
```

No caso de nossa aplicação irá aparecer:

```
mysql> desc todos;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | bigint       | NO   | PRI | NULL    | auto_increment |
| descricao  | varchar(255) | YES  |     | NULL    |                |
| nome       | varchar(255) | YES  |     | NULL    |                |
| prioridade | int          | NO   |     | NULL    |                |
| realizado  | bit(1)       | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
5 rows in set (0,05 sec)
```

## Criar banco de dados na memória para os testes automatizados

### Adicionar o banco H2

### Criamos dentro do diretório de testes um resources

Dentro do resources devemos criar um application.properties
somente para testes.

```properties
spring.datasource.url=jdbc:h2:mem:testdb
```

### Adicionar documentação Swagger no projeto

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.1.0</version>
</dependency>
```

#### Para acessar a documentação `Swagger` da API basta ir para URL:

```
http://localhost:8080/swagger-ui/index.html
```
