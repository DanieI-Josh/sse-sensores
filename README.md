# SSE Sensores

Aplicação desenvolvida para a disciplina **ADS1242 – Mensageria e Streams em Aplicações** da **PUC Goiás**.

O projeto utiliza **Server-Sent Events (SSE)** para transmitir leituras de temperatura em tempo real de sensores simulados para uma interface web desenvolvida com HTML, CSS e JavaScript.

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Web
* Server-Sent Events (SSE)
* HTML5
* CSS3
* JavaScript
* Maven

## Funcionalidades

* Comunicação em tempo real utilizando SSE.
* Simulação de sensores de temperatura.
* Atualização automática da interface sem recarregar a página.
* Monitoramento de três sensores:

  * Sala
  * Server
  * Externo
* Indicador de status da conexão SSE.

## Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   └── br.pucgoias.sse_sensores
│   │       ├── config
│   │       │   └── AsyncConfig.java
│   │       ├── controller
│   │       │   └── EventoController.java
│   │       ├── model
│   │       │   └── LeituraTemperatura.java
│   │       ├── service
│   │       │   ├── EventoService.java
│   │       │   └── SensorSimulador.java
│   │       └── SseSensoresApplication.java
│   └── resources
│       └── static
│           └── index.html
```

## Endpoints

### Stream de Eventos

```http
GET /sensores/stream
```

Retorna um fluxo contínuo de eventos SSE contendo informações dos sensores.

### Exemplo de Evento

```text
id: 1781568746175
event: temperatura
data: {
  "sensor":"sala",
  "valor":24.86,
  "timestamp":1781568746175
}
retry:3000
```

## Como Executar

### Clonar o repositório

```bash
git clone <url-do-repositorio>
```

### Acessar o projeto

```bash
cd sse-sensores
```

### Executar a aplicação

Windows:

```bash
.\mvnw.cmd spring-boot:run
```

Linux/Mac:

```bash
./mvnw spring-boot:run
```

## Acessar a aplicação

Interface:

```text
http://localhost:8080
```

Stream SSE:

```text
http://localhost:8080/sensores/stream
```

## Autor

Daniel Josh Santos

ADS – Análise e Desenvolvimento de Sistemas

PUC Goiás
