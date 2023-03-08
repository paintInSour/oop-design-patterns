# Prototype/Builder

## ABSTRACT TASK

Develop online retail store. Receipt should be generated when user confirms order.

## IMPLEMENTATION

**OrderRecipe** class extends **PrototypeModel** abstract class and implements method **clone()** that provide new class
instances.

**OrderRecipe** contains dynamic order data and static recipe data for further recipe generation. **Prototype**
pattern prevents redundant requests for static data to the database/filesystem/another microservice.

**OrderRecipe** is clonned for new usage and populated with new order data. Consequently, **RecipePrinter** prints 
new recipe with same **RecipeStructure** and with updated **OrderData**

**OrderRecipe** use **Builder** pattern to create new instance.

### [Workflow demonstrated here](https://github.com/paintInSour/oop-design-patterns/blob/master/prototype-builder/src/test/java/patterns/prototype/builder/PrototypeTest.java)

## Prototype usage diagram

![Prototype](https://github.com/paintInSour/oop-design-patterns/blob/master/prototype-builder/static/PrototypeDiagram.png?raw=true)


