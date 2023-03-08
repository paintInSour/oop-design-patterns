# Prototype/Builder

## ABSTRACT TASK

Develop online retail store. Receipt should be generated when user confirms order.

## IMPLEMENTATION

**OrderRecipe** class extends **PrototypeModel** abstract class and implements method **clone()** that provide new class
instances.

**OrderRecipe** contains dynamic order data and static recipe data for further recipe generation. So **Prototype**
pattern prevents redundant requests for static data to the database/filesystem/another microservice.

**OrderRecipe** use **Builder** pattern to create new instance.

### [Workflow demonstrated here](https://github.com/paintInSour/oop-design-patterns/blob/master/factory/src/test/java/patterns/prototype/builder/PrototypeTest.java)

## Prototype usage diagram

![Prototype](https://github.com/paintInSour/oop-design-patterns/blob/master/factory/static/PrototypeDiagram.png?raw=true)


