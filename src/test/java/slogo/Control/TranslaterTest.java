package slogo.Control;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TranslaterTest {
  private Translater myParser;

  @BeforeEach
  void setUp() {
    myParser = new Translater();
    // order added matters
  }

  @Test
  void getCommands() {
    //needs to call parseText first
    assertEquals(myParser.validCommands, null);
  }

  @Test
  void addPatterns()
      throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(myParser.mySymbols, "[ClearScreen=clearscreen|cs, IsShowing=showing\\?|showingp, Left=left|lt, Or=or, SetPosition=setxy|goto, Product=product|\\*, Sine=sine|sin, Repeat=repeat, Difference=difference|-, MakeVariable=make|set, GreaterEqual=greaterequal\\?|\\>\\=, LessThan=less\\?|\\<, IsPenDown=pendown\\?|pendownp, Random=random|rand, GreaterThan=greater\\?|\\>, Equal=equal\\?|\\=\\=, SetHeading=setheading|seth, Pi=pi, PlayButton=Play, YCoordinate=ycor, NotEqual=notequal\\?|\\!\\=, LessEqual=lessequal\\?|\\<\\=, For=for, Sum=sum|\\+, ArcTangent=arctangent|atan, Not=not, And=and, ClearHistory=Clear History, DoTimes=dotimes, XCoordinate=xcor, SetTowards=towards, If=if, Minus=minus|~, HideTurtle=hideturtle|ht, Cosine=cosine|cos, PenDown=pendown|pd, Heading=heading, IfElse=ifelse, Right=right|rt, Remainder=remainder|%, Backward=back|bk, SquareRoot=squareroot|sqrt, NaturalLog=log, Home=home, PenUp=penup|pu, Tangent=tangent|tan, MakeUserInstruction=to, RandomRange=randomrange|randr, SaveFile=Save File, LoadFile=Load File, Forward=forward|fd, ShowTurtle=showturtle|st, Quotient=quotient|/, Power=power|pow]\n");
  }


  @Test
  void match() {
    assertEquals(myParser.match("", Pattern.compile("-?[0-9]+\\.?[0-9]*\n")), false);

  }

  @Test
  void reset() {
    assertEquals(myParser.mySymbols, null);
  }

  @Test
  void readFile() throws IOException, CommandException {
    assertEquals(myParser.readFile("data/examples/simple/forward.slogo"),
        "# the most basic logo command possible\n"
            + "fd 50\n");
  }

  @Test
  void main() {
  }
}