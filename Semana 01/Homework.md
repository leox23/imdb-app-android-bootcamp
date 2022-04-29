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