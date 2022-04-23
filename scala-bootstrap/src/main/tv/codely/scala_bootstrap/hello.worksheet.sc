println("Hello, wordl!")

val x:Int = 1
x+x

// IF FLOW

val lele =  if(x>0) 3 else  -3

lele

// FOR EACH FLOW
var y = 0
for (i <- 1 to 10) {
  y = y + i
  println(y)
}


(1 to 10).foreach((y:Int)=>println(y))

// One element is similar to _
(1 to 10).foreach(println(_))

// println === println(_) if there's just one argument
(1 to 10).foreach(println)


// Notación infija (métodos que solo reciben un argumento)
(1 to 10) foreach println

val totalSum = (1 to 10) sum

totalSum

/// Funciones anónimas, de orden superior y currying

def print(
    value:String,
    printer:String=>Unit,
):Unit = printer(value)

// Unit -->Estáncia vacía pero hay un side effect
// void --> No hay side effect
def printlnPrinter(value:String):Unit = println(value)

val printlnPrinterVal = (value:String) => println(value)

print("Hello",printlnPrinter)
print("Hello",printlnPrinterVal)
print("Hello",(value:String)=>println(value)) // Esto es uso de una funcuón anónima


// Currying
def suma(a:Int)(b:Int): Int = a+b

def add1(b:Int) = suma(1)(b)
val add2 = suma(2)_

add1(1)
add2(1)

def printCurrying(printer:String=>Unit)(value:String) = printer(value)

val printStd = printCurrying(printlnPrinter)_
printStd("Hello")


// Genéricos
// Seq --> Lista se elementos secuencial
val initSeq:Seq[Int] = Seq(1,2,3,4,5)
val stringSeq:Seq[String] = Seq("a","b","c","d","e")

// Value objects
case class UserId(value:String)
case class User(id:UserId)

// Interfaz genérica
// No es aconsejable generar interfaces genéricas
trait Repository[AggregateIdType, AggregateType] {
  def save(aggregate:AggregateType):Unit
  def search(id:AggregateIdType):AggregateType
}

class UserRepository extends Repository[UserId, User] {
  def save(aggregate:User):Unit = ()
  def search(id:UserId):User = User(id)
}

// Collections
val testSeq = Seq[Int](1,2,3,4,5,1)
val testSet = Set(1,2,3,4,5,5,5,5,1)
val testMap = Map(1->"uno",2->"dos",3->"tres")

// Añadir al final
testSeq:+1

// Añadir al principio
2+:testSeq
