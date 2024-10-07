# backend-franquicias

Para desplegar esta aplicación desde un entorno local:

1. Descargar la imagen:
___
    `docker pull pedro0531/backend-franquicias:1.1`

2. Iniciar contenedor con variables de entorno de conexión a base de datos:
___
    `docker run -d -p 8080:8080 -e "DB_URL=r2dbc:pool:mysql://terraform-20241007025453152600000001.crym66c4yfw8.us-west-2.rds.amazonaws.com:3306/franchise_pdn" -e "DB_USERNAME=franquicias_user" -e "DB_PASSWORD=****" --name mi-app pedro0531/backend-franquicias:1.1`

3. Verifica correcto funcionamiento accediendo a http://localhost:8080/swagger-ui.html