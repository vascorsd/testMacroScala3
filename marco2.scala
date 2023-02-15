package marco2

import scala.quoted.*

inline 
def mirror[T]: List[String] = ${ mirrorImpl[T] }

def mirrorImpl[T: Type](using Quotes): Expr[List[String]] =
  import quotes.reflect.*

  def rec[A: Type]: List[String] =
    Type.of[A] match
      case '[field *: fields] =>
        Type.show[field] :: rec[fields]
      case '[EmptyTuple] =>
        Nil 
      case _ =>
        report.errorAndAbort("Expected known tuple but got: " + Type.show[A])

  Expr(rec)