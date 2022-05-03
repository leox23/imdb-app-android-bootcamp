# [ 2:Kotlin basics](https://developer.android.com/codelabs/kotlin-bootcamp-basics)

### **Question 1**

Which of the following declares an unchangeable list of strings?

- [ ] `val school = arrayOf("shark", "salmon", "minnow")`
- [ ] `var school = arrayOf("shark", "salmon", "minnow")`
- [x] `val school = listOf("shark", "salmon", "minnow")`
- [ ]  `val school = mutableListOf("shark", "salmon", "minnow")`

En Kotlin, las unicas listas que despues de asignarle valor no van a cambiar, son las que son declaradas con `listOf`, aun sin importar que la variable se declare con `var`.


<hr/>

What will be the output of the following code? `for (i in 3..8 step 2) print(i)`

- [ ] 345678
- [ ] 468
- [ ] 38
- [x]  357

El buche dice que recorrera del indice 3 al 8, luego dice que lo hara de 2 en 2, luego dice que va a imprimir todo, en la misma linea concatenandolo (`print` no `println`), empezamos con el primer ciclo, imprime 3, luego como es de dos en dos, 3 + 2 = 5, imprime 5. Siguiente ciclo, 5 + 2 = 7, imprime 7,  luego el siguiente ciclo, 7 + 2 = 9, no entra al ciclo y termina. Da como **resultado 357**.


<hr/>

### **Question 3**

What is the purpose of the question mark in this code? `var rocks: Int? = 3`

- [ ] The type of the variable `rocks` isn't fixed.
- [x] The variable `rocks` can be set to null.
- [ ] The variable `rocks` cannot be set to null.
- [ ]  The variable `rocks` shouldn't be initialized right away.

Se coloca en las declaraciones de variables el signo de interrogacion en el tipo de la variable, cuando sabemos que es probable que cuando usemos esa variable, sea null, lo hacemos para que el sofware no "crashee". 


<hr/>

# [3: Functions](https://developer.android.com/codelabs/kotlin-bootcamp-functions)

### **Question 1**

The `contains(element: String)` function returns `true` if the string `element` is contained in the string it's called on. What will be the output of the following code?

```kotlin
val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
println(decorations.filter {it.contains('p')})
```

- [ ] `[pagoda, plastic, plant]`
- [ ] `[pagoda, plastic plant]`
- [x] `[pagoda, plastic plant, flowerpot]`
- [ ] `[rock, alligator]`

`decorations` se declara como lista no mutable, con 5 strings, y en la segunda linea se intenta imprimir, aplicandole la funcion `filter` a `decorations`, dentro del filtro especificamos que **solo** queremos los strings que tengan una `p` dentro de sus caracteres, y nos devuelve los ters que lo tienen: `agoda, plastic plant, flowerpot`.


<hr/>

### **Question 2**

In the following function definition, which one of the parameters is required? `fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20, numDecorations: Int = 0): Boolean {...}`

- [ ] `numDecorations`
- [ ] `dirty`
- [x] `day`
- [ ]  `temperature`

En la funcion `shouldChangeWater` vemos que a todos los parametros solicitados tienen definido el tipo de variables que son requeridas, y vemos que tres parametros de ellos tienen valores predeterminados, pero vemos que `day` no tiene valor aun, por lo que para ejecutar la funcion, es obligatorio pasarle un string a la variable `day` para poder usar la funcion. 


<hr/>

### **Question 3**

You can pass a regular named function (not the result of calling it) to another function. How would you pass `increaseDirty( start: Int ) = start + 1` to `updateDirty(dirty: Int, operation: (Int) -> Int)`?

- [ ] `updateDirty(15, &increaseDirty())`
- [ ] `updateDirty(15, increaseDirty())`
- [ ] `updateDirty(15, ("increaseDirty()"))`
- [x]  `updateDirty(15, ::increaseDirty)`

El metodo para para pasar una funcion nombrada a otra funcion es usando `::` (el doble dos puntos) y luego el nombre de la funcion a pasar, asi es como Kotlin distingue dentro de los argumentos funciones de las variables.


<hr/>

# [4: Object-oriented programming (Clases)](https://developer.android.com/codelabs/kotlin-bootcamp-classes)

## **Question 1**

Classes have a special method that serves as a blueprint for creating objects of that class. What is the method called?

- [ ] A builder
- [ ] An instantiator
- [x] A constructor
- [ ] A blueprint

Los constructores en las clases son los que sirven de patron para crear objetos, son los que marcan las propiedades y tipos y inicializaciones adicionales que tendra el objeto.

<hr/>

### **Question 2**

Which of the following statements about interfaces and abstract classes is NOT correct?

- [ ] Abstract classes can have constructors.
- [ ] Interfaces can't have constructors.
- [x] Interfaces and abstract classes can be instantiated directly.
- [ ] Abstract properties must be implemented by subclasses of the abstract class.

Las clases abstractas sirven para definir propiedades que van a ser comunes para las clases que la heredaran, y en caso de ser posible tambien agrupar comportamientos(metodos) en caso de que vaya a ser comun para las subclases;  y las interfaces tienen la funcion de definir comportamientos comunes mas especificos que puedan ser compartidos a clases relacionadas. Pero ambos no pueden crear objetos directamente, para eso se deben usar a travez de una subclase.

<hr/>

### **Question 3**

Which of the following is NOT a Kotlin visibility modifier for properties, methods, etc.?

