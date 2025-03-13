1. tendremos que instalar apache en una instancia, para posteriormente subir los archivos estaticos

![alt text](imagenes/apacheinstall.png)

2. Iniciamos el servicio y lo habilitamos

![sdf](imagenes/apacheStaert.png)

3. instalar git para cargar los archivos y los ubicamos "/var/www/html/" que es la ruta que Apache.

![alt text](imagenes/installgit.png)
![dnsd](imagenes/archivos.png)

4. Ya podemos buscar los archivos confirmando que el servidor Apache este funcionando bien y trayendo los recursos.
"http://ec2-3-83-113-17.compute-1.amazonaws.com/login.html"

![alt text](<imagenes/busqueda normi.png>)

Install Certbot and configure Apache to serve content over HTTPS:

sudo yum install certbot python3-certbot-apache -y

![alt text](imagenes/chet.png)

- Creamos un dominio en https://www.duckdns.org/domains

![h](imagenes/dns.png)

sudo certbot --apache -d frontmariatorres.duckdns.org


