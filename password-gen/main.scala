import utils._
object Appl {
  def savePasswd(fileIn: String, fileOut: String, passwdLen: Int) = try {
    val inFile = scala.io.Source.fromFile(fileIn)
    val outFile = new java.io.PrintWriter(fileOut)
    try {
      for (login <- inFile.getLines){
        outFile.println(login + ":" + PasswdGen.nextPasswd(passwdLen))
      }
    }
    finally {
      inFile.close
      outFile.close
    }
  }
  catch {
    case ex: java.io.FileNotFoundException =>
      println(ex.getMessage)
    case ex: Throwable =>
      println("Default exception handler: "+ ex.getMessage)
  }

  def main(args: Array[String]) {
    savePasswd("logins.txt", "login-passwds.txt", 10)
  }
}
