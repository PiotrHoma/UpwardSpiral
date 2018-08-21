# UpwardSpiral Heroku deployment

Repository was set up for heroku enviroment.

Changes compared to master branch:
- pom.xml (postgresql and heroku dependencies, java chnged to 1.8)
- Procfile added.
- application.properties postgres configuration
- SQL queries and User table edited (Changed for users, otherwise table was ommited by hibernate. It has something to do with heroku keeping owner credentials in User table.)
- Minor security fix graph access.
