<div align=justify>

# Instalación de Odoo a través de Docker Compose

<div align=center>
    <img src="./img/bg.jpg">
</div>

## Paso 1 - Construir y levantar el proyecto con Docker Compose

De los archivos pasados para lanzar Odoo:

```
dev
├── docker-compose.yml
prod
├── docker-compose.yml
```

Nos situamos en el directorio donde se encuentra el archivo `docker-compose.yml` de la versión o tipo necesario (`development` o `production`), y ejecutamos:

```bash
# Para construir el proyecto (si hace falta) y levantarlo en segundo plano.
docker compose up -d --build 
```

Esto nos crea la carpeta `volumesOdoo` con todo lo necesario para correr Odoo en nuestro sistema. Una vez construido y levantado el proyecto Docker, accedemos a él a través de [localhost:8096](localhost:8096) o [localhost:8070](localhost:8070) (dependiente de si es la versión `dev` o `prod`).

## Paso 2 - Creamos 

</div>