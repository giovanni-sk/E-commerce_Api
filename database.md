1. Users: strock tous les infos d'un client

2. Products: Stock les infos sur les produits

3. Orders: Stock les infos sur les commandes faites par les clients

4. Order Items: Stock les infos sur ls produits inclus dans chaque commande

## Illustration

1. **Users: strock tous les infos d'un client**

| Nom de la colonne | Type de donnée | description             |
| ----------------- | -------------- | ----------------------- |
| id                | BigInt         | Clé primaire            |
| username          | Varchar        | Pseudo unique du client |
| email             | VArchar        | Email du client         |
| password          | Varchar        | Mdp du client           |
| created_At        | date           | date de création        |
| updated_At        | date           | date de modification    |

2. **Products: stock les infos sur les produits**

| Nom de la colonne | Type de donnée | description            |
| ----------------- | -------------- | ---------------------- |
| id                | BIGINT         | Clé primaire           |
| name              | VARCHAR        | Nom du produit         |
| description       | TEXT           | Description du produit |
| price             | DECIMAL        | Prix du produit        |
| stock             | INT            | Stock du produit       |
| created_At        | TIMESTAMP      | date de création                    |
| updated_At        | TIMESTAMP      | date de modification          |

3. **Orders: Stock les infos sur les commandes faites par les clients**

| Nom de la colonne | Type de donnée | description           |
| ----------------- | -------------- | --------------------- |
| id                | BIGINT         | Clé primaire          |
| user_id           | BIGINT         | Clé Secondaire        |
| total_amount      | DECIMAL        | Montant total         |
| status            | VARCHAR        | statut de la commande |
| created_At        | TIMESTAMP      | date de création      |
| updated_At        | TIMESTAMP      | date de modification  |


4. **Orders items: Stock les infos sus les produits inclus dans chaque commande**

| Nom de la colonne | Type de donnée | description                   |
| ----------------- | -------------- | ----------------------------- |
| id                | BIGINT         | Clé primaire                  |
| order_id          | BIGINT         | Clé Secondaire =>`orders`     |
| product_id        | BIGINT         | Clé secondaire  =>``products` |
| quantity          | INT            | Qte de produits de commande   |
| price             | DECIMAL        | Prix du produit               |
| created_At        | TIMESTAMP      | date de création              |
| updated_At        | TIMESTAMP      | date de modification          |


` spring.jpa.hibernate.ddl-auto` : 
Cette propriété est utilisée pour spécifier la stratégie de génération du shéma de la BDD lors du demarrage de l'application .
Hibernate , l'ORM utilisé par defaut dans Spring Boot , peut automatiquement créer, mettre à jour , valider ou gérer le schema de la bdd en fonction  de cette propriété.
Voici une explication des differentes valeurs qu'on peut attribuer: 

1.`none`:Désactive la gestion automatique du schema par Hibernate .
Aucune modification du shema de BDD ne sera effectué au démarrage de l'application .

2.`validate`: Hibernate v

3.`update`

4.`create`

5.`create-drop`