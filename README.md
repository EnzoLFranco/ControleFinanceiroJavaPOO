# Aplicativo de Controle de Transações Financeiras (Simulação POO em Java)

Este projeto simula um aplicativo de controle de transações financeiras, com foco na aplicação de conceitos de Programação Orientada a Objetos (POO) utilizando a linguagem Java. Ele foi desenvolvido para demonstrar a estrutura de um sistema financeiro simplificado, aplicando princípios de design de software e boas práticas de desenvolvimento.

## Funcionalidades Principais

* **Gerenciamento de Transações:** Capacidade de registrar diferentes tipos de transações financeiras.
* **Controle de Entidades:** Estrutura de classes para representar entidades do sistema com herança e composição.
* **Repositório em Memória:** Simulação de persistência de dados em memória, utilizando repositórios para gerenciar as entidades.
* **Interação via Console:** Interface de usuário baseada em console para interação com o sistema através de menus e fluxos interativos.

## Conceitos e Tecnologias Aplicadas

Durante o desenvolvimento deste projeto, os seguintes conceitos e tecnologias foram aplicados e exercitados:

* **Programação Orientada a Objetos (POO):** Abstração, Encapsulamento, Herança e Polimorfismo foram amplamente utilizados para estruturar o código e representar o domínio do problema.
* **Estrutura de Entidades:** Implementação de um modelo de entidades robusto, fazendo uso de **Herança** (para especializar tipos de entidades) e **Composição** (para construir entidades complexas a partir de outras).
* **Simulação de Persistência:** Criação de **repositórios em memória** para simular o armazenamento e a recuperação de dados, sem a necessidade de um banco de dados real, focando na lógica de negócio.
* **Boas Práticas de Código:**
    * **Lombok:** Utilização da biblioteca Lombok para reduzir o boilerplate code (código repetitivo) em classes Java (ex: getters, setters, construtores).
    * **Enums (Enumeradores):** Aplicação de enums para definir conjuntos fixos de constantes (ex: tipos de transação, categorias), melhorando a legibilidade e a segurança do código.
    * **Records (Java 16+):** Uso de records para criar classes de dados concisas e imutáveis, ideais para representar dados que não mudam após a criação.
* **Interatividade via Console:** Construção de **menus e fluxos interativos** no console para simular a experiência de usuário de um aplicativo.
* **Documentação Técnica:** Foco na **documentação clara e estruturada** dos processos técnicos e da arquitetura do projeto.
* **Git e GitHub:** Utilização do Git para controle de versão e do GitHub como ferramenta para **compartilhamento e versionamento da documentação técnica e do código**.
