package utils{
  object PasswdGen {
    private val allowedChars = (('0' to '9') ++
                        ('A' to 'Z') ++
                        ('a' to 'z')).toArray ++ Array('-', '.', '_', '?', '@')
    private def nextChar() = {
      allowedChars(util.Random.nextInt(allowedChars.length))
    }
    def nextPasswd(passwdLen: Int) = {
      val passwd = new StringBuilder(passwdLen)
      for (i <- 0 to passwdLen){
        passwd += nextChar()
      }
      passwd.toString
    }
  }
}
