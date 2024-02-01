<h3 align="center">Leads Tracking ⚡</h3>

# Swagger UI
**URL**
```
http://localhost:1010/swagger-ui/index.html
```

# Register Lead
**URL**
```
http://localhost:1010/lead/store-lead
```

**Example Request**
```
{
    "nama":"billie",
    "email":"billie@gmail.com",
    "nomorTelepon":"08118822334"
}
```

**Example Response**
```
{
    "responseCode": 201,
    "responseMessage": "Success store to database",
    "lead": {
        "leadId": "2c8fd860-5c0a-4ba5-b047-346c19912f18",
        "nama": "billie",
        "email": "billie@gmail.com",
        "nomorTelepon": "08118822334",
        "createdAt": "2024-02-01T05:47:01.410+00:00",
        "updatedAt": null,
        "isDeleted": false
    }
}
```

# Update Lead
**URL**
```
http://localhost:1010/lead/update-lead/2c8fd860-5c0a-4ba5-b047-346c19912f18
```

**Example Request**
```
{
    "nama":"bill",
    "email":"billy@gmail.com",
    "nomorTelepon":"081188223312"
}
```

**Example Response**
```
{
    "responseCode": 200,
    "responseMessage": "Success store to database",
    "lead": {
        "leadId": "ff4dac23-6b71-42ab-b5cb-8957b377dfbb",
        "nama": "bill",
        "email": "billy@gmail.com",
        "nomorTelepon": "081188223312",
        "createdAt": "2024-01-31T06:53:28.999+00:00",
        "updatedAt": "2024-02-01T08:25:26.042+00:00",
        "isDeleted": false
    }
}
```


# Get One Lead
**URL**
```
http://localhost:1010/lead/get-one-lead/ff4dac23-6b71-42ab-b5cb-8957b377dfbb
```

**Example Response**
```
{
    "responseCode": 200,
    "responseMessage": "Success",
    "lead": {
        "leadId": "ff4dac23-6b71-42ab-b5cb-8957b377dfbb",
        "nama": "bill",
        "email": "billy@gmail.com",
        "nomorTelepon": "081188223312",
        "createdAt": "2024-01-31T06:53:28.999+00:00",
        "updatedAt": "2024-02-01T08:25:26.042+00:00",
        "isDeleted": false
    }
}
```

# Get All List of Leads
**URL**
```
http://localhost:1010/lead/get-all-leads
```

**Example Response**
```
{
    "responseCode": 200,
    "responseMessage": "Success",
    "leads": [
        {
            "leadId": "ff4dac23-6b71-42ab-b5cb-8957b377dfbb",
            "nama": "bill",
            "email": "billy@gmail.com",
            "nomorTelepon": "081188223312",
            "createdAt": "2024-01-31T06:53:28.999+00:00",
            "updatedAt": "2024-02-01T08:25:26.042+00:00",
            "isDeleted": false
        }
    ]
}
```

