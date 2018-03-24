echo 'Starting Mysql DB...'
sudo docker run --name skipthedishes-sp-fair -e MYSQL_ROOT_PASSWORD=skipthedishes-sp-fair -e MYSQL_DATABASE=skipthedishes-sp-fair -e MYSQL_USER=skipthedishes-sp-fair -e MYSQL_PASSWORD=skipthedishes-sp-fair -p 3306:3306 -d mysql:5.5
