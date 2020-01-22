# Environment pre-requisites

* Git
* Docker
* Ports open: 3306, 8080

# Create network

Create the network 

```docker network create some-network``` 

# Start database

Start the MySQL container 

```docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:latest```

Add MySQL container to the network

```
docker network connect some-network mysql
```

Connect to the MySQL container (password is: password)

```
docker run -it --network some-network --rm mysql mysql -hmysql -u root -p
```

Create the database

```
create database notesdatabase;
```

Exit the MySQL container by typing

```exit```

# Start spring application

Build the spring application image

```docker build -t spring-app:latest .```

Run spring container

```docker run -d -p 8080:8080 --name spring-app spring-app```

# Test the application

Test the application 

```curl localhost:8080```

