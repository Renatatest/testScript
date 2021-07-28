#Author: Renata L.
Feature: testar a funcionalidade de login

Scenario: login realizado com sucesso
Given que o usuario acessa a pagina de login
When o usuario informa o "username" e "password"
And seleciona o botao login
Then o sistema autentica o usuario
And navega para a pagina inicial
