FROM openjdk:8
EXPOSE 8080
ADD target/ Inventory_manager.jar
ENTRYPOINT ["java", "-jar","/Inventory_manager.jar"]