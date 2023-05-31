
# Projet Stock Magasin
## Auteur

- [@ThomasLC-Dev](https://github.com/ThomasLC-Dev) (LE CORVEC Thomas)
## Présentation

Ce projet concerne la création d'un système de gestion des stocks pour un magasin, ainsi que la prise de commande.
Il s'agit ici d'un rendu sous le format d'une API REST.
## Développement

**API:** Java, Spring boot

**Base de données:** PostgreSQL
## Lancer l'application

Cloner le projet

```bash
  git clone https://github.com/ThomasLC-Dev/Stock_Magasin.git
```

Modifier le fichier application.properties avec les données de votre base de données, à la place des instructions entre accolades.
```bash
  spring.datasource.url=jdbc:postgresql://{HOTE_DB}:{PORT_DB}/{NOM_DB}
  spring.datasource.username={UTILISATEUR_DB}
  spring.datasource.password={MDP_DB}
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
  spring.jpa.properties.hibernate.jdbc.time_zone=UTC+1

  server.port=8081
  server.error.include-message=always

  spring.jackson.default-property-inclusion = NON_NULL
```

Build l'application

```bash
  mvn install
```

Démarrer l'application

```bash
  java -jar target/stock-0.0.1-SNAPSHOT.jar
```


## Documenation API

### Produits

#### Récupérer tous les produits

```http
  GET /products
```

#### Récupérer un produit

```http
  GET /products/{productId}
```

| Paramètre     | Type     | Description                |
| :--------     | :------- | :------------------------- |
| `productId`   | `long`   | ID du produit              |

#### Créer un produit

```http
  POST /products
```
```json
  {
      "name": "string",
      "price": "double",
      "quantity": "integer"
  }
```

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | Nom du produit                    |
| `price`   | `double` | Prix du produit                   |
| `quantity`| `integer`| Quantité du produit               |

#### Modifier un produit

```http
  PUT /products/{productId}
```
```json
  {
      "name": "string",
      "price": "double",
      "quantity": "integer"
  }
```

| Paramètre     | Type     | Description                |
| :--------     | :------- | :------------------------- |
| `productId`   | `long`   | ID du produit              |

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | Nom du produit                    |
| `price`   | `double` | Prix du produit                   |
| `quantity`| `integer`| Quantité du produit               |

#### Supprimer un produit

```http
  DELETE /products/{productId}
```

| Paramètre     | Type     | Description                |
| :--------     | :------- | :------------------------- |
| `productId`   | `long`   | ID du produit              |

### Commandes

#### Récupérer toutes les commandes

```http
  GET /orders
```

#### Récupérer une commande

```http
  GET /orders/{orderId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `orderId` | `long`   | ID de la commande          |

#### Créer une commande

```http
  POST /orders
```

```json
  {
      "customerName": "string",
      "products": [
          {
              "productId": "long",
              "quantity": "integer"
          },
          {
              "productId": "long",
              "quantity": "integer"
          }
      ]
  }
```

| Body              | Type     | Description              |
| :--------         | :------- | :------------------------|
| `customerName`    | `string` | Nom du client            |
| `products`        | `Array`  | Tableau de produits      |
| `productId`       | `long`   | ID du produit            |
| `quantity`        | `integer`| Quantité du produit      |

#### Modifier une commande

```http
  PUT /orders/{orderId}
```
```json
  {
      "customerName": "string",
      "products": [
          {
              "productId": "long",
              "quantity": "integer"
          },
          {
              "productId": "long",
              "quantity": "integer"
          }
      ]
  }
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `orderId` | `long`   | ID de la commande          |

| Body              | Type     | Description              |
| :--------         | :------- | :------------------------|
| `customerName`    | `string` | Nom du client            |
| `products`        | `Array`  | Tableau de produits      |
| `productId`       | `long`   | ID du produit            |
| `quantity`        | `integer`| Quantité du produit      |

#### Supprimer une commande

```http
  DELETE /orders/{orderId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `orderId` | `long`   | ID de la commande          |