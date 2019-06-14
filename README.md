# NutritionTracker

Weight Loss / Tracking System. Customer chooses food (name,
number, proteins, fats, carbohydrates), which he ate (from the already prepared list) and writes
Amount. The client can add his type of food (name, calories, number
proteins, fats, carbohydrates). If the client has increased the daily norm, the system
will inform him of this and write down how much norm was exceeded. Norm
calculates from the parameters Client (age, height, weight, lifestyle, etc.).

<b>Installation instructions</b>

Clone this repo and build the applicatoin with maven using mvn package command. Move generated .war to webapps folder of your tomcat.

<b>Run instructions</b>

Start your tomcat servlet container and type http://localhost:8080/nutrition_tracker/ in your browser`s adddress bar.
