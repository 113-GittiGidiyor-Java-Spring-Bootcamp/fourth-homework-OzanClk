<!--## Dördüncü hafta ödevi son teslim tarihi : 06.08.2021(Gelecek hafta pazartesi) - Saat =>  23:30 -->

<!--![homework](https://user-images.githubusercontent.com/45206582/131386439-6727321a-5a50-4c20-9413-ea4013013434.PNG)-->

# Course Management System
### Project Abstract

Within the scope of the project, teacher and student transactions for a course were carried out. These processes are course-student-instructor saving, updating, deleting, searching.

### Entity Relationship Diagram
![UML-Diagram](https://user-images.githubusercontent.com/67712162/132559531-0c943f09-4431-4df5-8b40-38b268755227.JPG)

### Swagger Documentation

**Courses,Instructors,Students,Exceptions End-Points.Swagger design where CRUD can be performed**

![coursesEndPoint](https://user-images.githubusercontent.com/67712162/132559804-05273155-6370-42ba-9860-ad24ef384dcb.JPG)
![insturctor](https://user-images.githubusercontent.com/67712162/132560044-ad88e411-e6bc-4e13-a27d-cbf45b2d6dcd.JPG)
![studentcontroller](https://user-images.githubusercontent.com/67712162/132560089-c494fe5f-bd78-4b5f-ba7e-2f4e4ef1c9e2.JPG)
![ExceptionController](https://user-images.githubusercontent.com/67712162/132560106-1f313e64-9b50-4ad4-aad7-26d9c98dce5b.JPG)

### **Example process with Swagger**

- Parameters and values sent for the registration process
![Capture2](https://user-images.githubusercontent.com/67712162/132560192-4fd4d044-e3fe-41eb-89e2-d340419566b8.JPG)

- Response body, Response Headers and Status Code
![response](https://user-images.githubusercontent.com/67712162/132560257-61745637-5a93-48d7-98a7-c9222f85e6fe.JPG)

- If it is desired to register with the same course code, an exception is thrown.Exception cases in the project are grouped under the Global Exception Handler class.
![Capture3](https://user-images.githubusercontent.com/67712162/132560359-6d545c39-8273-4a78-8cc1-f5e741159a88.JPG)

- Log records in the database of Exceptions
![Capture9](https://user-images.githubusercontent.com/67712162/132560463-8ecb7d8b-beec-4698-aa5f-b75449df95cb.JPG)
