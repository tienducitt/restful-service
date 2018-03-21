
# MY RESTful service starter project using Spring boot


## Target:
|Stack|Status|
|-----|------|
|Spring boot| Done |
|Swagger| Done|
|Error handling| Done with a little hack with swagger resource controller, need to improve |
|JPA| - |
|PostgresQL| - |
|Config| Done |
|Unit test, Covering test| - |
|Migration & seeder| - |
|Docker| - |
|Docker-compose| - |

## Swagger:

### Swagger docs:
/swagger/api-docs

### Swagger UI:
/resources/swagger-ui.html

## HttpResponse:
Response will always in this format:
```json
{
    "status": 200,
    "data": {},
    "errors": [
        {
            "name": "string",
            "error": "error message"
        },
    ]
    extra: {
        "totalPage": 10,
        "pageSize": 10,
        "currentPage": 10,
    }
}
```

- Status: status of the action, http header status code will always 200
- Data: actual data of the service
- errors: detail errors
for error of the whole action, "name" will be like "-"
- extra: some extra information using for paging