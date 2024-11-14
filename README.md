![image](https://github.com/user-attachments/assets/1d03fb76-eb68-4371-95ba-3fdc74ab1ac4)

# ProjetoFatto - Sistema de Lista de Tarefas (Back-End)

Este projeto foi desenvolvido como parte de uma etapa do processo seletivo da empresa **Fatto**. Trata-se do **back-end** de um sistema web para gerenciamento de tarefas. O objetivo principal foi implementar as funcionalidades de **Cadastro**, **Edição**, **Exclusão**, e **Reordenação** de tarefas, utilizando **Java**, **Spring Boot**, **JPA**, **Flyway** e **MySQL**.

## Descrição do Sistema

O sistema de lista de tarefas permite o cadastro e manipulação das tarefas em um banco de dados, oferecendo uma API REST para realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) nas tarefas. A interface de usuário (front-end) não foi desenvolvida neste projeto, sendo implementado apenas o **back-end**.

### Estrutura da Tabela

A tabela **Tarefas** possui os seguintes campos:

- **Identificador da Tarefa (ID)**: chave primária do registro.
- **Nome da Tarefa**: nome único da tarefa.
- **Custo (R$)**: custo associado à tarefa.
- **Data Limite**: data de conclusão da tarefa.
- **Ordem de Apresentação**: número único que define a ordem de exibição das tarefas.

### Funcionalidades Implementadas (Back-End)

1. **Listar Tarefas** (`GET /tarefas`)
   - Endpoint para listar todas as tarefas registradas no banco de dados.
   - As tarefas são retornadas ordenadas pelo campo **Ordem de Apresentação**.

2. **Criar Tarefa** (`POST /tarefas`)
   - Endpoint para cadastrar uma nova tarefa.
   - Campos necessários: **Nome da Tarefa**, **Custo** e **Data Limite**.
   - O **Identificador** e **Ordem de Apresentação** são gerados automaticamente.

3. **Editar Tarefa** (`PUT /tarefas/{id}`)
   - Endpoint para editar uma tarefa existente.
   - Campos editáveis: **Nome da Tarefa**, **Custo** e **Data Limite**.
   - Verificação de unicidade do nome da tarefa: não pode haver duas tarefas com o mesmo nome.

4. **Excluir Tarefa** (`DELETE /tarefas/{id}`)
   - Endpoint para excluir uma tarefa.
   - Ao excluir, a tarefa é removida permanentemente do banco de dados.

5. **Reordenação de Tarefas** (não implementado diretamente no back-end, mas a lógica está disponível para ser usada no front-end)
   - Permite que a ordem de apresentação das tarefas seja alterada, ajustando o campo **Ordem de Apresentação**.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.5**: Framework principal utilizado para o desenvolvimento da aplicação.
- **Spring Data JPA**: Para manipulação e persistência das tarefas no banco de dados.
- **MySQL**: Banco de dados utilizado para armazenar as tarefas.
- **Flyway**: Ferramenta para gerenciamento de migrações do banco de dados.
- **Lombok**: Biblioteca utilizada para reduzir o código boilerplate em classes Java.

