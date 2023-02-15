package marco1

import scala.quoted.*

transparent 
inline 
def default1[U]: Any = ${ defaultImpl[U] }

inline 
def default2[U]: Any = ${ defaultImpl[U] }

def defaultImpl[T: Type](using Quotes): Expr[Any] = 
  import quotes.reflect.*

  Type.of[T] match {
    case '[Int]    => '{ 0 }
    case '[String] => '{ "" }
    case _ => report.errorAndAbort("no default available for type")
  }
