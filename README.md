# Sistema Bancário em Java

Sistema bancário desenvolvido em Java com foco no estudo de Programação Orientada a Objetos, Collections e tratamento de exceções.

O projeto simula operações bancárias básicas através de um menu interativo no terminal.

---

# Funcionalidades

* Cadastro de contas bancárias
* Busca de contas pelo número
* Consulta de saldo
* Depósitos
* Saques
* Exibição dos dados da conta
* Listagem de contas cadastradas

---

# Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* Encapsulamento
* Classes e Objetos
* Collections (`HashMap`)
* Estruturas condicionais e de repetição
* Tratamento de exceções (`try/catch`)
* Exceções personalizadas

---

# Uso do HashMap

O sistema utiliza um `HashMap<Integer, Conta>` para armazenar as contas bancárias utilizando o número da conta como chave.

Isso permite:

* busca rápida de contas
* organização eficiente dos dados
* prevenção de contas duplicadas

---

# Tratamento de Exceções

O projeto foi criado principalmente para praticar o tratamento de exceções em Java.

Foi implementada a exceção personalizada `BusinessException` para tratar regras de negócio inválidas.

Exemplos de validações:

* saldo insuficiente
* saque acima do limite permitido
* conta já cadastrada
* operações inválidas

As exceções são tratadas utilizando `try/catch`, evitando que o programa seja encerrado inesperadamente.

---

# Tecnologias

* Java
* IntelliJ IDEA

---

# Objetivo

Praticar conceitos fundamentais de Java e Programação Orientada a Objetos, com foco em Collections e tratamento de exceções.
