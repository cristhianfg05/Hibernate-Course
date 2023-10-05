
# Lazy Loading vs Eager Loading

This project showcases the implementation of a one-to-many bidirectional mapping using Hibernate, a popular Java ORM (Object-Relational Mapping) framework. The main objective of this mini-project is to illustrate how to establish a bidirectional association between two entities, where one entity has a one-to-many relationship with another entity.

Furthermore, this project focuses on comparing two loading strategies: lazy loading and eager loading, within the bidirectional association. During the development, we will analyze and demonstrate the differences between both strategies in terms of efficiency and performance, which will help understand when it is more appropriate to use each one in different scenarios. It is essential to note that this project is a didactic example and is not intended to cover advanced or production-level implementations. Instead, it serves as a foundation for understanding the distinctions and practical applications of both loading strategies.


Lazy Loading:
Lazy loading is a strategy where associated entities are not fetched from the database until they are explicitly accessed or needed. When an entity is loaded from the database, its associated entities are represented as proxies or placeholders. These proxies do not contain the actual data but rather act as references to the associated entities. Only when you attempt to access a property of the associated entity, the ORM framework will issue an additional query to the database to fetch the actual data for that entity. This can help reduce the amount of data fetched from the database and improve performance when working with large or complex data structures.

Eager Loading:
On the other hand, eager loading is a strategy where all associated entities are loaded from the database along with the main entity. When an entity is loaded from the database, all its associated entities are also immediately loaded. This can be useful when you know that all associated entities will be needed in a particular operation to avoid additional queries to the database. However, if the associated entities are not necessary, this can result in loading more data than is actually required and may impact performance in situations with large amounts of data.