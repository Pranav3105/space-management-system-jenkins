# SPACE MANAGEMENT SYSTEM

## Using Spring boot rest and Spring data jpa

## APIs : 
URL: http://localhost:8081/roommanagement/room , method = POST
```
Sample Requests:
{
	"roomNumber":"Bahada",
	"building":{
		"buildingName":"GLC"
	},
	"users":[{
		"userName":"Soham"
	},
	{
		"userName":"Shyam"
	}
		]
}
```
URL: http://localhost:8081/roommanagement/rooms , method = GET
```
Sample Resposne:
[
    {
        "roomId": 1,
        "roomNumber": "Amla",
        "building": {
            "buildingId": 1,
            "buildingName": "GLC"
        },
        "users": [
            {
                "userId": 1,
                "userName": "Ramesh"
            },
            {
                "userId": 2,
                "userName": "Ram"
            }
        ]
    },
    {
        "roomId": 2,
        "roomNumber": "Bahada",
        "building": {
            "buildingId": 1,
            "buildingName": "GLC"
        },
        "users": [
            {
                "userId": 3,
                "userName": "Soham"
            },
            {
                "userId": 4,
                "userName": "Shyam"
            }
        ]
    }
]
```
URL: http://localhost:8081/roommanagement/room?id=1 , method = GET
```
Sample Response: 
{
    "roomId": 4,
    "roomNumber": "Kachnar",
    "building": {
        "buildingId": 2,
        "buildingName": "GLC"
    },
    "users": [
        {
            "userId": 3,
            "userName": "Ramesh"
        },
        {
            "userId": 4,
            "userName": "Ram"
        }
    ]
}
```
URL: http://localhost:8081/usermanagement/user
```
Sample Request:
{
    "userName": "Ramesh",
    "room": {
        "roomId": 1,
        "roomNumber": "Amla",
        "building": {
            "buildingName": "GLC"
        }
    }
}
Sample Response:
{
    "userId": 5,
    "userName": "Ramesh",
    "room": {
        "roomId": 1,
        "roomNumber": "Amla",
        "building": {
            "buildingId": 1,
            "buildingName": "GLC"
        }
    }
}
```
URL: http://localhost:8081/usermanagement/users , method = GET
```
Sample Respone: 
[
    {
        "userId": 1,
        "userName": "sayan",
        "room": {
            "roomId": 1,
            "roomNumber": "Bahada",
            "building": {
                "buildingId": 1,
                "buildingName": "GLC"
            }
        }
    },
    {
        "userId": 2,
        "userName": "padmini",
        "room": {
            "roomId": 1,
            "roomNumber": "Bahada",
            "building": {
                "buildingId": 1,
                "buildingName": "GLC"
            }
        }
    },
    {
        "userId": 3,
        "userName": "Ramesh",
        "room": {
            "roomId": 2,
            "roomNumber": "Amla",
            "building": {
                "buildingId": 2,
                "buildingName": "GLC"
            }
        }
    },
    {
        "userId": 4,
        "userName": "Ram",
        "room": {
            "roomId": 2,
            "roomNumber": "Amla",
            "building": {
                "buildingId": 2,
                "buildingName": "GLC"
            }
        }
    }
]
```
URL: http://localhost:8081/usermanagement/user?id=1 , method = GET
```
Sample Response:
{
    "userId": 5,
    "userName": "Ramesh",
    "room": {
        "roomId": 1,
        "roomNumber": "Amla",
        "building": {
            "buildingId": 1,
            "buildingName": "GLC"
        }
    }
}
```

URL: http://localhost:8081/usermanagement/user?id=1 , method = PUT
```
Sample Request:
{
	 "room":{
	 	"roomId":2
	 }
}
Sample Response:
{
    "userId": 1,
    "userName": "sayan",
    "room": {
        "roomId": 2,
        "roomNumber": "Amla",
        "building": {
            "buildingId": 2,
            "buildingName": "GLC"
        }
    }
}
```
