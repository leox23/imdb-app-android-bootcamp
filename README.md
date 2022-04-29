# Programacion orientada a objetos (POO)

Es un paradigma de programacion con lenguaje descriptivo y funcional, cercano al mundo real. En este metodo de programacion el codigo se organiza unidades llamadas **clases** (como tu molde), de las cuales se crean **objetos** que contienen su datos en forma de atributos y sus funcionalidades (o procesos) en forma de metodos, los objetos los relacionamos entre si para consegir las funcionalidades que requerimos de nuestras aplicaciones.

Fue creada con el los proposito de resolver limitaciones y problemas de la programacion estructurada, agregando:

- [x] Poder escalar el projectos grandes con mayor facilidad.

- [x] Resolver la division que habia entre la programacion orientada a los procesos (aqui resuelto siendo metodos) y la programacion orientada a los datos (aqui siendo atributos).
- [x] Facilitar la reutilizacion de codigo, lo que llevo a la posibilidad de creacion de bibliotecas, y poder usar bibliotecas de terceros con facilidad, lo que evita la repeticion de codigo.

La programacion orientada a objetos tiene 4 pilares fundamentales: *Abstracion, Herencia, Polimorfismo y Encapsulamiento*. Los cuales ampliaremos a continuacion.

## **Abstracion**

Se trata de aislar una pieza de codigo del resto de su contexto y otras piezas de codigo que  la acompañan, para enfocarse unicamente en ¿que es lo que hace?, en vez de ¿como lo hace?.

En especifico, las abstracciones dentro de la programacion orientada a objetos son las caracteristicas especificas de un objeto, las cuales lo distinguen de los demas tipos de objetos, a la ves que marca limites conceptuales. Un ejemplo sencillo seria:

```javascript
//codigo JavaScript
class Humano {

  constructor(edad, alimentarlo) {
    this.edad = edad;
    this.alimentarlo = alimentarlo;
  }

    darComida() {
    alimentarlo.comida(this.edad);
    /* Qué es lo que hace el alimentarlo? ps ni idea. Y no me importa.
     Me importa que lo hace, el resultado que me da, no el CÓMO lo hace.
     Yo solo sé que le paso la edad a ese método y el ser vivo se alimenta 
     correctamente!.
      Es un ejemplo claro de abstraccion. Sabemos lo que necesitamos darle,
     y lo que recibimos de el, pero el funcionamiento interno no es de importancia. 
      Es decir, abstraemos al programador de todo el  funcionamiento del método, 
     y el solo se concentrara en  arreglar/hacer lo que necesite sin tener idea de lo demas*/
  }
}
```



## Herencia

Es una mecanica de POO que como hemos hablado se basa en clases, la cual equivale a un molde, y con la herencia podemos extender su funcionalidad a otras clases. Comunmente se le llama **Clase Padre** (con sus atributos y metodos "genericos") a la clase que extiende, y **Clase Hija** la que esta recibiendo los atributos y metodos (la herencia) de la clase padre, la cual tendra los comportamientos de la clase padre, como si hubieran sido escrito dentro de si misma, y apartir de alli extender su funcionalidad, modificarla, o ambas, aqui el potencial de reutilizacion de codigo de la programacion Orientada a objetos. En sintesis: **Herencia = Copy paste**.

```kotlin
//Kotlin

//colocamos open para permitir extender clases hijas desde esta clase padre
open class Student {
  
  // la funcion es open para poder ser moficada 
  open fun schoolFees(): BigDecimal {
    // do implementation
  }
}

open class GraduateStudent : Student() {
 
    // override modificando la funcion de schoolFees() en Student(), 
    // con override queda "open" de forma predeterminada para
    // cuando otra clase la exitienda
    override fun schoolFees(): BigDecimal {
        return super.schoolFees() + calculateSchoolFees()
    }
 
    private fun calculateSchoolFees(): BigDecimal {
        // calcular y retornar
    }
}

```



## Polimorfismo 

Partiendo de descomponer el termino, tenemos **Poli** = Muchos, y **Morfismo** = forma | estructura de un cuerpo. Es la capacidad que tienen los objetos de una clase de responder a los mismos mensajes o eventos (es decir al invocar el mismo metodo) desde distintas clases hijas, y que cada una de esas clases pueda responder a ese mensaje de forma distinta. Esto se logra modificando los metodos y agregar atributos en la clase hija, cosas que previamente habias heredado de la clase padre. En sintesis: **Polimorfismo = modificar el Copy Paste**, sintactimente, claro.

**Primero creamos una clase padre:**

