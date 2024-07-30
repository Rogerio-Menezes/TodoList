Gerenciamento de Tarefas: Usuários podem criar, visualizar, editar e excluir tarefas. Cada tarefa pode ter um título, uma descrição, uma data de vencimento e um status (pendente, em progresso ou concluída).

Autenticação de Usuários: Implementa autenticação de usuários para garantir que cada pessoa tenha acesso apenas às suas próprias tarefas. A aplicação utiliza Spring Security para proteger rotas e permitir a autenticação de usuários.

Registro e Login: Usuários podem se registrar e fazer login na aplicação. As credenciais são armazenadas de forma segura, e sessões são gerenciadas para fornecer uma experiência de usuário fluida.

Interface Intuitiva: A aplicação possui uma interface web intuitiva onde os usuários podem facilmente interagir com suas tarefas. É projetada para ser responsiva e de fácil navegação.

Segurança: Utiliza práticas recomendadas de segurança para proteger os dados dos usuários e as operações realizadas na aplicação. O sistema de autenticação é protegido por senha criptografada e sessões seguras.

API RESTful: Oferece uma API RESTful para que outras aplicações possam interagir com o sistema de tarefas, facilitando a integração com outros sistemas ou aplicativos móveis.

Tecnologias Utilizadas
Spring Boot: Para o desenvolvimento do backend e configuração da aplicação.
Spring Security: Para a implementação de autenticação e autorização de usuários.
JPA (Java Persistence API): Para a persistência de dados e interação com o banco de dados.
H2 Database: Banco de dados em memória para desenvolvimento e testes (pode ser substituído por outro banco de dados em produção).
Maven: Para gerenciamento de dependências e construção do projeto.
Estrutura do Projeto
Controllers: Gerenciam as requisições HTTP e interagem com os serviços para realizar operações sobre as tarefas.
Repositories: Interfaces para acesso aos dados de tarefas e usuários no banco de dados.
Models: Definem as entidades de dados, como Task e User.
Security: Configurações e implementações relacionadas à segurança e autenticação.
