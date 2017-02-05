# Answers

## What is the purpose of `.gitignore`?

It lets us avoid committing files that are automatically downloaded/created by gradle 
or other build tools. For example, we don't want the `build/` directory because it contains 
a bunch of `.class` files that we can just build from our `.java` files.