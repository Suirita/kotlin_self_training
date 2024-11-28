val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

fun main() {
  solarSystem.remove("Future Moon")
  println(solarSystem.contains("Pluto"))
  println("Future Moon" in solarSystem)
}