# ProximityServer
Proximity App API : 
Proximity is based on a Neo4J BDD and MariaDB BDD

## Proximity : ##

[![ReadMe Card](https://github-readme-stats.vercel.app/api/pin/?username=TomLeCollegue&repo=ProximityV2)](https://github.com/TomLeCollegue/ProximityV2)



## DOCUMENTATION API PROXIMITY ##


## Account Creation ##

IMAGE : 

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/images/{email}/upload


### SIGN UP ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/account/signUP

```json
{
    "firstname":"Tom",
    "name":"Kubasik",
    "age":21,
    "email":"tomkubasik",
    "password":"1234"
}
```
response : 

```json
{
    "response": "tomkubasik"
}
```

### SIGN IN ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/account/signIn

```json
{
    "mail":"lyacallejon",
    "password":"1234"
}
```
response : 

```json
{
    "age": 21,
    "email": "lyacallejon",
    "firstname": "Holyana",
    "name": "Callejon",
    "uuid": "b3683ecc-b14c-4ad7-9418-c28f2c871981"
}
```


### ANSWER QUESTIONS ###


url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/questions/answerQuestions

```json
{
    "uuid":"76431938-81f9-4b9b-ae86-549095a93961",
    "answers":[
        {"uuid": "11087d74-6c5e-4bfa-8bc9-1b7d631acdeb" , "bool" : true},
        {"uuid": "2db9538c-2674-482b-93af-b058a34f6103" , "bool" : false}
    ]
}
```

### NEW DISCOVERY ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/nearby/newDiscovery

```json
{
    "email1":"tomkubasik",
    "email2":"laurentcutting"
}
```

### DOWNLOAD IMAGE ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/images/{email}/download


### GET FRIENDS ###

url : http://192.168.43.36:8080/RestFullTEST-1.0-SNAPSHOT/Friends/getFriendsByUuid

```json
{
    "uuid":"76431938-81f9-4b9b-ae86-549095a93961"
}
```


### GET DISCOVERY ###

url : http://192.168.43.36:8080/RestFullTEST-1.0-SNAPSHOT/Friends/getDiscoveredByUuid

```json
{
    "uuid": "76431938-81f9-4b9b-ae86-549095a93961"
}
```
response : 

```json
{
    "persons": [
        {
            "age": 21,
            "email": "lyacallejon",
            "firstname": "Holyana",
            "name": "Callejon"
        }
    ]
}
```

### REFUSE PERSON ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/nearby/RefusePerson

```json
{
    "email1":"creamymail",
    "email2":"tomkubasik"
}
```

### MODIFY QUESTION ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/questions/ModifyQuestion

```json
{
    "uuid": "76431938-81f9-4b9b-ae86-549095a93961",
    "text": "En quelle année est sorti GTA VI",
    "choice1" : "2011",
    "choice2" : "2015",
    "choice3" : "2014",
    "answer" : "Pas encore bouffon",
    "hobby" : "Jeux-video",
    "uuidQuestion" : "2db9538c-2674-482b-93af-b058a34f6103"
}
```

### GET ALL HOBBIES ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/hobbies/GetAllHobbies

```json
{

}
```
response : 

```json
{
    "hobbies": [
        {
            "name": "Informatique",
            "xp": 0
        },
        {
            "name": "Tennis",
            "xp": 0
        },
        {
            "name": "Jeux-video",
            "xp": 0
        }
    ]
}
```

### CREATE QUESTION ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/questions/CreateQuestion

```json
{
    "uuid": "76431938-81f9-4b9b-ae86-549095a93961",  //user uuid
    "text": "En quelle année est sorti GTA V",
    "choice1" : "2011",
    "choice2" : "2015",
    "choice3" : "2014",
    "answer" : "2013",
    "hobby" : "Jeux-video"
}
```

### GET QUESTIONS BY UUID ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/questions/GetQuestionByUuid

```json
{
    "uuid": "76431938-81f9-4b9b-ae86-549095a93961"
}
```
response : 

```json
{
    "questions": [
        {
            "answer": "20",
            "choice1": "1",
            "choice2": "2",
            "choice3": "3",
            "hobby": "Tennis",
            "text": "Nombre de grands chelem Nadal",
            "uuid": "76431938-81f9-4b9b-ae86-549095a93961",
            "uuidQuestion": "a138c8ff-df7b-4eb9-838e-4637ec797abe"
        },
        {
            "answer": "Pas encore bouffon",
            "choice1": "2011",
            "choice2": "2015",
            "choice3": "2014",
            "hobby": "Jeux-video",
            "text": "En quelle année est sorti GTA VI",
            "uuid": "76431938-81f9-4b9b-ae86-549095a93961",
            "uuidQuestion": "2db9538c-2674-482b-93af-b058a34f6103"
        },
        {
            "answer": "Java le sang",
            "choice1": "Golang",
            "choice2": "Kotlin",
            "choice3": "Scratch",
            "hobby": "Informatique",
            "text": "Quel est le meilleur language de programmation du monde entier ? fait attention a toi BOBO",
            "uuid": "76431938-81f9-4b9b-ae86-549095a93961",
            "uuidQuestion": "07a46dcd-7219-4a72-ac83-773e3b8eb012"
        }
    ]
}
```

### GET QUESTIONS BY EMAIL ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/questions/GetQuestionByEmail

```json
{
    "email":"tomkubasik"
}
```
response : 

```json
{
    "questions": [
        {
            "answer": "20",
            "choice1": "1",
            "choice2": "2",
            "choice3": "3",
            "hobby": "Tennis",
            "text": "Nombre de grands chelem Nadal",
            "uuid": "private",
            "uuidQuestion": "a138c8ff-df7b-4eb9-838e-4637ec797abe"
        },
        {
            "answer": "Pas encore bouffon",
            "choice1": "2011",
            "choice2": "2015",
            "choice3": "2014",
            "hobby": "Jeux-video",
            "text": "En quelle année est sorti GTA VI",
            "uuid": "private",
            "uuidQuestion": "2db9538c-2674-482b-93af-b058a34f6103"
        },
        {
            "answer": "Java le sang",
            "choice1": "Golang",
            "choice2": "Kotlin",
            "choice3": "Scratch",
            "hobby": "Informatique",
            "text": "Quel est le meilleur language de programmation du monde entier ? fait attention a toi BOBO",
            "uuid": "private",
            "uuidQuestion": "07a46dcd-7219-4a72-ac83-773e3b8eb012"
        }
    ]
}
```


### CREATE HOBBY ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/hobbies/CreateHobby

```json
{
    "name": "Jeux-video"
}
```

### GET HOBBIES BY UUID ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/hobbies/GetHobbyByUuid

```json
{
    "uuid": "76431938-81f9-4b9b-ae86-549095a93961"
}
```
response : 

```json
{
    "hobbies": [
        {
            "name": "Jeux-video",
            "xp": 30
        },
        {
            "name": "Informatique",
            "xp": 10
        },
        {
            "name": "Tennis",
            "xp": 0
        }
    ]
}
```
### CREATE RELATION HOBBY PERSON ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/hobbies/CreateRelationHobbyPerson

```json
{
    "hobby": "Tennis",
    "uuid": "76431938-81f9-4b9b-ae86-549095a93961"
}
```

### ACCEPT PERSON ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/Friends/AcceptPerson

```json
{
    "uuid":"76431938-81f9-4b9b-ae86-549095a93961",
    "emailPerson":"leavaucanson"
}
```

### REMOVE QUESTION ###

url : http://localhost:8080/RestFullTEST-1.0-SNAPSHOT/questions/removeQuestion

```json
{
    "uuidQuestion":"76431938-81f9-4b9b-ae86-549095a93961"
}
```


### SHORTEST PATH ###

match (p:Person {name : "Vaucauson"}),(p2:Person {name : "Kubasik"}),
n = shortestPath((p)-[*..2]-(p2))
return n



### Get response Quizz friends ###

Match (p:Person {name:"Kubasik"})-[r1:QUESTION]-(q:Question)-[r2:ANSWERED]-(p2:Person {name: "Callejon"})
Return q.text AS question, r2.response AS response





























