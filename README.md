
# Projet Stock Magasin
## Auteur

- [@ThomasLC-Dev](https://github.com/ThomasLC-Dev) (LE CORVEC Thomas)
## Présentation

Ce projet concerne la création d'un système de gestion des stocks pour un magasin, ainsi que la prise de commande.
Il s'agit ici d'un rendu sous le format d'une API REST.
## Développement

**API:** Java, Spring boot

**Base de données:** PostgreSQL
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