```kotlin
abstract class SerVivo(var name: String) {
    // aqui definimos las acciones de la clase
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

Mujeres

```kotlin
// Mujer
class Mujer(name:String) :SerVivo(name) {
    // reescribe el método de dar camisa
    override fun darCamisa() {
        println("${name} viste esta camisa rosa.")
    }
}
```



## Encapsulamiento

Es ocultar los datos miembros de un objeto, definiendo las permisos y formas de acceso a los metodos y atributos que pertenecen a una clase, para que solo puedan ser accedidas y cambiadas por la forma definida dentro del objeto.

Existen tres principales modificadores de acceso, que son:

**Public:** en este caso, todas las clases de afuera y las de afuera del paquete tendran acceso. cuando implementamos una clase por defecto todas las propiedades y métodos son de tipo public.

**Protected:** solo las clases del paquete pueden tener aceso.

**Private:** solo la clase principal tendra permitido el acceso.

```kotlin
class Cocina {
    // tiempos de coccion (min)
    var arroz : Int = 25
    var pollo : Int = 35
    var tajada : Int = 5
    // las variables anteriores no tienen modificadores de acceso,
    // por lo que por defecto son Public (todos acceden y modifican)

    // metodos para cocinar
    fun Arroz() {
        if ( arroz > 24 ) {
            println("El arroz se cocino durante ${arroz} minutos o un poco mas, quedo bueno.")
        } else if (arroz > 35){
            println("El arroz se te quemo, botalo e intentalo de nuevo.")
        } else {
            println("El arroz aun esta crudo, dejalo mas tiempo")
        }
    }
    fun Pollo() {
        println("El pollo se cocino durante ${pollo} minutos, esta bien.")
    }

    fun Tajada() {
        println("La tajada se cocino y se volteo durante ${tajada} minutos, esta dorada")
    }
}

fun main() {
    val cocinarDeInmediato = Cocina()

    // en ocaciones no queremos que se nos cambie el valor de nuetras variables
    // aqui no queda comestible ni el pegado
    cocinarDeInmediato.arroz = 50

    // cocinamos el arroz
    cocinarDeInmediato.Arroz() // El arroz se te quemo, botalo e intentalo de nuevo.
}
```

Usando los modificadores de acceso (encapsulando) evitamos que cambie, probemos:

```kotlin
class Cocina {
    // tiempos de coccion (min)
    private var arroz : Int = 25
    private var pollo : Int = 35
    private var tajada : Int = 5
    // con private solo podemos acceder y modificar
    // desde este mismo objeto

    // metodos para cocinar
    fun Arroz() {
        if ( arroz > 24 ) {
            println("El arroz se cocino durante ${arroz} minutos o un poco mas, quedo bueno.")
        } 
        /*...*/
    }
    /*...*/
}

fun main() {
    val cocinarDeInmediato = Cocina()

    // arroz, por estar privado, arrojara una excepsion y no dejara compilar
    cocinarDeInmediato.arroz = 60 //❌Cannot access 'arroz': it is private in 'cocina'

    // cocinamos el arroz
    cocinarDeInmediato.Arroz()
}
```

Te diras, ok, ya nadie profanara mi codigo del olimpo, pero... ¿y si es necesario que en casos especificos acceder a ellos o modificarlos? : Para eso existen los **Getters** y los **Setters**.

Los metodos getters son usados para obtener el valor de un atributo, y los setters para fijarles valores:

```kotlin
class Cocina {
    // tiempos de coccion (min)
    private var arroz : Int = 25
    private var pollo : Int = 35
    private var tajada : Int = 5
    // con private solo podemos acceder y modificar
    // desde este mismo objeto

    // meollo
    fun setArroz ( arroz : Int){
        this.arroz = arroz
        // y la logica que necesitemos
    }
    fun getArroz(): Int {
        return arroz
    }

    // metodos para cocinar
    fun Arroz() {
        if ( arroz > 24 ) {
            println("El arroz se cocino durante ${arroz} minutos o un poco mas, quedo bueno.")
        }
        /*...*/
    }
    /*...*/
}

