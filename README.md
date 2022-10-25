# emp-crud2

1. Build the jar file: mvn install or using the intellij maven tab
2. heroku login
3. heroku container:login
4. docker build -t sagar-project .
5. docker image ls
6. copy the image id from the above command output
7. docker tag <image-id> registry.heroku.com/\<heroku-app-name\>/web
8. docker push registry.heroku.com/\<heroku-app-name\>/web
9. heroku container:release web
