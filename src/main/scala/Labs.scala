
import java.text.SimpleDateFormat

object Labs extends App {

  def toFahrenheit(celcius: Double) = (celcius * 9 / 5) + 32

  def toFormattedDate(dateStr: String) = {
    val date = new SimpleDateFormat("dd/MM/yy").parse(dateStr)

    val formattedDate = new SimpleDateFormat("d MMMM yyyy").format(date)

    val items = formattedDate.split(" ")

    s"${items(0)}${suffix(items(0).toInt)}  ${items(1)} ${items(2)}"
  }


  def suffix(n: Int): String = {
    if (n >= 11 && n <= 13) "th"
    else {
      n % 10 match {
        case 1 => "st"
        case 2 => "nd"
        case 3 => "rd"
        case _ => "th"
      }
    }
  }


  println(toFormattedDate("13/12/15"))

  println(toFahrenheit(35))


  val data = """root:x:0:0:root:/root:/bin/bash
               |bin:x:1:1:bin:/bin:/sbin/nologin
               |daemon:x:2:2:daemon:/sbin:/sbin/nologin
               |adm:x:3:4:adm:/var/adm:/sbin/nologin
               |lp:x:4:7:lp:/var/spool/lpd:/sbin/nologin
               |sync:x:5:0:sync:/sbin:/bin/sync
               |""".stripMargin.split("\\n")

  val pattern = raw"(root|bin|daemon|adm|lp|sync):(x):(0|1|2|3|4|5):(0|1|2|3|4|7):(root|bin|daemon|adm|lp|sync):/(sbin|root|var/adm|var/spool/lpd|bin):/(bin/bash|sbin/nologin|bin/sync)".r


  for (line <- data) {

    val pattern(username, password, userid, groupId, description, homeDirectory, shell) = line.strip()

    println(username,password, userid, groupId, description, homeDirectory, shell)
  }


}