- [ ] `internal`
- [x] `nosubclass`
- [ ] `protected`
- [ ] `private`

En Kotlin existen 4 modificadores de visibilidad y son: `public`, `private`, `internal` y `protected`.

<hr/>

### **Question 4**

Consider this data class: `data class Fish(val name: String, val species:String, val colors:String)` Which of the following is NOT valid code to create and destructure a `Fish` object?

- [ ] `val (name1, species1, colors1) = Fish("Pat", "Plecostomus", "gold")`
- [ ] `val (name2, _, colors2) = Fish("Bitey", "shark", "gray")`
- [ ] `val (name3, species3, _) = Fish("Amy", "angelfish", "blue and black stripes")`
- [x] `val (name4, species4, colors4) = Fish("Harry", "halibut")`

Las propiedades de `data class`  no tienen valores asignados por defecto. La cuarta desestructuracion* esta pidiendo asignar las 3 propiedades de `Fish` a las 3 variables respectivamente, a `Fish`  se le estan pasando 2 strings, pero falta  el string perteneciente a `colors`,  como esa propiedad se esperaba y no fue asignada, presentará un gran error.

<hr/>

### **Question 5**

Let's say you own a zoo with lots of animals that all need to be  taken care of. Which of the following would NOT be part of implementing  caretaking?

- [x] An `interface` for different types of foods animals eat.
- [ ] An `abstract Caretaker` class from which you can create different types of caretakers.
- [ ] An `interface` for giving clean water to an animal.
- [ ] A `data` class for an entry in a feeding schedule.

Serian muchas interfaces que solo se vas a usar seguramente una ves por cada clase hija que extendamos de la clase `abstract Caretaker`, mejor queda haciendo una interfaz `eat`, ya que todos los animales van a comer, y la reutilizamos detallando que comida van a comer en cada una, es mas legible y eficiente.

<hr/>

# 5.1: Extensions

### **Question 1**

Which one of the following returns a copy of a list?

- [ ] `add()`
- [ ] `remove()`
- [x] `reversed()`
- [ ] `contains()`

En la vida, cuando me encuentro con preguntas que no tienen 100% encaje con una de las opciones, mi cabeza implota. La funcion `reversed()` devuelve una copia de la lista, no es una simple copia, **esa "copia" la devuelve al revez**, por lo que no es una replica. La dejo como respuesta, pero si tomara la pregunta en un sentido completamente estricta, no seleccionaria ninguna, porque la funcion no simplemente copia la lista, quiza me la coloquen mala por haberla seleccionado 😬.

<hr/>

### **Question 2**

Which one of these extension functions on `class AquariumPlant(val color: String, val size: Int, private val cost: Double, val leafy: Boolean)` will give a compiler error?

- [ ] `fun AquariumPlant.isRed() = color == "red"`
- [ ] `fun AquariumPlant.isBig() = size > 45`
- [x] `fun AquariumPlant.isExpensive() = cost > 10.00`
- [ ] `fun AquariumPlant.isNotLeafy() = leafy == false`

Al intentar usar la propiedad `cost` nos dara un error de compilacion, porque `cost` esta en modo de visibilidad `privado`, lo que quiere decir que esa variable solo puede ser accedida desde dentro de la clase. 

<hr/>

### **Question 3**

Which one of the following is not a place where you can define constants with `const val`?

- [ ] at the top level of a file
- [x] in regular classes
- [ ] in singleton objects
- [ ] in companion objects

En kotlin las constantes `const val` no se pueden declarar en las clases normales, solo se puede declarar en la parte de arriba del achivo, en los objetos singleton, y en objetos complementarios(como un objeto singleton dentro de una clase).

<hr/>

# [5.2: Generics](https://developer.android.com/codelabs/kotlin-bootcamp-generics)

### **Question 1**

Which of the following is the convention for naming a generic type?

- [ ] `<Gen>`
- [ ] `<Generic>`
- [x] `<T>`
- [ ] `<X>`

Para los tipos genericos se usa `<T>` como convencion, colocandolo como "sufijo" del nombre de nuestra clase generica: `class MiClaseGenerica<T>`, es necesario seguir las convenciones para mejor lectura del codigo, nuestro yo del futuro y nuestros compañeros lo agradeceran.

<hr/>

### **Question 2**

A restriction on the types allowed for a generic type is called:

- [ ] a generic restriction
- [x] a generic constraint
- [ ] disambiguation
- [ ] a generic type limit

Las clases genericas por defecto recibiran cualquier tipo. La clase generica del ejemplo de la pregunta anterior, impicitamente se declaro asi `class MiClaseGenerica<T: Any?>`, siendo el tipo `Any` cualquier tipo, y `?` que puede ser nullable.

Para hacer mas especificos en cuanto a los tipos que se permitiran recibir en una clase generica se usan los **generic constraint**(restricciones genericas). Se colocaria el tipo que quieras recibir: 

`class MiClaseGenerica<T: [TuTipoARecibir]>`

<hr/>

### **Question 3**

Reified means:

- [ ] The real execution impact of an object has been calculated.
- [ ] A restricted entry index has been set on the class.
- [x] The generic type parameter has been made into a real type.
- [ ] A remote error indicator has been triggered.

Reified (o Real types) en Kotlin se refiere a acceder a la informacion del tipo de clase, y para poder usarlas deber ser a traves de las funciones `inline`, de lo contrario marcara error.

<hr/>