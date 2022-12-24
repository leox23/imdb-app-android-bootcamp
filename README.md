# Bootcamp Android
**Inicialmente con Andorid View, luego con Jetpack Compose y explorando la interopreabilidad entre ellos, tambien Retrofit Api Calls, Room, Corutinas, Componente de Navegación.**

### Contenido del repositorio

- El proyecto final del Bootcamp esta en la carpeta [IMDB](https://github.com/leox23/imdb-app-android-bootcamp/tree/master/IMDb).
- Hay [un ejercicio de Kotlin de nomina en consola aqui](https://github.com/leox23/imdb-app-android-bootcamp/tree/master/Semana%2001/ejercicio-nomina).
- Y un [Quiz sobre Kotlin acá.](https://github.com/leox23/imdb-app-android-bootcamp/blob/master/Semana%2001/Homework.md)

A continuación, un repaso sobre importantes puntos teóricos de programación.

- [Programación orientada a objetos (POO)](#programacion-orientada-a-objetos-poo)
  * [Abstracción](#abstraccion)
  * [Herencia](#herencia)
  * [Polimorfismo](#polimorfismo)
  * [Encapsulamiento](#encapsulamiento)
- [SOLID](#solid)
  * [S – Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
  * [O – Open/Closed Principle (OCP)](#open-closed-principle-ocp)
  * [L – Liskov Substitution Principle (LSP)](#liskov-substitution-principle-lsp)
  * [I – Interface Segregation Principle (ISP)](#interface-segregation-principle-isp)
  * [D – Dependency Inversion Principle (DIP)](#dependency-inversion-principle-dip)
- [Programación Funcional](#programacion-funcional)
    + [Funciones puras](#funciones-puras)
    + [Estados inmutables](#estados-inmutables)
    + [Composición de funciones](#composicion-de-funciones)
- [Git](#git)
  * [git clone](#git-clone)
  * [git branch](#git-branch)
  * [git checkout](#git-checkout)
  * [git status](#git-status)
  * [git add](#git-add)
  * [git commit](#git-commit)
  * [git push](#git-push)
  * [git pull](#git-pull)
  * [git revert](#git-revert)
  * [git merge](#git-merge)


# Programacion orientada a objetos POO

Es un paradigma de programación con lenguaje descriptivo y funcional, cercano al mundo real. En este método de programación el código se organiza unidades llamadas **clases** (como tu molde), de las cuales se crean **objetos** que contienen sus datos en forma de atributos y sus funcionalidades (o procesos) en forma de métodos, los objetos los relacionamos entre si para conseguir las funcionalidades que requerimos de nuestras aplicaciones.

Fue creada con el los propósito de resolver limitaciones y problemas de la programación estructurada, agregando:

- [x] Poder escalar los proyectos grandes con mayor facilidad.

- [x] Resolver la división que había entre la programación orientada a los procesos (aquí resuelto siendo métodos) y la programación orientada a los datos (aquí siendo atributos).
- [x] Facilitar la reutilización de código, lo que llevo a la posibilidad de creación de bibliotecas, y poder usar bibliotecas de terceros con facilidad, lo que evita la repetición de código.

La programación orientada a objetos tiene 4 pilares fundamentales: *Abstracción, Herencia, Polimorfismo y Encapsulamiento*. Los cuales ampliaremos a continuación.

## **Abstraccion**

Se trata de aislar una pieza de código del resto de su contexto y otras piezas de código que la acompañan, para enfocarse únicamente en ¿qué es lo que hace?, en vez de ¿cómo lo hace?.

En específico, las abstracciones dentro de la programación orientada a objetos son las características específicas de un objeto, las cuales lo distinguen de los demás tipos de objetos, a la vez que marca limites conceptuales. Un ejemplo sencillo seria:

```JavaScript
//código JavaScript
class Humano {

  constructor(edad, alimentarlo) {
    this.edad = edad;
    this.alimentarlo = alimentarlo;
  }

    alimentarse() {
      alimentarlo.darAlimento(this.edad);
      /* Qué es lo que hace el alimentarlo y darAlimento? pues ni idea. Y no me importa.
       Me importa que lo hace, el resultado que me da, no el CÓMO lo hace.
       Yo solo sé que le paso la edad a ese método y el ser vivo se alimenta 
       correctamente!
        Es un ejemplo claro de abstracción. Sabemos lo que necesitamos darle,
       y lo que recibimos de él, pero el funcionamiento interno no es de importancia. 
        Es decir, abstraemos al programador de todo el funcionamiento del método, 
       y el solo se concentrará en arreglar/hacer lo que necesite sin tener idea de lo demás*/
  }
}
```



## Herencia

Es una mecánica de POO que como hemos hablado se basa en clases, la cual equivale a un molde, y con la herencia podemos extender su funcionalidad a otras clases. Comúnmente se le llama **Clase Padre** (con sus atributos y métodos "genéricos") a la clase que extiende, y **Clase Hija** la que está recibiendo los atributos y métodos (la herencia) de la clase padre, la cual tendrá los comportamientos de la clase padre, como si hubieran sido escrito dentro de si misma, y a partir de allí extender su funcionalidad, modificarla, o ambas, aquí el potencial de reutilización de código de la programación Orientada a objetos. En síntesis: **Herencia = Copy paste**.

```Kotlin
//Kotlin

//colocamos open para permitir extender clases hijas desde esta clase padre
open class Student {
  
  // la funcion es open para poder ser moficada 
  open fun schoolFees(): BigDecimal {
    // tu implementacion
  }
}

open class GraduateStudent : Student() {
 
    // override modificando la función de schoolFees() en Student(), 
    // con override queda "open" de forma predeterminada para
    // cuando otra clase la extienda
    override fun schoolFees(): BigDecimal {
        return super.schoolFees() + calculateSchoolFees()
    }
 
    private fun calculateSchoolFees(): BigDecimal {
        // calcular y retornar
    }
}

```



## Polimorfismo 

Partiendo de descomponer el termino, tenemos **Poli** = Muchos, y **Morfismo** = forma | estructura de un cuerpo. Es la capacidad que tienen los objetos de una clase de responder a los mismos mensajes o eventos (es decir al invocar el mismo método) desde distintas clases hijas, y que cada una de esas clases pueda responder a ese mensaje de forma distinta. Esto se logra modificando los métodos y agregar atributos en la clase hija, cosas que previamente habías heredado de la clase padre. En síntesis: **Polimorfismo = modificar el Copy Paste**, sintácticamente, claro.

**Primero creamos una clase padre:**

```Kotlin
abstract class SerVivo(var name: String) {
    // aquí definimos las acciones de la clase
    abstract fun darCamisa()
}
```

**Creamos dos subclases:**

Hombre

```kotlin
// Hombre
class Hombre(name:String) :SerVivo(name){
    // reescribe el método de dar camisa
    override fun darCamisa() {
        println("${name} viste esta camisa azul.")
    }
}
```

Mujer

```Kotlin
// Mujer
class Mujer(name:String) :SerVivo(name) {
    // reescribe el método de dar camisa
    override fun darCamisa() {
        println("${name} viste esta camisa rosa.")
    }
}
```



## Encapsulamiento

Es ocultar los datos miembros de un objeto, definiendo las permisos y formas de acceso a los métodos y atributos que pertenecen a una clase, para que solo puedan ser accedidas y cambiadas por la forma definida dentro del objeto.

Existen tres principales modificadores de acceso, que son:

**Public:** en este caso, todas las clases de afuera y las de afuera del paquete tendrán acceso. cuando implementamos una clase por defecto todas las propiedades y métodos son de tipo public.

**Protected:** solo las clases del paquete pueden tener acceso.

**Private:** solo la clase principal tendrá permitido el acceso.

```kotlin
class Cocina {
    // tiempos de cocción (min)
    var arroz : Int = 25
    var pollo : Int = 35
    var tajada : Int = 5
    // las variables anteriores no tienen modificadores de acceso,
    // por lo que por defecto son Public (todos acceden y modifican)

    // métodos para cocinar
    fun Arroz() {
        if ( arroz > 24 ) {
            println("El arroz se cocinó durante ${arroz} minutos o un poco más, quedo bueno.")
        } else if (arroz > 35){
            println("El arroz se te quemo, bótalo e inténtalo de nuevo.")
        } else {
            println("El arroz aun esta crudo, déjalo más tiempo")
        }
    }
    fun Pollo() {
        println("El pollo se cocinó durante ${pollo} minutos, está bien.")
    }

    fun Tajada() {
        println("La tajada se cocinó y se volteó durante ${tajada} minutos, esta dorada")
    }
}

fun main() {
    val cocinarDeInmediato = Cocina()

    // en ocasiones no queremos que se nos cambie el valor de nuestras variables
    // aquí no queda comestible ni el pegado
    cocinarDeInmediato.arroz = 50

    // cocinamos el arroz
    cocinarDeInmediato.Arroz() // El arroz se te quemo, bótalo e inténtalo de nuevo.
}
```

Usando los modificadores de acceso (es decir encapsulando) evitamos que cambie, probemos:

```kotlin
class Cocina {
    // tiempos de cocción (min)
    private var arroz : Int = 25
    private var pollo : Int = 35
    private var tajada : Int = 5
    // con private solo podemos acceder y modificar
    // desde este mismo objeto

    // métodos para cocinar
    fun Arroz() {
        if ( arroz > 24 ) {
            println("El arroz se cocinó durante ${arroz} minutos o un poco más, quedo bueno.")
        } 
        /*...*/
    }
    /*...*/
}

fun main() {
    val cocinarDeInmediato = Cocina()

    // arroz, por estar privado, arrojara una excepción y no dejara compilar
    cocinarDeInmediato.arroz = 60 //❌Cannot access 'arroz': it is private in 'cocina'

    // cocinamos el arroz
    cocinarDeInmediato.Arroz()
}
```

Te dirás, ok, ya nadie profanara mi código del olimpo, pero... ¿y si es necesario que en casos específicos acceder a ellos o modificarlos? : Para eso existen los **Getters** y los **Setters**.

Los métodos getters son usados para obtener el valor de un atributo, y los setters para fijarles valores:

```Kotlin
class Cocina {
    // tiempos de cocción (min)
    private var arroz : Int = 25
    private var pollo : Int = 35
    private var tajada : Int = 5
    // con private solo podemos acceder y modificar
    // desde este mismo objeto

    // meollo
    fun setArroz ( arroz : Int){
        this.arroz = arroz
        // y la lógica que necesitemos
    }
    fun getArroz(): Int {
        return arroz
    }

    // métodos para cocinar
    fun Arroz() {
        if ( arroz > 24 ) {
            println("El arroz se cocinó durante ${arroz} minutos o un poco más, quedo bueno.")
        }
        /*...*/
    }
    /*...*/
}

fun main() {
    val cocinarDeInmediato = Cocina()

    // cambiamos el valor con el método set
    cocinarDeInmediato.setArroz(26)

    // si necesitáramos el valor de arroz
    // cocinarDeInmediato.getArroz()

    // cocinamos el arroz
    cocinarDeInmediato.Arroz() //El arroz se cocinó durante 25 minutos o un poco más, quedo bueno.
}
```

# SOLID

Es un acrónimo (en inglés) que se basa en los 5 principios básicos de la programación orientada a objetos, con la intención de conseguir código limpio, por lo que no es necesario refactorizar, y a la vez que sea más fácil de mantener.

Estos 5 principios son:

## Single Responsibility Principle SRP

El **Principio de Responsabilidad Única** fija la idea de que cada módulo de software de un sistema debe tener la responsabilidad de un único actor (*stakeholder*). Si vamos creando el sistema basándonos en los límites que en que obran los actores, obtenemos un sistema más robusto en el que los cambios asociados a un área, no afectara al resto del código. Al ver el panorama de única responsabilidad bajo el punto de su creador, vemos que va más allá de responsabilidades en clases y funciones, sino las responsabilidades a nivel de componentes y arquitectura de software.

Una buena manera de resumirlo es como lo dijo el mismo **Robert C. Martin** (~voz Oogway 🐢~):

> Junta las cosas que cambian por las mismas razones. Separa las cosas que cambian por diferentes razones.

Bueno, cada caso es único, por lo que es difícil generalizar, parece ser algo más profundo, sería bueno revisar a detalle su libro Clean Architecture, veamos un ejemplo.

```Kotlin
// Kotlin, pequeño ejemplo

class RegistroDeUsuario(email : String , password : String){
        fun crearUsuario(email : String, password : String){
            /*
                código de encriptación de contraseña - ❌ - colocar en otra clase
             */

            /*
            	para luego hacer...
                código de creación del usuario
             */
        }
    }
```

En este caso tenemos dos responsabilidades en la misma clase, por lo que lo ideal esas responsabilidades en clases separadas.

## Open Closed Principle OCP

El **Principio de Abierto Cerrado** afirma que cada parte del software debe ser cerrado para la modificación, pero que debe estar abierto para poder extender funcionalidades. La idea es escribir código que no se tenga que cambiar cada vez que cambien los requerimientos, lo más común es resolverlo con la **herencia** y el **polimorfismo**.

```Kotlin
data class Rectangulo(var ancho: Double, var alto : Double)
data class triangulo(var ancho: Double, var alto : Double)

    class CalculadorDeArea {
        fun computarArea( forma : Any) : Double? {

            return when (forma) {
                "Rectangulo" -> forma.ancho * forma.alto
                "triangulo" -> (forma.ancho * forma.alto)/2
                else -> null
            }
```

Podemos calcular áreas de rectángulos y triángulos, ¿que sucedería si quisiéramos calcular áreas de círculos otros? Pues tendríamos que modificar nuestra clase padre `CalculadorDeArea` si nos basamos en este modelo, estaríamos pisoteando este segundo principio. Si lo resolvemos así, el *pecadote* se vería así más o menos:

```Kotlin
data class Rectangulo(var ancho: Double, var alto : Double)
data class Triangulo(var ancho: Double, var alto : Double)
data class Circulo(var radio: Double)

    class CalculadorDeArea {
        fun computarArea( forma : Any) : Double? {

            return when (forma) {
                "Rectangulo" -> forma.ancho * forma.alto
                "Triangulo" -> (forma.ancho * forma.alto)/2
                "Circulo" -> Math.PI * (forma.radio * forma.radio)
                else -> null
            }
```

Una solución ideal sería poder usar una interface, quedaría algo así:

```Kotlin
interface FormaInterface {
    fun area() : Double
}
data class Rectangulo(var ancho: Double, var alto : Double) : FormaInterface {
    override fun area(): Double {
        return alto * ancho
    }
}

data class Triangulo(var ancho: Double, var alto : Double) : FormaInterface {
    override fun area():Double {
        return (alto * ancho)/2
    }
}

data class Circulo(var radio: Double) : FormaInterface {
    override fun area():Double {
        return Math.PI * (forma.radio * forma.radio)
    }
}

class CalculadorDeArea {
    fun computarArea( forma : FormaInterface) : Double? {
        return forma.area()
    }
}
```

De esta forma podemos fácilmente mantener la clase padre intacta, sin ningún tipo de errores futuros, y con facilidad para extender funcionalidades.

## Liskov Substitution Principle LSP

El **Principio de Sustitución de Liskov** establece toda clase que es hija de otra clase, debe poder utilizarse como la clase padre misma sin que lance una excepción, es decir que este tipo de cambios no debe generar errores, lo logramos usando **herencia** y **polimorfismo**.

```kotlin
abstract class Pato {
    fun moverse() {
        println("Se mueve")
    }
    fun nadar() {
        println("Nada")
    }
    fun flotar(){
        println("Flota")
    }
    fun volar() {
        println("Vuela")
    }
}

class PatoAdulto : Pato() {...}
class PatoDeHule : Pato() {...}
class Patito : Pato() {...}

fun main(){
    // en esta forma nuestro código, nos presentara diversos problemas
    val patoDeHule = PatoDeHule()
    patoDeHule.nadar()  // ❌ no es posible 
    patoDeHule.flotar() // ✅ posible
    
    val patito = Patito()
    patito.nadar() // ✅ posible
    patito.volar() // ❌ no es posible 
}

// dará inconsistencias a nuestro software
```

Al trabajar de esta manera lo podemos resolver cambiando esas funciones que presentaran error dentro de cada extensión de clase:

```Kotlin
// código diabólico, de ahora en adelante, no hacer ni en casa

class PatoDeHule : Pato() {
    override fun volar() {
        // No puede volar
    }
    override fun nadar() {
        // No puede nadar
    }
    override fun mover() {
        // No puede moverse
    }
}
// y así tocaría hacer con todas las funciones de todas las clases que presenten problemas
```

Para desarrollar el código con buena práctica, respetando este principio lo ideal es trabajar la clase como abierta y extenderla, en este caso, modificamos un poco el ejemplo para hacerlo más visible:

```kotlin
open class Pato {
    fun flotar(){
        println("Flota")
    }
    fun moverse() {
        println("Se mueve")
    }
    fun nadar() {
        println("Nada")
    }
}
class Patito : Pato() {
    // lo básico de un pato
    // más detalles específicos que se quiera
    // agregar de un pato pequeño
    // tamaño, lo que come, etc.
}

class PatoAdulto : Pato() {
    // lo basico de un pato + volar
    fun volar() {
        println("Vuela")
    }
    // mas todo lo demás que se necesite
}

fun main(){
    val patito = Patito()
    patito.nadar()  // ✅ posible
    patito.flotar() // ✅ posible
	
    val patoAdulto = PatoAdulto()
    // aquí podemos acceder a las operaciones de la clase padre 
    // desde una clase hija sin errores, podemos usar:
    // flotar | moverse | nadar
    patoAdulto.nadar() // ✅ posible
    patoAdulto.volar() // ✅ posible
    // este es la forma correcta de jugar con 
    // la Herencia y el Polimorfismo
}
```

Así nuestro código no tendrá comportamientos inesperados.

## Interface Segregation Principle ISP

El **Principio de Segregación de Interface** define que se debe evitar que las interfaces sean muy grandes, en específico que se eviten aplicar características extras que al objeto en realidad no deben corresponder. Es mejor tener interfaces pequeñas y especializadas, que una interface enorme, porque con una interface grandes solo se utilizan partes pequeñas en todo nuestro código. Con clases más pequeñas y especificas es mucho más fácil apuntar a las necesidades.

```Kotlin
// Kotlin
// veamos una interfaz cargada y sus consecuencias (ya habíamos visto malas clases parecidas)

interface Pato {
    fun flotar(){
        println("Flota")
    }
    fun moverse() {
        println("Se mueve")
    }
    fun nadar() {
        println("Nada")
    }
    fun volar() {
        println("Vuela")
    }
}

// si cargamos la interfaz con características que no tienen
// que ver una con la otra, luego tendremos que remover ciertas 
// características porque en todas las subclases no pueden ser usadas,
// o peor aún, que por razones obvias no deben ser usadas:
class PatoDeHule : Pato() {
    override fun moverse(){
        // No se mueve
    }
    override fun nadar(){
        // No vuela
    }
    override fun volar(){
        // No vuela
    }
}
class PatoBebe : Pato() {
    override fun volar(){
        // No vuela
    }
}
```

En cambio, en el siguiente ejemplo seleccionamos características específicas para cada clase hija:

```kotlin
interface CriaturaOCosaQueFlota {
    fun flotar(){
        println("Flota")
    }
}
interface CriaturaQueSeMueve {
    fun moverse() {
        println("Se mueve")
    }
}
interface CriaturaQueNada {
    fun nadar() {
        println("Nada")
    }
}
interface CriaturaQueVuela {
    fun volar() {
        println("Vuela")
    }
}

class PatoDeHule : CriaturaOCosaQueFlota {
    /* ... */
}
class PatoBebe : CriaturaOCosaQueFlota, CriaturaQueSeMueve, CriaturaQueNada {
    /* ... */
}

class PatoAdulto : CriaturaOCosaQueFlota, CriaturaQueSeMueve, CriaturaQueNada, CriaturaQueVuela {
    /* ... */
}
// como vemos, cada clase implementa lo que necesita en realidad.
```



## Dependency Inversion Principle DIP

El **Principio de inversión de dependencia** hace el mayor énfasis en la abstracción, nos quiere decir que implementaciones concretas, no deben depender de otras implementaciones concretas, sino que debe depender de **capas de abstracción**.  Esto nos permite por ejemplo que si nuestra base de datos usa una tecnología u otra, no nos debe importar que pueda afectar nuestro código, sino que esto lo soluciona una capa de abstracción que está construida en medio de ambos, en este caso hipotético, hablamos de nuestro código, y cualquier base de datos. 

Siendo así, la comunicación de un componente u otro componente de nuestro sistema serian simplemente interfaces, que manejaría los cambios, lo que hará nuestro código más irrompible. 

```JavaScript
// JavaScript

class Controlador {
  // El código no tiene ni idea si esto es SQL, MongoDB, HTTP...
  let datos = Repositorio.obtenerDatos() // sea cual sea se intenta conectar, sin saber que hay detras.
  manipularData(datos)
}

```

Este código de arriba trabaja sin problemas con cualquiera de las 2 interfases de abajo, segun fuera necesario se modifica, solo que nuestro componente principal sigue estando en su estado original.

``` JavaScript
// Aquí la interfaz (1) que está conectando con una base de datos
// de mongoDB
class Repositorio {
  function obtenerDatos(){
    let datos = MongoDB.find({})
    return datos
  }
}

//=========================

// Aquí la interfaz (2) en caso que la base de datos fuera SQLite
class Repository {
  function obtenerDatos(){
    let datos = SQLite.query('SELECT * FROM datos')
    return datos
  }
}
```

# Programacion Funcional

Resumiéndolo, podemos decir que la programación funcional es un paradigma en el que el código se esta compuesto de funciones. En comparación a la programación imperativa es mucho mejor, mas directa:

- Se le entrega un dato o datos.
- Se le aplica una serie de funciones consecutivas (pocas o muchas).
- Con el fin de obtener resultado deseado.

```Kotlin
// Kotlin

class Estudiante(
    val nombre: String,
    val apellido: String,
    val graduado: Boolean,
    val promedio: Double
)

Estudiante.filter { it.graduado && it.promedio > 4.0 } // paso 1
    .sortedBy { it.promedio } // paso 2
    .take(10) // paso 3
    .sortedWith(compareBy({ it.apellido }, { it.nombre })) // paso 4
```

1. Solo selecciona los estudiantes que se hayan graduado, y que tengan promedio mayor a 4.0.
2. Los ordena por el promedio.
3. Toma solo los primero 10 estudiantes.
4. Luego, los ordena por apellido, y si son iguales, los compara los nombres.

Super efectivo, cero verborreas y al grano, ¿a quién no le gusta?

Para resolver esto mismo en programación imperativa, habría que usar loops y seguramente métodos/funciones separadas línea a línea. Luego de esta pequeña vista general, aquí **las tres ventajas por las que conviene usar programación funcional**:

### Funciones puras

Está basada en funciones matemáticas, y el uso de las funciones no influye sobre la ejecución del resto del código (ej. otras funciones), porque el resultado de las funciones depende únicamente de los argumentos que recibió de entrada. No existen las variables globales.

```javaScript
// JavaScript
var miArray = [1,2,3,4,5]
// pura
miArray.slice(0,3); //=> [1,2,3]
miArray.slice(0,3); //=> [1,2,3]
miArray.slice(0,3); //=> [1,2,3]

// impura
miArray.splice(0,3); //=> [1,2,3]
miArray.splice(0,3); //=> [4,5]
miArray.splice(0,3); //=> []
```

### Estados inmutables

Acostumbramos hasta el momento tener los estados mutables. Variables a las que le reasignamos valores, o arras a los que le insertamos y quitamos lo necesario en cualquier momento de la ejecución. Los estados inmutables no son modificables después de haber sido creados o después de que se le asigno un valor.

### Composicion de funciones

Es el poder colocar funciones en cadena para que se ejecuten en serie, para obtener el resultado que deseamos. un ejemplo claro es el primer ejemplo de código de programación que mostramos, como se ejecutaba una función detrás de la otra en secuencia según se necesita

> ```kotlin
> /*...*/
> Estudiante.filter { it.graduado && it.promedio > 4.0 }
>     .sortedBy { it.promedio }
>     .take(10) 
>     .sortedWith(compareBy({ it.apellido }, { it.nombre })) 
> ```


# Git

Esta herramienta fue desarrollada por Linus Torvadls y su función es tener control de las versiones del código de forma distribuida. Parte de los comandos usados son:

## git clone

 Se usa para descargarte a tu ordenador la última versión del código fuente de un repositorio remoto (gitlab / github) , puede descargarse a través del método SSH o HTTPS.

```bash
git clone <https://el-link--con-nombre-del-repositorio>
```



## git branch

 Las ramas son de lo más importante en el mundo de git, con ellas varios desarrolladores pueden trabajar al mismo tiempo sin que hayan conflictos o superposiciones a la hora de  modificar el código, con este comando puedes listarlas, crearlas o eliminarlas a nivel local.

```bash
// creando una nueva rama
git branch <tu-rama-para-trabajar>

// visualizar ramas
git branch
git branch --list

// borrar rama
git branch -d <nombre-de-la-rama-a eliminar>
```



## git checkout

 Este comando sirve para cambiarte de rama de trabajo, una vez creada la rama para posicionarse en ella se debe hacer con este comando.

```bash
git checkout <nombre-de-la-rama-donde-quieres-trabajar>

// puedes resumir crear rama (en local) y cambiarte a esa rama
// a través del comando:
git checkout -b <nombre-de-tu-rama-a-crear-y-posicionarte>
// (el -b viene de rama (branch)) 
```



## git status

 Nos da toda la información del estado actual de la rama que estamos trabajando, detalles numerados en la imagen:

1. La rama en la que estamos posicionados.

2. Si hay cambios para confirmar, enviar o recibir (*pull*).

3. Si hay archivos que ya están en preparación (*staged*), sin preparación (*unstaged*) o archivos que no están recibiendo seguimiento (*untracked*).

4. Si hay archivos creados, modificados o eliminados.

   ![gitstatus](./gitstatus.png)



## git add

 Al realizar cambios en nuestra rama, estos cambios suceden en local, pero aún no son incluidas para el siguiente commit, con este comando podemos incluir los cambios del archivo o de los archivos para el siguiente commit:

```bash
// añadir un archivo en especifico
git add <tu-archivo>

// agregar todo
git add -A

// agregar todo lo de la carpeta donde estas actualmente
git add .
```



## git commit

 Habiendo avanzado en las mejoras y correcciones del código llegara el punto en el que queremos guardar los cambios (generalmente cuando una mejora esta completada o un bug resuelto), y así estableces un punto de control para cuando quieras continuar nuevamente, el comando va a acompañado con un mensaje descriptivo en comillas para explicar que se ha modificado dentro del margen de ese commit.

```
git commit -m "la descripcion de tu commit"
```



## git push

 Ya tenemos los comandos para trabajar las ramas a nivel local, después de haber confirmado los cambios, necesitamos enviar la nueva rama al repositorio remoto, necesitarás usar el siguiente comando:

```bash
git push <nombre-remoto> <nombre-de-rama-a-subir>

// si su rama es nueva, pude que tengas que
// cargar y subir tu rama con el siguiente comando
git push --set-upstream <nombre-remoto> <nombre-de-tu-rama-reciente>
// o su atajo
git push -u origin <nombre-de-tu-rama-reciente>

```

Ten en cuenta que `git push` solo carga los archivos que han sido confirmados (con `git commit`).



## git pull

 Utilizamos este comando para recibir actualizaciones del repositorio remoto. Este comando fusiona las funcionalidades de los comandos `git fetch` y `git merge`, lo que quiere decir que al usar `git pull`, jalaremos las actualizaciones del repositorio remoto (`git fetch`) y de inmediato aplicamos esos últimos cambios en local (`git merge`)

```bash
git pull <nombre-remoto>
```

Recuerda, este comando puede generar conflictos que tendremos que resolver nosotros mismos.



## git revert

 En ocasiones hacemos `git commit`/`push` a codigo con ciertos errores que queremos corregir, hay varios comandos para deshacer cambios en local o remoto, estos comandos hay que tratarlos con cuidado, pausadamente, porque queriendo corregir algo podemos cometer error encima de error. Es necesario primero revisar el historial de commits, lo hacemos con el comando `git log` y veras un listado detallado de tus commits asi:

![gitlog](./gitlog.png)

Ya visto el historial usamos el numero (alfanumerico) del commit que queremos revertir:

```bash
git revert <tu-commit-a-revertir>
```

Una ventaja de usar git revert es que lo soluciona creando un nuevo commit revertiendo el anterior. 




## git merge

Por ultimo y no menos importante, cuando ya hayas completado tu parte del proyecto, y pulido todos los detalles, asegurándote de que todo funcione correctamente, el ultimo paso es fusionar la rama que desarrollaste con su rama padre (**`master`** en este proyecto), 

El paso a paso es:

**1) Debes pasarte a la rama `master` (o cual sea tu rama principal):**

```bash
git checkout master
```

**2) Antes de fusionarla, debes actualizar tu rama `master` local:**

```bash
git fetch
```

**3) Ahora si, puedes fusionar las características de tu rama con la rama `master`:**

```bash
git merge <nombre-de-la-rama-a-fusionar>
```

Asegúrate de que tu rama master tenga la última versión (paso 1 y 2) antes de fusionar la rama, sino te presentara conflictos y cosas que no esperabas.
