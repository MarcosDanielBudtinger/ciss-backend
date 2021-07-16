# Projeto para fins de teste para CISS

Projeto backend em java com springboot

## Sobre o projeto

* O projeto utiliza o banco de dados PostgreSql para salvar os registros (está configurado na porta 5432)
* O projeto também utiliza FlyWay para versionamento do banco de dados
* O projeto roda na porta padrão 8080
* Como qualquer projeto spring as alterações podem ser feitas no arquivo application.properties para mudar o nome do banco de dados e porta do mesmo. (Por padrão deve-se criar um banco de dados com o nome ciss, se necessário pode alterar no arquivo).

### Objetivo do projeto
O projeto tem por objetivo criar um CRUD de funcionários.

Dos atributos do Funcionário
- Nome (Entre 2 e 30 caracteres)
- Sobrenome (Entre 2 e 50 caracteres)
- e-mail (Validar e-mail)
- Número do NIS (PIS) (Somente números)

Das funcionalidades (Utilizando APIs):
- Inserção de um Funcionário
- Exclusão de um Funcionário
- Atualização de um Funcionário
- Listagem de um Funcionário

### Endpoints

####Para buscar todos os funcionários 
- http://localhost:8080/funcionarios