fun main() {
    val cocinarDeInmediato = Cocina()

    // cambiamos el valor con el metodo set
    cocinarDeInmediato.setArroz(26)

    // si necesitaramos el valor de arroz
    // cocinarDeInmediato.getArroz()

    // cocinamos el arroz
    cocinarDeInmediato.Arroz() //El arroz se cocino durante 25 minutos o un poco mas, quedo bueno.
}
```

# SOLID

Es un acronimo (en ingles) que se basa en los 5 principios basicos de la programacion orientada a objetos, con la intencion de conseguir codigo limpio, por lo que no es necesario refactorizar, y a la vez que sea mas facil de mantener.

Estos 5 principios son:

## S – Single Responsibility Principle (SRP)

El **Principio de Responsabilidad Unica** fija la idea de que cada módulo de software de un sistema debe tener la  responsabilidad de un único actor (*stakeholder*). Si vamos creando el sistema basandonos en los limites que en que obran los actores, obtenemos un sistema más robusto en el que los cambios asociados a un área, no afectara al resto del codigo. Al ver el panorama de unica responsabilidad bajo el punto de su creador, vemos que va mas alla de responsabilidades en clases y funciones, sino las responsabilidades a nivel de componentes y arquitectura de software.

Una buena manera de resumirlo es como lo dijo el mismo **Robert C. Martin** (~voz Oogway 🐢~):

> Junta las cosas que cambian por las mismas razones. Separa las cosas que cambian por diferentes razones.

Bueno, cada caso es unico, por lo que es dificil generalizar, parece ser algo mas profundo, seria bueno revisar a detalle su libro Clean Architecture.

```kotlin
// kotlin, pequeño ejemplo

class RegistroDeUsuario(email : String , password : String){
        fun crearUsuario(email : String, password : String){
            /*
                codigo de encriptacion de contraseña - ❌ - colocar en otra clase
             */

            /*
            	para luego hacer...
                codigo de creacion del usuario
             */
        }
    }
```

En este caso tenemos dos responsabilidades en la misma clase, por lo que lo ideal esas responsabilidades en clases separadas.

## O – Open/Closed Principle (OCP)

El **Principio de Abierto Cerrado** afirma que cada parte del software debe ser cerrado para la modificacion, pero que debe estar abierto para poder extender funcionalidades. La idea es escribir codigo que no se tenga que cambiar cada vez que cambien los requerimientos, lo mas comun es resolverlo con la **herencia** y el **polimorfismo**.

```kotlin
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

Podemos calcular areas de rectangulos y triangulos, que sucederia si quisieramos calcular areas de circuloso otros? Pues tendriamos que modificar nuestra clase padre `CalculadorDeArea` si nos basamos en este modelo, estariamos pisotearamos este segundo principio. Si lo resolvemos asi, el *pecadote* se veria asi mas o menos:

```kotlin
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

Una solucion ideal seria poder usar una interface, quedaria algo asi:

```kotlin
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

De esta forma podemos facilmente mantener la clase padre intacta, sin ningun tipo de errores futuros, y con facilidad para extender funcionalidades.

## L – Liskov Substitution Principle (LSP)

El **Principio de Sustitucion de Liskov** establece toda clase que es hija de otra clase, debe poder utiliazarse como la clase padre misma sin que lanze un excepsion, es decir que este tipo de cambios no debe generar errores, lo logramos usando **herencia** y **polimorfismo**.

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
    // en esta forma nuestro codigo, nos presentara diversos problemas
    val patoDeHule = PatoDeHule()
    patoDeHule.nadar()  // ❌ no es posible 
    patoDeHule.flotar() // ✅ posible
    
    val patito = Patito()
    patito.nadar() // ✅ posible
    patito.volar() // ❌ no es posible 
}

// dara inconsistencias a nuestro soft
```

Al trabajar de esta manera lo podemos resolver cambiando esas funciones que presentaran error dentro de cada extension de clase:

```kotlin
// codigo diabolico, de ahora en adelante, no hacer ni en casa

class PatoDeHule : Pato() {
    override fun volar() {
        // No puede volar
    }
    override fun nadar() {
        // No puede nadar
    }
    override fun mover() {
        // No puede movese
    }
}
// y asi tocaria hacer con todas las funciones de todas las clases que presenten problemas
```

Para desarrollar el codigo con buena practica, respetando este principio lo ideal es trabajar la clase como abierta y extenderla, en este caso, modificamos un poco el ejemplo para hacerlo mas visible:

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
    // lo basico de un pato
    // mas detalles especificos que se quiera
    // agregar de un pato pequeño
    // tamaño, lo que come, etc.
}

class PatoAdulto : Pato() {
    // lo basico de un pato + volar
    fun volar() {
        println("Vuela")
    }
    // mas todo lo demas que se necesite
}

fun main(){
    val patito = Patito()
    patito.nadar()  // ✅ posible
    patito.flotar() // ✅ posible
	
    val patoAdulto = PatoAdulto()
    // aqui podemos acceder a las operaciones de la clase padre 
    // desde una clase hija sin errores, podemos usar:
    // flotar | moverse | nadar
    patoAdulto.nadar() // ✅ posible
    patoAdulto.volar() // ✅ posible
    // este es la forma correcta de jugar con 
    // la Herencia y el Polimorfismo
}
```

