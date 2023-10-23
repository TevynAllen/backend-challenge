import TextManipulatorSpec.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import vigil.textmanipulation.TextManipulator

class TextManipulatorSpec extends AnyFlatSpec with Matchers with TableDrivenPropertyChecks:

  val textGenerationCharacterTable = Table(
    ("allowedCharacterNumberPerLine", "expectedCharactersPerLine"),
    (10, ExpectedText10CharactersPerLine),
    (20, ExpectedText20CharactersPerLine),
    (30, ExpectedText30CharactersPerLine),
    (40, ExpectedText40CharactersPerLine),
    (50, ExpectedText50CharactersPerLine)
  )

  forAll(textGenerationCharacterTable){ (allowedCharacterNumberPerLine, expectedCharactersPerLine) =>
    it should s"return the correct result with characters per line are no more than $allowedCharacterNumberPerLine" in {
      TextManipulator.generateText(SampleText, allowedCharacterNumberPerLine) shouldEqual expectedCharactersPerLine
    }
  }

  it should "not split words and return one word per line if the allowedCharacters per line are equal or lower to the minimum word" in {
    TextManipulator.generateText(SampleText, allowedCharacterNumberPerLine = 0) shouldEqual MinimumAllowedNumberOfWordsPerLine
  }
end TextManipulatorSpec

object TextManipulatorSpec:
  val SampleText: String = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. " +
    "He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his " +
    "new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."

  val ExpectedText10CharactersPerLine: String = """In 1991,
                                                  |while
                                                  |studying
                                                  |computer
                                                  |science at
                                                  |University
                                                  |of
                                                  |Helsinki,
                                                  |Linus
                                                  |Torvalds
                                                  |began a
                                                  |project
                                                  |that later
                                                  |became the
                                                  |Linux
                                                  |kernel. He
                                                  |wrote the
                                                  |program
                                                  |specifically
                                                  |for the
                                                  |hardware
                                                  |he was
                                                  |using and
                                                  |independent
                                                  |of an
                                                  |operating
                                                  |system
                                                  |because he
                                                  |wanted to
                                                  |use the
                                                  |functions
                                                  |of his new
                                                  |PC with an
                                                  |80386
                                                  |processor.
                                                  |Development
                                                  |was done
                                                  |on MINIX
                                                  |using the
                                                  |GNU C
                                                  |Compiler.""".stripMargin

  val ExpectedText20CharactersPerLine: String = """In 1991, while
                                                  |studying computer
                                                  |science at
                                                  |University of
                                                  |Helsinki, Linus
                                                  |Torvalds began a
                                                  |project that later
                                                  |became the Linux
                                                  |kernel. He wrote the
                                                  |program specifically
                                                  |for the hardware he
                                                  |was using and
                                                  |independent of an
                                                  |operating system
                                                  |because he wanted to
                                                  |use the functions of
                                                  |his new PC with an
                                                  |80386 processor.
                                                  |Development was done
                                                  |on MINIX using the
                                                  |GNU C Compiler.""".stripMargin

  val ExpectedText30CharactersPerLine: String = """In 1991, while studying
                                                  |computer science at University
                                                  |of Helsinki, Linus Torvalds
                                                  |began a project that later
                                                  |became the Linux kernel. He
                                                  |wrote the program specifically
                                                  |for the hardware he was using
                                                  |and independent of an
                                                  |operating system because he
                                                  |wanted to use the functions of
                                                  |his new PC with an 80386
                                                  |processor. Development was
                                                  |done on MINIX using the GNU C
                                                  |Compiler.""".stripMargin

  val ExpectedText40CharactersPerLine: String =
    """|In 1991, while studying computer science
       |at University of Helsinki, Linus
       |Torvalds began a project that later
       |became the Linux kernel. He wrote the
       |program specifically for the hardware he
       |was using and independent of an
       |operating system because he wanted to
       |use the functions of his new PC with an
       |80386 processor. Development was done on
       |MINIX using the GNU C Compiler.""".stripMargin

  val ExpectedText50CharactersPerLine: String = """In 1991, while studying computer science at
                                                  |University of Helsinki, Linus Torvalds began a
                                                  |project that later became the Linux kernel. He
                                                  |wrote the program specifically for the hardware he
                                                  |was using and independent of an operating system
                                                  |because he wanted to use the functions of his new
                                                  |PC with an 80386 processor. Development was done
                                                  |on MINIX using the GNU C Compiler.""".stripMargin

  val MinimumAllowedNumberOfWordsPerLine: String = """In
                                                     |1991,
                                                     |while
                                                     |studying
                                                     |computer
                                                     |science
                                                     |at
                                                     |University
                                                     |of
                                                     |Helsinki,
                                                     |Linus
                                                     |Torvalds
                                                     |began
                                                     |a
                                                     |project
                                                     |that
                                                     |later
                                                     |became
                                                     |the
                                                     |Linux
                                                     |kernel.
                                                     |He
                                                     |wrote
                                                     |the
                                                     |program
                                                     |specifically
                                                     |for
                                                     |the
                                                     |hardware
                                                     |he
                                                     |was
                                                     |using
                                                     |and
                                                     |independent
                                                     |of
                                                     |an
                                                     |operating
                                                     |system
                                                     |because
                                                     |he
                                                     |wanted
                                                     |to
                                                     |use
                                                     |the
                                                     |functions
                                                     |of
                                                     |his
                                                     |new
                                                     |PC
                                                     |with
                                                     |an
                                                     |80386
                                                     |processor.
                                                     |Development
                                                     |was
                                                     |done
                                                     |on
                                                     |MINIX
                                                     |using
                                                     |the
                                                     |GNU
                                                     |C
                                                     |Compiler.""".stripMargin

