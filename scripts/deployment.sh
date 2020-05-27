echo 'Loggin in to Docker Hub'
docker login -u $1 -p $2 $3

echo 'Pulling container' $3
docker pull $3

echo 'Running Container on 8081'
docker run -d -p 8081:8081 $3

echo 'container started successfully'
