# ToolsChallenge
Simulação de um Api de Pagamento

Criação de uma API seguindo os princípios REST, utilizando JSON para a transferência de dados e o padrão HTTP para as respostas às requisições.

A API foi desenvolvida com o Framework Spring Boot e Java 17, e o banco de dados utilizado é o PostgreSQL, operando em um contêiner Docker. Foi criada uma migração para inicializar a tabela "Transacao" no banco de dados, e testes unitários foram implementados para garantir a qualidade do código.

A API emprega o Spring Data para realizar consultas no banco de dados. Utilizam-se objetos de entrada para receber as requisições, que são convertidos em entidades para serem persistidas ou consultadas no banco de dados. Após o processamento, as entidades são convertidas em objetos de saída para fornecer as respostas.

Dessa forma, as entidades são preservadas e apenas elas têm acesso direto à camada de repositório.
