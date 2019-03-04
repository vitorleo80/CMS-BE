##-------------UNSECURED API ENDPOINTS------------##

#Sign-up
http://localhost:8080/cms-api/authors/sign-up
{
  "name" : "user",
  "email": "user@user.com",
  "password": "password"
}

#Get Articles
http://localhost:8080/cms-api/articles/

##-------------SECURED API ENDPOINTS-------------##


#Login
http://localhost:8080/cms-api/login
{
  "email": "user@user.com",
  "password": "password"
}
Headers -> Authorization → Bearer XXX...

#Create Category
http://localhost:8080/cms-api/categories/
{
	"name": "Category"
}
Headers
Authorization → Bearer XXX...
Content-Type : application/json

#Create Article 
http://localhost:8080/cms-api/articles/
{
  "imageUrl" : "hosted image url",
  "title": "title",
  "content" : "<p><span style=\"color: rgb(226,80,65);font-size: 48px;\">Your content can be as<strong>String</strong>or<strong>HTML</strong></span></p><p></p>",
  "category": {
  	"id": category ID
  	},
  "published":false or true,
  "tags": ["#tag1", "#tag2", ...]
}
Headers
Authorization → Bearer XXX...
Content-Type : application/json



