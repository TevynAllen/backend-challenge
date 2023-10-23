package vigil.textmanipulation

object TextManipulator:
  def generateText(text: String, allowedCharacterNumberPerLine: Int): String =
    separateText(text, allowedCharacterNumberPerLine).mkString("\n")

  private def separateText(text: String, allowedCharacterNumberPerLine: Int): List[String] =
    val listWithEachWord = text.split("\\s")
    listWithEachWord.foldLeft(List.empty[String]) { (generatedText, word) =>
      if generatedText.isEmpty || generatedText.head.length + word.length + 1 > allowedCharacterNumberPerLine
      then word :: generatedText
      else (generatedText.head + " " + word) :: generatedText.tail
    }.reverse

end TextManipulator
