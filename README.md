
# Overview

This project is part of a group initiative developed during classes, focusing on the analysis of education expenditure in Poland from 2014 to 2020. The primary goal is to provide insights into how education funds were allocated and utilized across different regions and levels of education during this period.


## The graphic client was not implemented by me.
## Link to the second part of project: https://github.com/SpellZZZ/XML-JSON-ExportImportDB

# How to run

Create target folder, then run cmd and type 
```
git clode *repo link*
```

Create MySql database. Name: ```integracjaprojektdb```

Authentication in DB ![obraz](https://github.com/SpellZZZ/Spring-EUProjectsManagementFrom2014To2021/assets/43863065/b9321c72-8430-403b-a02e-a387b73be3a5)

Make sure that port is free: ![obraz](https://github.com/SpellZZZ/Spring-EUProjectsManagementFrom2014To2021/assets/43863065/802a7326-64da-4e3f-b38b-c814fb8b8780)


# Key features

  * Data Collection and Storage:
        The project involves collecting comprehensive data on educational outcomes, regional exam results, and funding details for various educational projects.
        Data is stored in a relational database and accessed through various repositories, including OgolneWynikiMaturRepo, WojWynikiMaturRepo, and ProjektyRepo.

  * Analysis and Reporting:
        The project includes functionalities for analyzing general and regional educational results, as well as specific projects and their funding.
        Users can query the database to get detailed information about exam results by subject, region, and level of education.

  * RESTful API:
        A RESTful API is implemented using Spring Boot, providing endpoints to fetch the data and perform various analyses.
        Endpoints allow users to retrieve exam results by subject, region, and level, as well as project details and their respective funding.

  * Business Logic Separation:
        The business logic for data processing and analysis is separated from the controller layer and encapsulated within a service layer (MainService and its implementation MainServiceImpl).
        This separation ensures a clean and maintainable codebase, adhering to the principles of clean architecture.

# Endpoints
  * /ogolneWynikiMatur/{przedmiot}  ---->  Fetches general exam results by subject.
  * /ogolneWynikiMatur/all  ---->  Retrieves all general exam results.
  * /wojewodztwoWyniki/{przedmiot}/{poziom}  ---->  Gets regional exam results by subject and level.
  * /wojewodztwoWyniki/woj/{woj}  ---->  Fetches exam results for a specific region.
  * /wojewodztwoWyniki/woj/{woj}/{poziom}  ---->  Fetches exam results for a specific region and level.
  * /wojewodztwoWyniki/woj/{woj}/{poziom}/{przedmiot}  ---->  Gets detailed exam results for a specific region, level, and subject.
  * /projekty/woj/{woj}  ---->  Lists projects in a specific region.
  * /projekty/woj/{woj}/dotacje  ---->  Calculates total project funding in a specific region.
  * /projekty/woj/{woj}/dotacje/{start}/{koniec}  ---->  Aggregates project funding over a range of years for a specific region.

# Example 

Getting math results for every region:

![obraz](https://github.com/SpellZZZ/Spring-EUProjectsManagementFrom2014To2021/assets/43863065/0d20e6b2-aa79-4694-935a-44d14481fb9a)

Getting advanced math results for the Mazowieckie region:

![obraz](https://github.com/SpellZZZ/Spring-EUProjectsManagementFrom2014To2021/assets/43863065/b4eab189-bf76-484c-ac59-685c87a9df5d)

Getting a list of projects in the Lubelskie region:

![obraz](https://github.com/SpellZZZ/Spring-EUProjectsManagementFrom2014To2021/assets/43863065/d44ccfb1-c003-4c16-8288-302217a4ebc0)



