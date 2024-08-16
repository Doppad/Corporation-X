# English
## Corporation
This is a microservices architecture project that I worked on. The features implemented are detailed below.

## Features:
Created a listener in the notification service for Kafka topics that responds to all order placements and payment transactions: https://github.com/Doppad/Corporation/blob/main/services/notification/src/main/java/com/doppad/ecommerce/kafka/NotificationConsumer.java

Developed an order placement system in the corresponding service. Created the order, configured the OrderService with checks for customer and product existence, and set up a publisher for the Kafka topic: https://github.com/Doppad/Corporation/blob/main/services/order/src/main/java/com/doppadecommerce/order/OrderService.java Publisher: https://github.com/Doppad/Corporation/blob/main/services/order/src/main/java/com/doppadecommerce/kafka/OrderProducer.java

Configured the API Gateway to provide a unified entry point and secure the microservices architecture. Additionally, set up Keyclaok for enhanced security: https://github.com/Doppad/Corporation/blob/main/services/gateway/src/main/java/com/doppad/gateway/security/SecurityConfig.java

Wrote a monitoring system for inventory levels in the relevant service. The system tracks the quantity of products in the database and updates the stock levels after a purchase: https://github.com/Doppad/Corporation/blob/main/services/product/src/main/java/com/doppad/ecommerce/product/ProductService.java

In the customer service, I developed a system for updating user information. The specific implementation is detailed here: https://github.com/Doppad/Corporation/blob/main/services/customer/src/main/java/com/doppad/ecommerce/customer/CustomerService.java

Developed and configured a Config Server for centralized management of configuration data across all microservices, simplifying their setup and management: https://github.com/Doppad/Corporation/tree/main/services/config-server/src/main/resources/configurations


# Russian
## Corporation
Это проект на микросервисной архитектуре над которым я работал. Реализованные фичи будут указаны ниже.

## Фичи:
Создал слушателя в сервисе нотификаций для топиков в Kafka, который будет реагировать на все размещения заказов и совершения оплаты: https://github.com/Doppad/Corporation/blob/main/services/notification/src/main/java/com/doppad/ecommerce/kafka/NotificationConsumer.java

Разработал систему размещения заказов в соответствующем сервисе. Создал заказ, настроил OrderService с проверкой существования покупателя и товара, а также публикатор для топика в Kafka: https://github.com/Doppad/Corporation/blob/main/services/order/src/main/java/com/doppadecommerce/order/OrderService.java Публикатор: https://github.com/Doppad/Corporation/blob/main/services/order/src/main/java/com/doppadecommerce/kafka/OrderProducer.java

Настроил API Gateway для обеспечения единой точки входа и защиты микросервисной архитектуры. Также для защиты настроил Keyclaok: https://github.com/Doppad/Corporation/blob/main/services/gateway/src/main/java/com/doppad/gateway/security/SecurityConfig.java 

Написал систему мониторинга количества товаров в характерном сервисе. Система следит за количеством товаров в базе данных и меняет их количество после покупки: https://github.com/Doppad/Corporation/blob/main/services/product/src/main/java/com/doppad/ecommerce/product/ProductService.java

В сервисе работы с пользователями, я разработал систему обновления данных о пользователе. Конкретная реализация здесь: https://github.com/Doppad/Corporation/blob/main/services/customer/src/main/java/com/doppad/ecommerce/customer/CustomerService.java

Разработал и настроил Config Server для централизованного управления конфигурационными данными всех микросервисов, что упрощает их настройку и управление: https://github.com/Doppad/Corporation/tree/main/services/config-server/src/main/resources/configurations