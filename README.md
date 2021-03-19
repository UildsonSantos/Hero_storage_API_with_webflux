
# Bootcamp da digital innovation one - spring webflux - Criando uma API REATIVA para gerenciamento de herois

## Principios utilizados

* Responsivo
    * O sistema responde em tempo hábil, se posivel
* Resiliente
    * O sistema permanece responsivo diante de falhas
* Elastico
    * O sistema permanece responsivo diante de uma carga de trabalho variavel, ou seja, a escalabilidade como uma das caracteristica por natureza.
* Message Driven
    * O sistema deve ser orientado a mensagens ou evento, pois as aplicações 
      reativas dependem da passagem de mensagens assicronas para estabelecer um limite entre os componentes, garantindo um acoplemento flexível, isolamento e transparencia.
    
## Stack utilizadas

* Java 8
* Maven
* spring webflux
* Spring data
* Amazon dynamodb
* AWS CLI (para comunicação local com dynamodb)
* Swagger
* JUnit
* Postman
* SLF4J
* Reactor (Criada pela Netflix)


Executar dynamo: 

 java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
 
 aws dynamodb list-tables --endpoint-url http://localhost:8000


swagger: http://localhost:8080/swagger-ui-heroes-reactive-api.html
