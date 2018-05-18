# My coding convention in this project
## Layers and responsibility

### 1. Model
- JPA Model: mapping with db tables
- Table name should be plural noun
- All relationship should be LAZY fetch

### 2. Repository
- JPA Repository

### 3. Service
- Handle business logic, transaction by using repositories
- Input of Services should be model, not DTO
- Don't do validation in Services, it should be done in controller
- Services return exception in case of something fail

### 4. Controller
- Using DTOs in req/resp (avoid to use model)
- Validation
- In case of simple logic, Controllers can use Repository directly instead of create new service. It makes the development speed faster

### 5. DTO
- Separate by controller
- Should have from/to static function
- Convert from model to dto can use Spring BeanUtils.copyProperties() to speed up development

### 6. Advice & Configuration
- Swagger
- Intercepter
- ResponseAdvice