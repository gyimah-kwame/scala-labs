import java.time.{LocalDate, Period}

class Person (val first: String, val last: String, val dob: String) {

  def age = {
    Period.between(LocalDate.parse(dob), LocalDate.now()).getYears
  }

}