Asi nuestro codigo no tendra comportamientos inesperados.

## I – Interface Segregation Principle (ISP)

El **Principio de Segregacion de Interface** define que se debe evitar que las interfaces sean muy grandes, en especifico que se eviten aplicar caracteristicas extras que al objeto en realidad no deben corresponder. Es mejor tener interfaces pequeñas y especializadas, que una interface enorme, porque con una interface grandes solo se utilizan partes pequeñas en todo nuestro codigo. Con clases mas pequeñas y especificas es mucho mas facil apuntar a las necesidades.

```kotlin
// Kotlin
// veamos una interfaz cargada y sus consecuencias (ya habiamos visto malas clases parecidas)

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

// si cargamos la interfaz con caracteristicas que no tienen
// que ver una con la otra, luego tendremos que remover ciertas 
// caracteristicas porque en todas las subclases no pueden ser usadas,
// o peor aun, que por razones obvias no deben ser usadas:
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

En cambio, en el siguiente ejemplo seleccionamos caracteristicas especificas para cada clase hija:

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



## D – Dependency Inversion Principle (DIP)

El **Principio de inversion de dependencia** hace el mayor enfasis en la abstraccion, nos quiere decir que implementaciones concretas, no deben depender de otras implementaciones concretas, sino que debe depender de **capas de abstraccion**.  Esto nos permite por ejemplo que si nuestra base de datos usa una tecnologia o otra, no nos debe importar que pueda afectar nuestro codigo, sino que esto lo soluciona una capa de abstraccion que esta construida en medio de ambos, en este caso hipotetico, hablamos de nuestro codigo, y cualquier base de datos. 

Siendo asi, la comunicacion de un componente u otro componente de nuestro sistema serian simplemente interfaces, que manejaria los cambios, lo que hara nuestro codigo mas irrompible. 

```javascript
// JavaScript

class Controlador {
  // El codigo no tiene ni idea si esto es SQL, MongoDB, HTTP...
  let datos = Repositorio.obtenerDatos() // sea cual sea se conecta
	manipularData(datos)
}

```

Este codigo de arriba trabaja sin problemas con cualquiera de las 2 interfases de abajo, segun fuera necesario se modifica, solo que nuestro componente principal sigue estando en su estado original.

``` javascript
// Aqui la interfaz (1) que esta conectando con una base de datos
// de mongoDB
class Repositorio {
  function obtenerDatos(){
    let datos = MongoDB.find({})
    return datos
  }
}

//=========================

// Aqui la interfaz (2) en caso que la base de datos fuera SQLite
class Repository {
  function obtenerDatos(){
    let datos = SQLite.query('SELECT * FROM datos')
    return datos
  }
}
```

# Programacion Funcional

Resumiendolo, podemos decir que la programacion funcional es un paradigma en el que el codigo se esta compuesto de funciones. En comparacion a la programacion imperativa es mucho mejor, mas directa:

- Se le entrega un dato o datos.
- Se le aplica una serie de funciones consecutivas (pocas o muchas).
- Con el fin de obtener resultado deseado.

```kotlin
// Kotlin
// un ejemplo random

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

Super efectivo, cero verborrea y al grano, ¿a quien no le gusta?

Para resolver esto mismo en programacion imperativa, habria que usar loops y seguramente metodos/funciones separadas linea a linea. Luego de este pequeña vista general, aqui **las tres ventajas por las que conviene usar programacion funcional**:

### Funciones puras

Esta basada en funciones matematicas, y el uso de las funciones no influye sobre la ejecucion del resto del codigo (ej. otras funciones), porque el resultado de las funciones depende unicamente de los argumentos que recibio de entrada. No existen las variables globales.

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

Acostumbramos hasta el momento tener los estados mutables. Variables a las que le reasignamos valores, o arrays a los que le insertamos y quitamos lo necesario en cualquier momento de la ejecucion. Los estados inmutables no son modificables despues de haber sido creados o despues de que se le asigno un valor.

### Composicion de funciones

Es el poder colocar funciones en cadena para que se ejecuten en serie, para obtener el resultado que deseamos. un ejemplo claro es el primer ejemplo de codigo de programacion que mostramos, como se ejecutaba una funcion detras de la otra en secuencia segun se necesita

> ```kotlin
> /*...*/
> Estudiante.filter { it.graduado && it.promedio > 4.0 }
>     .sortedBy { it.promedio }
>     .take(10) 
>     .sortedWith(compareBy({ it.apellido }, { it.nombre })) 
> ```


