# Answers

#### What is the purpose of `.gitignore`?

It lets us avoid committing files that are automatically downloaded/created by gradle 
or other build tools. For example, we don't want the `build/` directory because it contains 
a bunch of `.class` files that we can just build from our `.java` files.

#### Explain what a route is?

Spark uses "routes" to associate some method with a URL-matching pattern. When Spark receives a HTTP request that 
matches the URL-matching pattern that you've defined, it calls the method that you told it to. 

#### What is the purpose of the `umm3601.Server` class?

It sets up all the routes in Spark in order for users to interact with the files in `resources/public`
and the `ToDoController` and `UserController` classes.

#### What is the purpose of the `umm3601.user.UserController` class?

It provides a straightforward interface for the `Server.class` to query the `users.json` file.

#### Explain what what happens when a user accesses each of the following URLs:

- `users`: Spark redirects the client to the `users.html` page which lets the visitor look at users.
- `api/users`: It prompts Spark to use `userController` and `gson` to generate JSON and return it to the client.
- `api/users?age=25`: This matches the route on line 37 of `Server.java`. Spark interprets the `?age=25` as a 
   query and uses it to build a map where `age` is associated with `[25]` which gets passed off to `userController` in
   order to generate JSON to send to the client.
- `api/users/588935f5de613130e931ffd5`: This matches the route on line 43 of `Server.java`. Spark uses 
  `api/users/:id` to associate the parameter name `id` with the value `588935f5de613130e931ffd5` and this value
  then gets used to fetch a user via `userController`.
   
#### What happens when the user accesses the page "kittens"? 
*Modify the server code so accessing the page "kittens" results in the text "Meow". Describe what you did and how it worked.*

Users get `404 Not found` page because the route does not exist in Spark. We added a route to Spark in order for it to return the
string "Meow".

#### Describe the contents of the public folder
- `about.html`: It is a simple HTML file that contains some text and links.
- `index.html`: It is the landing page for the website. It is an HTML file that has links, a picture, and a button. 
When the button is pressed, it calls a non-existent JavaScript function. 
- `users.html`: When the button is clicked, a JavaScript is run that fetches some data from the server and places it in the 
`<div>` with `id="jsonDump"`.

#### What happens when you filter by age in the client?

When we type `http://localhost:4567/api/users?age=35` in the address bar, our browser sends GET request for `users?age=35`
to the domain `localhost:4567`. As discussed earlier, this results in the server send JSON as a response.

#### Where is the client-side JavaScript defined? Name the file(s) in which it is used.

It is defined in `resources/public/javascript/users.js` and used in `resources/public/users.html`.