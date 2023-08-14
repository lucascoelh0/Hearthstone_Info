# Hearthstone Info
Este aplicativo mostra todas as cartas de Hearthstone, agrupadas por pacote.

Para rodar o projeto, é necessário criar uma variável API_KEY="SUA CHAVE AQUI" no local.properties

# Funcionalidade

O usuário pode clicar em uma carta e ver seus detalhes.

Também existe a funcionalidade de procurar cartas pelo nome e filtrar pelo set.

# Dividi o aplicativo em 4 módulos:

**Core**: possui lógica comum entre vários módulos.

**Data**: contém arquivos de serviço de API, utilitários e dtos.

**Domain**: contém a lógica de negócios do aplicativo. Possui os use cases e repositórios.

**App**: contém arquivos relacionados à UI, como composables e viewmodels.

# Bibliotecas utilizadas

Jetpack Compose

Hilt para injeção de dependência.

JUnit e MockK para testes unitários.

Retrofit e OkHttp para lidar com chamadas de api.

Gson para deserialização.

Coils para carregamento de imagens.

NetworkResponseAdapter para tratamento de chamadas de api.
