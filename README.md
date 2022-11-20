# Mock Payments - Project

<img src="https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white" />

Este projeto tem por finalidade, estudar tecnologias emergentes.

Este projeto consiste em mockar um 'Pagamento', via AWS SQS, ele possui um scheduler que irá
executar automaticamente a publicação de mensagens para a fila SQS.

PS, este projeto pode ser compartilhado(INFRA) com outro projeto estudado que irá consumir estes eventos gerados
por este microserviço

### Subindo o ambiente - Localstack
Para conseguir executar o ambiente com sucesso, você deverá possuir
os seguintes programas instalados na sua maquina:

| Programa                                                                                                       | Link para Download                     |
|----------------------------------------------------------------------------------------------------------------|----------------------------------------|
| <img src="https://img.shields.io/badge/Terraform-7B42BC?style=for-the-badge&logo=terraform&logoColor=white" /> |  [Terraform](https://www.terraform.io/)     |
| <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" />       | [Docker](https://www.docker.com/) |  

Após estes programas instalados, poderemos prosseguir com os seguintes passos:

1. Suba o Docker.
2. Execute o comando, na seguinte pasta /infra: `docker compose up . `.
3. Acesse a pasta tf.
4. Execute o arquivo start_tf.sh
5. Digite: YES
6. Aguarde o final do processamento e criação da infra.


### Setando o seguinte profile
``
-Dspring.profiles.active=localstack
``

### Projeto Consumidor
[Github - KafkaPub](https://github.com/armandorafaelc/kafkapub)