class Trade private (val id: String, val symbol: String, var quantity: Int, private var _price: Double) {

  require(_price >= 0)

  def this(id: String, symbol: String, quantity: Int) {
    this(id, symbol, quantity, 0.0)
  }

  def price = _price

  def price_= (newVal: Double): Unit = if (newVal >= 0) _price = newVal

  override def toString = s"Trade($id, $symbol, $quantity, $price)"

  def value() = price * quantity
}

object Trade {
  def apply(id: String, symbol: String, quantity: Int, price: Double): Trade = {
    val t = new Trade(id, symbol, quantity, price)
    t
  }
}