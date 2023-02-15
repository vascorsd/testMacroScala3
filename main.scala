import marco1.*
import marco2.*

@main def test = 
  val x: Int = default1[Int]
  //val w: String = default2[String] -- not compile, since String cannot be calculated without transparent
  val y: List[String] = mirror[EmptyTuple]
  //val z = mirror[String] -- does not compile, good
  
  println(x)
  //println(w)
  println(y)
  //println(z)
