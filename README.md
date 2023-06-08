# Recipe Share

Recipe Share is a web application built with Java Spring Boot that allows users to share and discover recipes. 
This project aims to provide a platform where users can create, browse, like and rate their favorite recipes.

## Features

- **Recipe Creation**: Users can create and submit their own recipes, including details such as the name, ingredients, instructions, and an optional image.
- **Recipe Search**: Users can search for recipes based on keywords, ingredients, or categories, making it easy to find specific recipes or discover new ones.
- **Favorite Recipes**: Logged-in users can like&rate recipes as favorites to quickly access them later.
- **User Registration and Authentication**: Users can sign up and log in to the application to access personalized features.
This feature is on progress :hammer:

## Technologies Used

- Java Spring Boot
- ORM - Spring Data JPA
- PostgreSQL database for data storage
- Swagger for API documentation

## Getting Started

To run the Recipe Share application locally, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/aytacaydemir/recipe-share.git

2. Set up a postgreSQL database and update the database configuration in the application.properties file.

3. Build the project using Maven:
    
    ```shell
    cd recipe-share
    mvn clean install

4. Run the application

    ```shell
    java -jar target/recipe-share.jar
   
5. Open your web browser and access the Swagger API documentation by navigating to http://localhost:8080/swagger-ui/index.html#.
## Contributing

- Contributions to Recipe Share are welcome! If you encounter any issues or have suggestions for improvements, please open an issue.