# Git

Esta herramienta fue desarrollada por Linus Torvadls y su funcion es tener control de las versiones del codigo de forma distribuida. Parte de los comandos usados son:

## git clone

 Se usa para descargarte a tu ordenador la ultima version del codigo fuente de un repositorio remoto (gitlab / github) , puede descargarse a traves del metodo SSH o HTTPS.

```bash
git clone <https://el-link--con-nombre-del-repositorio>
```



## git branch

 Las ramas son de lo mas importante en el mundo de git, con ellas varios desarrolladores pueden trabajar al mismo tiempo sin que hayan conflictos o superposiciones a la hora de  modificar el codigo, con este comando puedes listarlas, crearlas o eliminarlas a nivel local.

```bash
//  creando una nueva rama
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

// puedes puedes resumir crear rama (en local) y cambiarte a esa rama
// a traves del comando:
git checkout -b <nombre-de-tu-rama-a-crear-y-posicionarte>
// (el -b viene de rama (branch)) 
```



## git status

 Nos da toda la infromacion del estado actual de la rama que estamos trabajando, detalles numerados en la imagen:

1. La rama en la que estamos posicionados.

2. Si hay cambios para confirmar, enviar o recibir (*pull*).

3. Si hay archivos que ya estan en preparación (*staged*), sin preparación (*unstaged*) o archivos que no están recibiendo seguimiento (*untracked*).

4. Si hay archivos creados, modificados o eliminados.

   ![gitstatus](./gitstatus.png)



## git add

 Al realizar cambios en nuestra rama, estos cambios suceden en local pero aun no son incluidas para el siguiente commit, con este comando podemos incluir los cambios del archivo o de los archivos para el siguiente commit:

```bash
// añadir un archivo en especifico
git add <tu-archivo>

// agregar todo
git add -A

// agregar todo lo de la carpeta donde estas actualmente
git add .
```



## git commit

 Habiendo avanzado en las mejoras y correciones del codigo llegara el punto en el que queremos guardar los cambios (generalmente cuando una mejora esta completada o un bug resuelto), y asi estableces un punto de control para cuando quieras continuar nuevamente, el comando va a acompañado con un mesaje descriptivo en comillas para explicar que se ha modificado dentro del margen de ese commit.

```
git commit -m "la descripcion de tu commit"
```



## git push

 Ya tenemos los comandos para trabajar las ramas a nivel local, despues de haber confirmado los cambios, necesitamos enviar la nueva rama al repositorio remoto, necesitarás usar el siguiente comando:

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

 Utilisamos este comando para recibir actualizaciones del repositirio remoto. Este comando fusiona las funcionalidades de los comandos `git fetch` y `git merge`, lo que quiere decir que al usar `git pull`, jalaremos las actualizaciones del repositorio remoto (`git fetch`) y de inmediato aplicamos esos ultimos cambios en local (`git merge`)

```bash
git pull <nombre-remoto>
```

Recuerda, este comando puede generar conflictos que tendremos que resolver nosotros mismos.



## git revert

 En ocaciones hacemos `git commit`/`push` a codigo con ciertos errores que queremos corregir, hay varios comandos para deshacer cambios en local o remoto, estos comandos hay que tratarlos con cuidado, pausadamente, porque queriendo corregir algo podemos cometer error encima de error. Es necesario primero revisar el historial de commits, lo hacemos con el comando `git log` y veras un listado detallado de tus commits asi:

![gitlog](./gitlog.png)

Ya visto el historial usamos el numero (alfanum) del commit que queremos revertir:

```bash
git revert <tu-commit-a-revertir>
```

Una ventaja de usar git revert es que lo soluciona creando un nuevo commit revertiendo el anterior. 




## git merge

Por ultimo y no menos imortante, cuando ya hayas completado tu parte del projecto, y pulido todos los detalles, asegurandote de que todo funcione correctamente, el ultimo paso es fusionar la rama que desarrollaste con su rama padre (**`master`** en este projecto), 

El paso a paso es:

**1) Debes pasarte a la rama `master` (o cual sea tu rama principal):**

```bash
git checkout master
```

**2) Antes de fusionarla, debes actualizar tu rama `master` local:**

```bash
git fetch
```

**3) Ahora si, puedes fusionar las caracteristicas de tu rama con la rama `master`:**

```bash
git merge <nombre-de-la-rama-a-fusionar>
```

Asegurate de que tu rama master tenga la ultima version (paso 1 y 2) antes de fusionar la rama, sino te presentara conflictos y cosas que no esperabas.
