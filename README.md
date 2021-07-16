# Projeto para fins de teste

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

Para buscar todos os funcionários 
Verbo `GET` 
- http://localhost:8080/funcionarios

Para buscar um funcionário pelo id
- http://localhost:8080/funcionarios/id 
- exemplo: http://localhost:8080/funcionarios/1

Para buscar um funcionário por parametros
- Temos como possibilidade o envio de parametros para busca mais refinada sendo eles: nome, sobrenome, email, numeroNis.
- Para isso basta informar o atributo exemplo: sobrenome seguido de um = e a informação que deseja enviar, tambem é possível
enviar mais de um paramêtro utilizando &, seguem exemplos abaixo.

Busca pelo nome
- http://localhost:8080/funcionarios?nome=nomeaqui
- exemplo: http://localhost:8080/funcionarios?nome=marcos

Buscar pelo sobrenome
- http://localhost:8080/funcionarios?sobrenome=sobrenomeaqui
- exemplo: http://localhost:8080/funcionarios?sobrenome=budtinger

Busca composta por mais de um paramêtro
- http://localhost:8080/funcionarios?sobrenome=sobrenomeaqui&email=emailaqui
- exemplo: http://localhost:8080/funcionarios?nome=marcos&email=marcos.mdbbr@gmail.com


Para remover um funcionário
Verbo `DELETE` 
- http://localhost:8080/funcionarios/id 
- exemplo: http://localhost:8080/funcionarios/1

Para atualizar um funcionario
Verbo `PUT` 
- http://localhost:8080/funcionarios/id 
- exemplo: http://localhost:8080/funcionarios/1
- para tal é necesário enviar um json no body do seguinte formato de exemplo:
- `{
    "nome": "nome do funcionari",
    "sobrenome": "sobrenome",
    "email": "email@email.com",
    "numeroNis": "99403948761"
  }`

Para salvar um funcionário
Verbo `POST` 
- http://localhost:8080/funcionarios
- exemplo: http://localhost:8080/funcionarios
- para tal também se faz necessários mandarmos no body um json com a seguinte estrutura de exemplo:
- `{
    "nome": "nome do funcionari",
    "sobrenome": "sobrenome",
    "email": "email@email.com",
    "numeroNis": "99403948761"
  }`

